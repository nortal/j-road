package com.nortal.jroad.client.mteenus;

import javax.annotation.Resource;

import org.junit.Test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.xmlbeans.XmlString;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.mteenus.MteenusXTeeServiceImpl;
import com.nortal.jroad.client.mteenus.Sms;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import com.nortal.jroad.client.util.XmlBeansUtil;

/**
 * @author Aleksandr.Koltakov
 */
public class MteenusXteeServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private MteenusXTeeServiceImpl mteenusXTeeServiceImpl;

  @Test
  public void testSend() throws XRoadServiceConsumptionException {
    Sms sms = new Sms();
    sms.setIsikukood("37801113714");
    sms.setTeenusId("169");
    sms.setSaatjaNumber("0");
    sms.setSisu("XTee test message");
    mteenusXTeeServiceImpl.send(sms);
  }
}