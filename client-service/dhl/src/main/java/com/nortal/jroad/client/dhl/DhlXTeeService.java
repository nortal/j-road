package com.nortal.jroad.client.dhl;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.AadressType;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.DhlDokumentType;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.DokumentDocument;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.EdastusDocument.Edastus;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.MetainfoDocument.Metainfo;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl.TagasisideType;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl_meta_automatic.impl.DhlIdDocumentImpl;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl_meta_automatic.impl.DhlSaabumisaegDocumentImpl;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl_meta_automatic.impl.DhlSaatjaAsutuseNimiDocumentImpl;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl_meta_automatic.impl.DhlSaatjaAsutuseNrDocumentImpl;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl_meta_automatic.impl.DhlSaatjaEpostDocumentImpl;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl_meta_automatic.impl.DhlSaatmisaegDocumentImpl;
import com.nortal.jroad.client.dhl.types.ee.riik.schemas.dhl_meta_manual.impl.KoostajaFailinimiDocumentImpl;
import com.nortal.jroad.client.dhl.types.ee.riik.xtee.dhl.producers.producer.dhl.GetSendStatusResponseTypeUnencoded.Item;
import com.nortal.jroad.client.dhl.types.ee.riik.xtee.dhl.producers.producer.dhl.OccupationType;
import com.nortal.jroad.client.dhl.types.ee.riik.xtee.dhl.producers.producer.dhl.SendDocumentsV2RequestType;
import com.nortal.jroad.client.dhl.types.ee.sk.digiDoc.v13.SignedDocType;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

/**
 * @author ats.uiboupin
 */
public interface DhlXTeeService {

    public enum SendStatus {
        /** Document is sent to DVK, but some recipients have not received it(marked this document as read) */
        SENT("saatmisel"),
                /** Document is sent to DVK and all recipients have received it(marked it read) */
                RECEIVED("saadetud"),
                /** Document is cancelled (deleteOldDocuments service has been called by the DVK administrator) */
                CANCELLED("katkestatud");

        String statusCode;

        SendStatus(String statusCode) {
            this.statusCode = statusCode;
        }

        public static SendStatus get(String parameterName) {
            final SendStatus[] values = SendStatus.values();
            for (SendStatus parameter : values) {
                if (parameter.statusCode.equals(parameterName)) {
                    return parameter;
                }
            }
            throw new IllegalArgumentException("Unknown status: " + parameterName);
        }

        /**
         * @param staatus - string based enum generated from schema
         * @return SendStatus Enum from string based "Enum"
         */
        public static SendStatus get(Edastus.Staatus.Enum staatus) {
            return get(staatus.toString());
        }

        @Override
        public String toString() {
            return statusCode;
        }

    }

    /**
     * @return organizations(regNr, name) that are capable of communicating with DVK
     */
    Map<String/* regNr */, String/* name */> getSendingOptions();

    /**
     * @see {@link #sendDocuments(Collection, AadressType[], AadressType, SendDocumentsDokumentCallback)}
     */
    Set<String> sendDocuments(Collection<ContentToSend> contentsToSend, AadressType[] recipients, AadressType sender);

    /**
     * Composes and sends document to given recipients.
     * 
     * @param contentsToSend - wrapper containing input stream of data with file name and mimeType to be assigned to the DVK document to be sent.
     * @param recipients
     * @param sender
     * @param callback - optional callBack implementation to be called by the service method when the document is composed, allowing to change content of
     *            <i>"dokument"</i> as desired.
     * @return dhl_Id's of the sent document
     */
    Set<String> sendDocuments(Collection<ContentToSend> contentsToSend, AadressType[] recipients, AadressType sender, SendDocumentsDokumentCallback callback,
            SendDocumentsRequestCallback requestCallback);

    /**
     * @param ids - set of id's to be used to query statuses for.
     * @return list of items containing single document status information.
     */
    List<Item> getSendStatuses(Set<String> ids);

    /**
     * @param maxNrOfDocuments maximum number of documents that will be returned with the service call
     * @return
     */
    ReceivedDocumentsWrapper receiveDocuments(int maxNrOfDocuments);

    /**
     * @param receivedDocumentIds -
     */
    void markDocumentsReceived(Collection<String> receivedDocumentIds);

    /**
     * Allows to mark documents received lik {@link #markDocumentsReceived(Collection)}, but also enables to add some additional information.<br>
     * For example when you discover a virus or fail to process the DVK dokument
     * 
     * @param receivedDocsInfos
     */
    void markDocumentsReceivedV2(Collection<TagasisideType> receivedDocsInfos);

    // void runSystemCheck();

    List<OccupationType> getOccupationList(List<String> institutionRegNrs);

    /**
     * Callback interface, that can be used to alter <i>"dokument"</i> element after it has been composed <br>
     * (just before attaching it to request body and making the service call)
     */
    interface SendDocumentsDokumentCallback {
        void doWithDocument(DokumentDocument dokumentDocument);
    }

    /**
     * Callback interface, that can be used to alter request body just before making the service call
     */
    interface SendDocumentsRequestCallback {
        void doWithRequest(SendDocumentsV2RequestType request);
    }

    interface GetDvkOrganizationsHelper {

        String getOrganizationName(String regnr);

        Map<String, String> getDvkOrganizationsCache();

        /**
         * makes service call to retrieve up-to-date organisations list
         */
        void updateDvkCapableOrganisationsCache();

        /**
         * @param organizationsCache to be used
         */
        void setDvkOrganizationsCache(Map<String, String> organizationsCache);

        DvkOrganizationsUpdateStrategy getUpdateStrategy();

        void setUpdateStrategy(DvkOrganizationsUpdateStrategy updateStrategy);

    }

    /**
     * @author ats.uiboupin
     *         Strategy pattern implementation for deciding whether or not to update DVK capable organizations list
     */
    interface DvkOrganizationsUpdateStrategy {

        /**
         * @param cachedOrganisationName - name(or <code>null</code>) fetched from the cache based on organization registry number.
         * @return true if updating cache should be done when such organization name(or null) is fetched from the cached list, false otherwise
         */
        boolean update4getOrganizationName(String cachedOrganisationName);

        /**
         * @param dvkCapableOrganizations
         * @return
         */
        boolean update4getDvkOrganizationsCache(Map<String, String> dvkCapableOrganizations);

        /**
         * Concrete strategy implementation might do decisions based on time when cache was last updated.
         * 
         * @param lastUpdate - time when the cache was last successfully updated.
         */
        void setLastUpdated(Calendar lastUpdate);

    }

    /**
     * @author ats.uiboupin
     *         Simple strategy implementation, see #update4getRecipientName() and #update4getDvkOrganizationsCache
     */
    class DvkOrganizationsCacheingUpdateStrategy implements DvkOrganizationsUpdateStrategy {

        private static org.apache.commons.logging.Log log //
        = org.apache.commons.logging.LogFactory.getLog(DhlXTeeService.DvkOrganizationsCacheingUpdateStrategy.class);

        private Calendar lastUpdated;
        private int maxUpdateInterval = 24 * 60; // 24h
        private int timeUnit = Calendar.HOUR;

        /**
         * Update only if given <code>cachedOrganisationName</code> is not empty.
         */
        public boolean update4getOrganizationName(String cachedOrganisationName) {
            return StringUtils.isBlank(cachedOrganisationName); // only update when organisation name not found
        }

        /**
         * asks to update cache when asking if last update was more than <code>maxUpdateInterval</code> minutes ago.
         */
        public boolean update4getDvkOrganizationsCache(Map<String, String> dvkCapableOrganizations) {
            Calendar cal = Calendar.getInstance();
            cal.add(timeUnit, -maxUpdateInterval);
            return dvkCapableOrganizations == null || dvkCapableOrganizations.isEmpty() || lastUpdated == null || lastUpdated.before(cal);
        }

        // START: Getters / setters
        public int getMaxUpdateInterval() {
            return maxUpdateInterval;
        }

        public DvkOrganizationsCacheingUpdateStrategy setMaxUpdateInterval(int maxUpdateInterval) {
            this.maxUpdateInterval = maxUpdateInterval;
            return this;
        }

        public int getTimeUnit() {
            return timeUnit;
        }

        /**
         * @param timeUnit must be Calendar field(i.e. Calendar.MINUTE)
         * @return
         */
        public DvkOrganizationsCacheingUpdateStrategy setTimeUnit(int timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }

        public void setLastUpdated(Calendar date) {
            if (log.isDebugEnabled()) {
                log.debug("cache updated at: " + (new SimpleDateFormat().format(date.getTime())));
            }
            this.lastUpdated = date;
        }
        // END: Getters / setters
    }

    public interface ReceivedDocumentsWrapper extends Map<String, ReceivedDocumentsWrapper.ReceivedDocument>, Iterable<String> {
        public Iterator<String> iterator();

        public Set<Entry<String, ReceivedDocument>> entrySet();

        public Map<String, ReceivedDocument> getDhlDocumentsMap();

        public List<DhlDokumentType> getReceivedDocuments();

        public interface ReceivedDocument {
            public DhlDokumentType getDhlDocument();

            public SignedDocType getSignedDoc();

            public MetainfoHelper getMetaInfoHelper();

        }

        /**
         * @return file that contains response (dhl:dokument elements from response attachment) if saving documents is enabled, null otherwise
         */
        File getResponseDocumentsXml();

    }

    class ContentToSend {
        private String fileName;
        private String mimeType;
        private InputStream inputStream;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public InputStream getInputStream() {
            return inputStream;
        }

        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }

    }

    /**
     * Helper class to work around parsing AnyType. <br>
     * Convenience methods could be created to the subclasses as follows:
     * 
     * <pre>
     * public String getDhlId() {
     *     // DhlIdDocumentImpl.class is class for representing &quot;dhl_id&quot; xml-element.
     *     return getObject(DhlIdDocumentImpl.class).getDhlId();
     * }
     * </pre>
     * 
     * @author ats.uiboupin
     * @see http://www.ws-i.org/Profiles/BasicProfile-1.2.html#soapenc_Array
     */
    class AnyTypeHelper {
        private static Log log = LogFactory.getLog(AnyTypeHelper.class);
        private final Map<Class<? extends XmlObject>, List<? extends XmlObject>> subElementsList;

        public AnyTypeHelper(XmlObject xmlObject) {
            subElementsList = parse(xmlObject); // NOPMD
        }

        protected Map<Class<? extends XmlObject>, List<? extends XmlObject>> parse(XmlObject xmlObject) {
            if (log.isTraceEnabled()) {
                log.trace("starting to parse xmlObject:\n" + xmlObject + "\n\n");
            }
            XmlCursor cursor = xmlObject.newCursor();
            cursor.toFirstChild();// move before the root element
            cursor.toFirstChild();// move to the first child of the root
            Map<Class<? extends XmlObject>, List<? extends XmlObject>> subElementsList = new HashMap<Class<? extends XmlObject>, List<? extends XmlObject>>();
            try {
                do {
                    XmlObject object = XmlObject.Factory.parse(cursor.getDomNode());
                    @SuppressWarnings("unchecked")
                    // to be able to add object that is in fact a subclass of XmlObject, but referenced using XmlObject
                    List<XmlObject> list = (List<XmlObject>) subElementsList.get(object.getClass());
                    if (list == null) {
                        list = new ArrayList<XmlObject>();
                    }
                    list.add(object);
                    subElementsList.put(object.getClass(), list);
                    log.debug("adding node: '" + cursor.getDomNode().getLocalName() + "' (" + cursor.getDomNode().getNamespaceURI()
                            + "),\nclass: " + object.getClass() + ", cursor: \n" + object);
                } while (cursor.toNextSibling());
            } catch (XmlException e) {
                throw new RuntimeException("Failed to parse xmlObject:\n" + xmlObject, e);
            }
            return subElementsList;
        }

        /**
         * Low-level method to retrieve any subelement by class
         * 
         * @param <T>
         * @param clazz - class of the subelement
         * @return subelement according to given class, null otherwise
         */
        public <T> T getObject(Class<T> clazz) {
            @SuppressWarnings("unchecked")
            List<T> objects = (List<T>) subElementsList.get(clazz);
            if (objects != null) {
                return objects.get(0);
            }
            return null;
        }

        @SuppressWarnings("unchecked")
        public <T> List<T> getObjects(Class<T> clazz) {
            return (List<T>) subElementsList.get(clazz);
        }

    }

    class MetainfoHelper extends AnyTypeHelper {

        public MetainfoHelper(Metainfo metainfo) {
            super(metainfo);
        }

        // START: Convenience methods to get values of subelements
        // START: methods for the fields created AUTOMATICALLY by DVK

        public String getDhlId() {
            return getObject(DhlIdDocumentImpl.class).getDhlId();
        }

        public String getDhlSaatjaAsutuseNr() {
            return getObject(DhlSaatjaAsutuseNrDocumentImpl.class).getDhlSaatjaAsutuseNr();
        }

        public String getDhlSaatjaAsutuseNimi() {
            return getObject(DhlSaatjaAsutuseNimiDocumentImpl.class).getDhlSaatjaAsutuseNimi();
        }

        /**
         * @return the time when DVK received the document
         */
        public Calendar getDhlSaabumisAeg() {
            return getObject(DhlSaabumisaegDocumentImpl.class).getDhlSaabumisaeg();
        }

        /**
         * @return the time when DVK sent out the document
         */
        public Calendar getDhlSaatmisAeg() {
            return getObject(DhlSaatmisaegDocumentImpl.class).getDhlSaatmisaeg();
        }

        public String getDhlSaatjaEpost() {
            final DhlSaatjaEpostDocumentImpl object = getObject(DhlSaatjaEpostDocumentImpl.class);
            return object == null ? null : object.getDhlSaatjaEpost();
        }

        /**
         * XXX: sarnaselt eelnevatele on võimalik kätte saada(automaatselt lisatavatest andmetest) veel näiteks:
         * dhl_saabumisviis, dhl_saatmisviis, dhl_saatja_asutuse_nimi, dhl_saatja_isikukood, dhl_saaja_asutuse_nr, dhl_saaja_asutuse_nimi, dhl_saaja_isikukood,
         * dhl_saaja_epost, dhl_kaust
         */

        // END: methods for the fields created AUTOMATICALLY by DVK
        // START: methods for the fields created MANUALLY by DVK

        public String getKoostajaFailinimi() {
            final KoostajaFailinimiDocumentImpl kfDoc = getObject(KoostajaFailinimiDocumentImpl.class);
            if (null != kfDoc) {
                return kfDoc.getKoostajaFailinimi().xmlText();
            }
            return null;
        }

        // END: methods for the fields created MANUALLY by DVK
        // END: Convenience methods to get values of subelements

    }

    /**
     * Wrapper(unchecked exception) for checked exception XRoadServiceConsumptionException
     * 
     * @author Ats Uiboupin
     */
    public class WrappedXRoadServiceConsumptionException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public WrappedXRoadServiceConsumptionException(XRoadServiceConsumptionException cause) {
            super(resolveMessage(cause), cause);
        }

        @Override
        public XRoadServiceConsumptionException getCause() {
            return (XRoadServiceConsumptionException) super.getCause();
        }

        private static String resolveMessage(XRoadServiceConsumptionException e) {
            return "Failed to execute xtee query " + e.getFullServiceName() + ". Fault(" + e.getFaultCode() + "): '" + e.getFaultString() + "'";
        }
    }

    // START: getters/setters
    GetDvkOrganizationsHelper getDvkOrganizationsHelper();

    void setDvkOrganizationsHelper(GetDvkOrganizationsHelper dvkOrganizationsHelper);

    // END: getters/setters

}
