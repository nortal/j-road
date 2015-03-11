package com.nortal.jroad.client.dhl;

import static com.nortal.jroad.client.dhl.DhlXTeeService.SendStatus.SENT;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.impl.util.Base64;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nortal.jroad.client.dhl.DhlXTeeService.ContentToSend;
import com.nortal.jroad.client.dhl.DhlXTeeService.GetDvkOrganizationsHelper;
import com.nortal.jroad.client.dhl.DhlXTeeService.MetainfoHelper;
import com.nortal.jroad.client.dhl.DhlXTeeService.ReceivedDocumentsWrapper;
import com.nortal.jroad.client.dhl.DhlXTeeService.ReceivedDocumentsWrapper.ReceivedDocument;
import com.nortal.jroad.client.dhl.DhlXTeeService.SendStatus;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.AadressType;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.DhlDokumentType;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.EdastusDocument;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.EdastusDocument.Edastus;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.FaultDocument.Fault;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.TagasisideType;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.TransportDocument.Transport;
import com.nortal.jroad.client.dhl.types.ee.riik.xtee.dhl.producers.producer.dhl.GetSendStatusResponseTypeUnencoded.Item;
import com.nortal.jroad.client.dhl.types.ee.riik.xtee.dhl.producers.producer.dhl.OccupationType;
import com.nortal.jroad.client.dhl.types.ee.sk.digiDoc.v13.DataFileType;
import com.nortal.jroad.client.dhl.types.ee.sk.digiDoc.v13.SignedDocType;
import com.nortal.jroad.client.service.configuration.provider.XTeeProviderPropertiesResolver;

/**
 * @author ats.uiboupin
 */
public class DhlXTeeServiceImplTest extends TestCase {

    private static Log log = LogFactory.getLog(DhlXTeeServiceImplTest.class);
    private static DhlXTeeService dhl;
    private static XTeeProviderPropertiesResolver propertiesResolver;

    private static String senderRegNr;
    private static List<String> receivedDocumentIds;
    private static boolean receivedDocumentsFailed;
    private static List<String> receiveFaileddDocumentIds;
    private static Set<String> sentDocIds = new HashSet<String>();
    private static Map<String, String> dvkOrgList;

    private static final String RECEIVE_OUTPUT_DIR = System.getProperty("java.io.tmpdir");
    private static final String DVK_ORGANIZATIONS_CACHEFILE = RECEIVE_OUTPUT_DIR + "/dvkOrganizationsCache.ser";
    private static final File TEST_FILES_TO_SEND_FOLDER = new File("src/test/resources/testFilesToSend");

    private static boolean markOnlyTestDocumentsRead = true;

    private static DhlXTeeService.DvkOrganizationsUpdateStrategy cachePeriodUpdateStrategy //
    = new DhlXTeeService.DvkOrganizationsCacheingUpdateStrategy().setMaxUpdateInterval(24).setTimeUnit(Calendar.HOUR);
    private static List<String> recipients;
    private boolean executedGetSendingOptions;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        if (dhl == null) {
            // final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("service-impl-test.xml");
            final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("client-test.xml");
            dhl = (DhlXTeeService) context.getBean("dhlXTeeService");
            propertiesResolver = (XTeeProviderPropertiesResolver) context.getBean("xTeeServicePropertiesResolver");
        }
        senderRegNr = propertiesResolver.getProperty("x-tee.institution");
        recipients = Arrays.asList(senderRegNr); // testiks nii saatjale endale kui INTERINX OÜ(10425769)
    }

    // shared with higher level test classes of dvk service
    public static List<String> getRecipients() {
        senderRegNr = senderRegNr == null ? "10391131" : senderRegNr;
        recipients = Arrays.asList(
                senderRegNr // Saatjale endale
                // , "44000122" // Tallinna Ülikooli Ajaloo Instituut
                // , "64000122" // Tallinna Ülikooli Infoteaduse Instituut
                // , "54000122" // Tallinna Ülikooli Psühholoogia Instituut
                );
        return recipients;
    }

    public void testWarmUp() {
        log.debug("warmup done to get better time measure for the first test");
    }

    public void testGetSendingOptions() {
        dvkOrgList = dhl.getSendingOptions();
        writeCacheToFile(dvkOrgList, Calendar.getInstance());
        log.debug("got " + dvkOrgList.size() + " organizations:");
        assertTrue(dvkOrgList.size() > 0);
        for (String regNr : dvkOrgList.keySet()) {
            log.debug("\tregNr: " + regNr + "\t- " + dvkOrgList.get(regNr));
        }
        executedGetSendingOptions = true;
    }

    public void testGetDvkOrganizationsHelper() {
        log.debug("testGetDvkOrganizationsHelper dhl=" + dhl);
        GetDvkOrganizationsHelper dvkOrganizationsHelper = dhl.getDvkOrganizationsHelper();
        dvkOrganizationsHelper.setUpdateStrategy(cachePeriodUpdateStrategy);
        final Object[] cacheAndTime = readCacheFromFile();
        if (cacheAndTime != null) {
            @SuppressWarnings("unchecked")
            final Map<String, String> cacheFromFile = (Map<String, String>) cacheAndTime[0];
            dvkOrganizationsHelper.setDvkOrganizationsCache(cacheFromFile);
            cachePeriodUpdateStrategy.setLastUpdated((Calendar) cacheAndTime[1]);
        }
        // dvkOrganizationsHelper.setUpdateStrategy(neverUpdateStrategy);
        Map<String, String> dvkOrganizationsCache = dvkOrganizationsHelper.getDvkOrganizationsCache();
        assertTrue(dvkOrganizationsCache.size() > 0);
        if (executedGetSendingOptions) { // if executed getSendingOptions service call, lets compare results
            assertEquals(dvkOrgList.size(), dvkOrganizationsCache.size());
            for (String regNr : dvkOrgList.keySet()) {
                String orgName = dvkOrgList.get(regNr);
                String cachedOrgName = dvkOrganizationsCache.get(regNr);
                assertNotNull(orgName);
                assertNotNull(cachedOrgName);
                assertTrue(orgName.equalsIgnoreCase(cachedOrgName));
            }
            String testRegNr = dvkOrgList.keySet().iterator().next();
            String testOrgName = dvkOrgList.get(testRegNr);
            String cachedOrgName = dvkOrganizationsHelper.getOrganizationName(testRegNr);
            assertEquals(cachedOrgName, testOrgName);
        }
    }

    public void testSendDocuments() {
        final Set<ContentToSend> contentsToSend = getContentsToSend();
        AadressType[] recipientsArray = new AadressType[recipients.size()];
        assertTrue(recipients.size() > 0);
        for (int i = 0; i < recipientsArray.length; i++) {
            recipientsArray[i] = getRecipient(recipients.get(i));
        }
        sentDocIds = dhl.sendDocuments(contentsToSend, recipientsArray, getSenderAddress(), null, null);
        assertTrue("Supprize! sendDocuments indeed can return multiple dhl_id's! sentDocIds=" + sentDocIds, sentDocIds.size() > 0);
        for (String dhlId : sentDocIds) {
            log.info("\tdocument sent to DVK, dhlId=" + dhlId);
            assertTrue(StringUtils.isNotBlank(dhlId));
        }
    }

    public void testGetSendStatus1() {
        final List<Item> items = dhl.getSendStatuses(sentDocIds);
        log.debug("got " + items.size() + " items with send statuses:");
        assertTrue("expected to receive at least one DVK dokument, but got " + items.size(), items.size() > 0 || sentDocIds.size() == 0);
        for (Item item : items) {
            log.debug("\titem=" + item);
            String dhlId = item.getDhlId();
            String olek = item.getOlek();
            Assert.assertNotNull(dhlId);
            Assert.assertNotNull(olek);
            log.debug("\tdhlId=" + dhlId);
            log.debug("\tolek=" + olek);
            assertTrue(SendStatus.get(olek).equals(SENT));
            List<Edastus> edastusList = item.getEdastusList();
            log.debug("\tedastusList " + edastusList.size());
            Assert.assertTrue(edastusList.size() > 0);
            for (Edastus edastus : edastusList) {
                log.debug("\t\tedastus=" + edastus);

                Calendar saadud = edastus.getSaadud();
                EdastusDocument.Edastus.Meetod.Enum meetod = edastus.getMeetod();
                Calendar loetud = edastus.getLoetud();
                EdastusDocument.Edastus.Staatus.Enum staatus = edastus.getStaatus();
                BigInteger vStaatus = edastus.getVastuvotjaStaatusId();

                log.debug("\t\tsaadud=" + saadud);
                log.debug("\t\t\tmeetod=" + meetod);
                log.debug("\t\tloetud=" + loetud);
                log.debug("\t\tstaatus=" + staatus);
                assertTrue(SendStatus.get(staatus).equals(SENT));

                log.debug("\t\tvStaatus=" + vStaatus);
                Assert.assertNotNull(vStaatus);
                final AadressType saaja = edastus.getSaaja();

                final String regnr = saaja.getRegnr();
                final String asutuseNimi = saaja.getAsutuseNimi();
                log.debug("\t\tsaaja regnr=" + regnr);
                log.debug("\t\tsaaja asutuseNimi=" + asutuseNimi);
            }
        }
    }

    /**
     * Test method for {@link DhlXTeeService#receiveDocuments(int)
     */
    public void testReceiveDocuments() {
        receivedDocumentsFailed = true;
        receivedDocumentIds = new ArrayList<String>(); // using static field to be able to use the result in other tests
        receiveFaileddDocumentIds = new ArrayList<String>(); // using static field to be able to use the result in other tests
        System.gc();// perform GC to free max memory for receiving documents before opening remote connection
        final ReceivedDocumentsWrapper receiveDocuments = dhl.receiveDocuments(300);
        assertTrue(receiveDocuments.size() > 0 || sentDocIds.size() == 0);
        for (String dhlId : receiveDocuments) {
            final ReceivedDocument receivedDocument = receiveDocuments.get(dhlId);
            final MetainfoHelper metaInfoHelper = receivedDocument.getMetaInfoHelper();
            final DhlDokumentType dhlDokument = receivedDocument.getDhlDocument();
            final SignedDocType signedDoc = receivedDocument.getSignedDoc();
            log.debug("dokument element=" + dhlDokument + "'");
            log.debug("helper.getObject(DhlIdDocumentImpl)=" + dhlId + " " + metaInfoHelper.getDhlSaatjaAsutuseNimi() + " "
                    + metaInfoHelper.getDhlSaatjaAsutuseNr() + " saadeti: " + metaInfoHelper.getDhlSaatmisAeg() + " saabus: "
                    + metaInfoHelper.getDhlSaabumisAeg());
            assertTrue(StringUtils.isNotBlank(dhlId));
            Transport transport = dhlDokument.getTransport();
            AadressType saatja = transport.getSaatja();
            assertTrue(StringUtils.isNotBlank(saatja.getRegnr()));
            log.debug("sender: " + saatja.getRegnr() + " : " + saatja.getAsutuseNimi());
            final List<AadressType> recipients = transport.getSaajaList();
            log.debug("document was sent to " + recipients.size() + " recipients:");
            assertTrue(recipients.size() > 0);
            for (AadressType recipient : recipients) {
                String regnr = recipient.getRegnr();
                log.debug("\trecipient:" + regnr + ": " + recipient.getAsutuseNimi());
                assertTrue(StringUtils.isNotBlank(regnr));
            }
            try {
                List<DataFileType> dataFileList = signedDoc.getDataFileList();
                log.debug("document contain " + dataFileList.size() + " datafiles: " + dataFileList);
                for (DataFileType dataFile : dataFileList) {
                    try {
                        File outFile = File.createTempFile("DVK_" + dhlId + "_" + dataFile.getId() + "_", dataFile.getFilename());
                        log.debug("writing file '" + dataFile.getFilename() + "' from dvk document with dhlId '" + dataFile.getId() + "'  to file '"
                                + outFile.getAbsolutePath() + "'");
                        OutputStream os = new FileOutputStream(outFile);
                        os.write(Base64.decode(dataFile.getStringValue().getBytes()));
                        os.close();
                        if (!outFile.delete()) {
                            log.warn("didn't manage to delete " + outFile.getAbsolutePath() + "");
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException("", e);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed write output to temporary file ", e);
                    }
                }
            } catch (RuntimeException e) {
                log.error("signedDoc=" + signedDoc + ", dhlDokument=" + dhlDokument + ", can't get dataFileList from dhlDokument:\n" + dhlDokument + "\n\n", e);
                receiveFaileddDocumentIds.add(dhlId);
                continue;
            }
            receivedDocumentIds.add(dhlId);
        }
        log.debug("received " + receivedDocumentIds.size() + " documents: " + receivedDocumentIds);
        log.debug("FAILED to receive " + receiveFaileddDocumentIds.size() + " documents: " + receiveFaileddDocumentIds);
        assertTrue(sentDocIds == null || receivedDocumentIds.containsAll(sentDocIds));
        for (String dhlId : receiveFaileddDocumentIds) {
            assertFalse(sentDocIds.contains(dhlId));
        }
        receivedDocumentsFailed = false;
    }

    public void testMarkDocumentsReceived() {
        final Collection<String> docsToMarkRead;
        if (markOnlyTestDocumentsRead) {
            // don't mark those documents read that were not sent during this test - someone might acutaly
            // be waiting for them to arrive
            docsToMarkRead = sentDocIds;
        } else {
            if (receivedDocumentsFailed) {
                if (receivedDocumentIds == null) {
                    receivedDocumentIds = new ArrayList<String>();
                }
                // if call to receivedDocuments failed, then marking those documents read, that were sent for testing
                receivedDocumentIds.addAll(sentDocIds);
            }
            docsToMarkRead = receivedDocumentIds;
        }
        log.info("Starting to mark " + (markOnlyTestDocumentsRead ? "only test" : "received") + " document received - receivedDocumentIds=" + docsToMarkRead);
        dhl.markDocumentsReceived(docsToMarkRead);
    }

    public void testMarkDocumentsReceivedV2() {
        final Collection<String> dhlIdsToMarkRead;
        if (markOnlyTestDocumentsRead) {
            // don't mark those documents read that were not sent during this test - someone might acutaly
            // be waiting for them to arrive
            dhlIdsToMarkRead = sentDocIds;
        } else {
            if (receivedDocumentsFailed) {
                if (receivedDocumentIds == null) {
                    receivedDocumentIds = new ArrayList<String>();
                }
                // if call to receivedDocuments failed, then marking those documents read, that were sent for testing
                receivedDocumentIds.addAll(sentDocIds);
            }
            dhlIdsToMarkRead = receivedDocumentIds;
        }
        dhlIdsToMarkRead.addAll(Arrays.asList("22242", "22243", "22244"));

        log.info("Starting to mark " + (markOnlyTestDocumentsRead ? "only test" : "received") + " document received - receivedDocumentIds=" + dhlIdsToMarkRead);
        List<TagasisideType> docsToMarkReadV2 = new ArrayList<TagasisideType>();
        for (String dhlId : dhlIdsToMarkRead) {
            addFault(docsToMarkReadV2, dhlId, "1", "Client", "This test didn't like the document ;)",
                    "just testing, probably there was nothing wrong with the document");
        }
        dhl.markDocumentsReceivedV2(docsToMarkReadV2);
    }

    private void addFault(List<TagasisideType> docsToMarkReadV2, String dhlId, String faultcode, String faultactor, String faultString, String faultDetail) {
        TagasisideType failedToReceiveInfo = TagasisideType.Factory.newInstance();
        failedToReceiveInfo.setDhlId(BigInteger.valueOf(Long.valueOf(dhlId)));
        Fault fault = failedToReceiveInfo.addNewFault();
        fault.setFaultcode(faultcode);
        fault.setFaultactor(faultactor);
        fault.setFaultstring(faultString);
        fault.setFaultdetail(faultDetail);
        docsToMarkReadV2.add(failedToReceiveInfo);
    }

    private void markAllDocumentsReceived(final Collection<String> docsToMarkRead, int fromDhlId, int toDhlId) {
        for (int i = fromDhlId; i <= toDhlId; i++) {
            log.info("Starting to mark " + (markOnlyTestDocumentsRead ? "only test" : "received") + " document received - receivedDocumentIds="
                    + docsToMarkRead);
            try {
                dhl.markDocumentsReceived(Arrays.asList(i + ""));
            } catch (RuntimeException e) {
                log.error(i + ". failed: " + e.getMessage());
            }
        }
    }

    /**
     * Test method for {@link com.nortal.jroad.dvk.service.impl.DvkServiceImpl#getSendStatuses(String)
     */
    public void testGetSendStatus2() {
        final List<Item> items = dhl.getSendStatuses(sentDocIds);
        assertTrue("expected to receive at least one DVK dokument, but got " + items.size(), items.size() > 0 || sentDocIds.size() == 0);
        final List<String[]> unreceivedDhlIds = new ArrayList<String[]>();
        Assert.assertTrue("Sent " + sentDocIds.size() + ", but got " + items.size() + " sendstatuses", items.size() > 0 || sentDocIds.size() == 0);
        for (Item item : items) {
            log.debug("--item=" + item);
            String dhlId = item.getDhlId();
            String olek = item.getOlek();
            Assert.assertNotNull(dhlId);
            Assert.assertNotNull(olek);
            log.debug("--dhlId=" + dhlId);
            log.debug("--olek=" + olek);
            List<Edastus> edastusList = item.getEdastusList();
            Assert.assertTrue(edastusList != null && edastusList.size() > 0);
            boolean oneNotReceived = false;
            for (Edastus edastus : edastusList) {
                // edastus = (Edastus)XmlObject.Factory.parse(edastus.toString(), new XmlOptions().setDocumentType(EdastusDocument.Edastus.type));
                log.debug("\tedastus=" + edastus);

                Calendar saadud = edastus.getSaadud();
                EdastusDocument.Edastus.Meetod.Enum meetod = edastus.getMeetod();
                Calendar loetud = edastus.getLoetud();
                EdastusDocument.Edastus.Staatus.Enum staatus = edastus.getStaatus();
                BigInteger vStaatus = edastus.getVastuvotjaStaatusId();

                log.debug("\tsaadud=" + saadud);
                log.debug("\tmeetod=" + meetod);
                log.debug("\tloetud=" + loetud);
                log.debug("\tstaatus=" + staatus);
                log.debug("\tvStaatus=" + vStaatus);
                Assert.assertNotNull(vStaatus);
                final AadressType saaja = edastus.getSaaja();

                final String regnr = saaja.getRegnr();
                final String asutuseNimi = saaja.getAsutuseNimi();
                final SendStatus sendStatus = SendStatus.get(staatus);
                if (regnr.equalsIgnoreCase(senderRegNr)) {
                    if (!sendStatus.equals(SendStatus.CANCELLED)) { // testMarkDocumentsReceivedV2 marks document CANCELLED
                        unreceivedDhlIds.add(new String[] { dhlId, "Document has not been received - current status=" + sendStatus });
                    }
                }
                if (sendStatus.equals(SENT)) {
                    oneNotReceived = true;
                }
                log.debug("\tsaaja regnr=" + regnr);
                log.debug("\tsaaja asutuseNimi=" + asutuseNimi);
            }
            // assertTrue(oneNotReceived ? SendStatus.get(olek).equals(SENT) : SendStatus.get(olek).equals(RECEIVED)); // kui üle 1 saaja, siis ilmselt pole
            // saadetud
        }
        if (unreceivedDhlIds.size() > 0) {
            String errMsg = null;
            final Set<String> dhlIds = new HashSet<String>();
            for (String[] objects : unreceivedDhlIds) {
                errMsg = objects[1];
                dhlIds.add(objects[0]);
            }
            assertTrue(errMsg + ". DhlIds=" + dhlIds, false);
        }
    }

    public void testGetOccupationList() {
        List<OccupationType> responseList = dhl.getOccupationList(Arrays.asList(senderRegNr));
        log.debug("Occupations list contains " + responseList.size() + " occupations:");
        assertTrue(responseList.size() > 0);
        for (OccupationType institutionType : responseList) {
            log.debug("\t" + institutionType.getAsutuseKood() + ":\t" + institutionType.getNimetus() + "\t " + institutionType.getKood());
            assertTrue(StringUtils.isNotBlank(institutionType.getAsutuseKood()));
        }
    }

    private AadressType getRecipient(String regNr) {
        AadressType recipient = AadressType.Factory.newInstance();
        recipient.setRegnr(regNr);
        // recipient.setAsutuseNimi(recipientName); // set in DhlXTeeServiceImpl.constructDokumentDocument() based on regNr
        log.debug("recipient: " + ToStringBuilder.reflectionToString(recipient) + "'");
        return recipient;
    }

    private AadressType getSenderAddress() {
        AadressType sender = AadressType.Factory.newInstance();
        sender.setRegnr(senderRegNr);
        // sender.setAsutuseNimi(senderName); // set in DhlXTeeServiceImpl.constructDokumentDocument() based on regNr
        log.debug("Sender: " + ToStringBuilder.reflectionToString(sender) + "'");
        return sender;
    }

    /**
     * @return content to send
     */
    public static Set<ContentToSend> getContentsToSend() {
        final HashSet<ContentToSend> contentsToSend = new HashSet<ContentToSend>();
        try {
            final ContentToSend content1 = new ContentToSend();
            final ContentToSend content2 = new ContentToSend();

            final ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
            final ByteArrayOutputStream bos2 = new ByteArrayOutputStream();

            BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(bos1));
            BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(bos2));

            DateFormat df = new SimpleDateFormat("d HH:mm:ss");
            out1.write("testfile1 " + df.format(Calendar.getInstance().getTime()));
            out1.close();
            out2.write("testfile2 žõäöüš");
            out2.close();

            content1.setFileName("test1.txt");
            content1.setInputStream(new ByteArrayInputStream(bos1.toByteArray()));
            String mimeTypeTextPlain = "text/plain";
            content1.setMimeType(mimeTypeTextPlain);

            content2.setFileName("test2.txt");
            content2.setInputStream(new ByteArrayInputStream(bos2.toByteArray()));
            content2.setMimeType(mimeTypeTextPlain);

            contentsToSend.add(content1);
            contentsToSend.add(content2);
            contentsToSend.add(getContentFromTestFile("document1.docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
            contentsToSend.add(getContentFromTestFile("tekstifail-iso-8859-1.txt", mimeTypeTextPlain));
            contentsToSend.add(getContentFromTestFile("tekstifail-utf-8.txt", mimeTypeTextPlain));
            contentsToSend.add(getContentFromTestFile("digidocSigned.ddoc", "application/digidoc"));
            final File file = new File("/tmp/dvkTest.rar");
            if (file.exists()) {
                contentsToSend.add(getContentFromFile(null, null, file));
            }
            return contentsToSend;
        } catch (IOException e) {
            throw new RuntimeException("Failed to create test content to be sent to DVK", e);
        }
    }

    private static ContentToSend getContentFromTestFile(String fileName, String mimeType) throws FileNotFoundException {
        return getContentFromFile(fileName, mimeType, new File(TEST_FILES_TO_SEND_FOLDER, fileName));
    }

    private static ContentToSend getContentFromFile(String fileName, String mimeType, File fileToSend) throws FileNotFoundException {
        final ContentToSend content3 = new ContentToSend();
        content3.setInputStream(new FileInputStream(fileToSend));
        content3.setFileName(fileName != null ? fileName : fileToSend.getName());
        content3.setMimeType(mimeType != null ? mimeType : "application/octet-stream");
        return content3;
    }

    private void writeCacheToFile(Map<String, String> dvkOrganizationsCache, Calendar updateTime) {
        try {
            File serFile = new File(DVK_ORGANIZATIONS_CACHEFILE);
            if (!serFile.exists()) {
                serFile.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFile));
            oos.writeObject(updateTime);
            oos.writeObject(dvkOrganizationsCache);
            IOUtils.closeQuietly(oos);
            log.debug("wrote data to " + serFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("failed to serialize organizations cache to file", e);
        }
    }

    private Object[] readCacheFromFile() {
        File serFile = new File(DVK_ORGANIZATIONS_CACHEFILE);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFile));
            Calendar cal = (Calendar) ois.readObject();
            @SuppressWarnings("unchecked")
            Map<String, String> dvkOrganizationsCache = (Map<String, String>) ois.readObject();
            return new Object[] { dvkOrganizationsCache, cal };
        } catch (FileNotFoundException e) {
            log.debug("Didn't find serialized cache file");
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error reading in cache file", e);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
