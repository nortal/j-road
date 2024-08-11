package com.nortal.jroad.client.kutseregister;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kutseregister.database.KutseregisterXRoadDatabase;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusDocument.Kutsetunnistus;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusVastusDocument.KutsetunnistusVastus;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlCursor;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import javax.xml.namespace.QName;

/**
 * @author Anti Orgla
 */
@Service("kutseregisterXRoadServiceImpl")
public class KutseregisterXRoadServiceImpl implements KutseregisterXRoadService {

  private static final String KUTSEREGISTER_NS = "http://producers.kutseregister.xtee.riik.ee/producer/kutseregister";

  @Resource
  private KutseregisterXRoadDatabase kutseregisterXRoadDatabase;

  @Override
  public KutsetunnistusVastus findKutseTunnistus(String isikukood, String nimi) throws XRoadServiceConsumptionException {
    Kutsetunnistus kutsetunnistus = Kutsetunnistus.Factory.newInstance();
    if (isikukood != null) {
      kutsetunnistus.setIsikukood(isikukood);
    }
    if (nimi != null) {
      kutsetunnistus.setNimi(nimi);
    }
    KutsetunnistusVastus response = kutseregisterXRoadDatabase.kutsetunnistusV2(kutsetunnistus);
    addMissingNamespaces(response);
    return response;
  }

  private void addMissingNamespaces(KutsetunnistusVastus response) {
    XmlCursor cursor = response.newCursor();
    while (cursor.hasNextToken()) {
      cursor.toNextToken();
      if (cursor.isStart()) {
        QName name = cursor.getName();
        if (StringUtils.isBlank(name.getNamespaceURI())) {
          cursor.setName(new QName(KUTSEREGISTER_NS, name.getLocalPart()));
        }
      }
    }
    cursor.dispose();
  }

}
