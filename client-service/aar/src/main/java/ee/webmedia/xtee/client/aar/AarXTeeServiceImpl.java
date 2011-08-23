package ee.webmedia.xtee.client.aar;

import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.AsutusedParing;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.AsutusedParingManus;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.AsutusedParingManus.Asutused;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.AsutusedVastus;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.AsutusedVastusManus;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.TaitmisedParing;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.TaitmisedParingManus;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.TaitmisedParingManus.Taitmised;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.TaitmisedVastus;
import ee.webmedia.xtee.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.TaitmisedVastusManus;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.service.configuration.DelegatingXTeeServiceConfiguration;
import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;
import ee.webmedia.xtee.model.XTeeAttachment;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.springframework.stereotype.Service;

/**
 * Aar andmekogu xtee teenused
 *
 * @author Lauri Lättemäe (lauri.lattemaw@webmedia.ee)
 * @date 08.10.2010
 */
@Service("aarXTeeService")
public class AarXTeeServiceImpl extends XTeeDatabaseService implements AarXTeeService {

	public AsutusedVastusManus asutusedParingRegistriKoodiJargi(final String paringuIsikukood, String regKood) throws XTeeServiceConsumptionException {
		if (regKood == null) {
			throw new RuntimeException("Asutuse registrikood peab olema määratud");
		}

		AsutusedVastusManus responseObj = null;
		XTeeMessage<AsutusedParing> request = new XmlBeansXTeeMessage<AsutusedParing>(AsutusedParing.Factory.newInstance());
		AsutusedParingManus paringManus = AsutusedParingManus.Factory.newInstance();

		Asutused asutused = paringManus.addNewAsutused();
		asutused.setReKood(regKood);

		request.getContent().setAsutused(paringManus.xmlText().getBytes());

		AarXTeeConsumerCallback callback = new AarXTeeConsumerCallback();
		callback.addElementAttribute("asutused", "xsi:type", "xsd:base64Binary");

		// Teeme päringu
		final XTeeServiceConfiguration xteeConfiguration = xTeeServiceConfigurationProvider.createConfiguration(getDatabase(), getDatabase(), "asutused", "v1");
		DelegatingXTeeServiceConfiguration configuration = new DelegatingXTeeServiceConfiguration(xteeConfiguration) {
			@Override
			public String getIdCode() {
				// Kasutame konfis etteantud isikukoodi
				String idCode = super.getIdCode();
				if (paringuIsikukood != null) {
					idCode = paringuIsikukood.startsWith("EE") ? paringuIsikukood : "EE" + paringuIsikukood;
				}
				return idCode;
			}
		};
		XTeeMessage<AsutusedVastus> response = xTeeConsumer.sendRequest(request, configuration, callback, null);

		if (!response.getAttachments().isEmpty()) {
			ByteArrayOutputStream out = this.readResponse(response.getAttachments().get(0));

			try {
				responseObj =
					(AsutusedVastusManus) XmlObject.Factory.parse(XmlObject.Factory.parse(new String(out.toByteArray(), "UTF-8")).toString(),
							new XmlOptions().setDocumentType(AsutusedVastusManus.type));
			} catch(XmlException ex) {
				ex.printStackTrace();
			} catch(UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
		}
		return responseObj;
	}

	public TaitmisedVastusManus isikuRollidAsutuses(final String paringuIsikukood, Long asutusId, String isikukood, RollEnum... rollid) throws XTeeServiceConsumptionException {
		if (asutusId == null || (rollid == null || rollid.length == 0)) {
			throw new RuntimeException("Kohustuslikud parameetrid: asutuseId ja rollid peavad olema määratud");
		}

		TaitmisedVastusManus responseObj = null;

		XTeeMessage<TaitmisedParing> request = new XmlBeansXTeeMessage<TaitmisedParing>(TaitmisedParing.Factory.newInstance());

		TaitmisedParingManus paringManus = TaitmisedParingManus.Factory.newInstance();
		Taitmised taitmised = paringManus.addNewTaitmised();

		taitmised.addNewAsutused().addId2(asutusId.toString());
		for (RollEnum roll : rollid) {
			taitmised.addNewOigused().setOigus(roll.getValue());
		}
		if (isikukood != null) {
			taitmised.setIsikukood(isikukood);
		}

		request.getContent().setTaitmised(paringManus.xmlText().getBytes());

		AarXTeeConsumerCallback callback = new AarXTeeConsumerCallback();
		callback.addElementAttribute("taitmised", "xsi:type", "xsd:base64Binary");

		// Teeme päringu
		final XTeeServiceConfiguration xteeConfiguration = xTeeServiceConfigurationProvider.createConfiguration(getDatabase(), getDatabase(), "taitmised", "v1");
		DelegatingXTeeServiceConfiguration configuration = new DelegatingXTeeServiceConfiguration(xteeConfiguration) {
			@Override
			public String getIdCode() {
				// Kasutame konfis etteantud isikukoodi
				String idCode = super.getIdCode();
				if (paringuIsikukood != null) {
					idCode = paringuIsikukood.startsWith("EE") ? paringuIsikukood : "EE" + paringuIsikukood;
				}
				return idCode;
			}
		};
		XTeeMessage<TaitmisedVastus> response = xTeeConsumer.sendRequest(request, configuration, callback, null);

		if (!response.getAttachments().isEmpty()) {
			ByteArrayOutputStream out = this.readResponse(response.getAttachments().get(0));

			try {
				responseObj =
					(TaitmisedVastusManus) XmlObject.Factory.parse(XmlObject.Factory.parse(new String(out.toByteArray(), "UTF-8")).toString(),
							new XmlOptions().setDocumentType(TaitmisedVastusManus.type));
			} catch(XmlException ex) {
				ex.printStackTrace();
			} catch(UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
		}
		return responseObj;
	}

	private ByteArrayOutputStream readResponse(XTeeAttachment attachment) {
	    ByteArrayOutputStream out = null;
		if (attachment != null) {
			try {
				out = new ByteArrayOutputStream();
				byte[] buf = new byte[4 * 1024];
				int bytesRead;
				InputStream is = attachment.getInputStream();
				while ((bytesRead = is.read(buf)) != -1) {
					out.write(buf, 0, bytesRead);
				}
				out.flush();
				out.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		return out;
	}
}
