package com.nortal.jroad.client.mteenus;

import jakarta.annotation.Resource;

import org.junit.Test;

import java.util.List;

import jakarta.annotation.Resource;

import org.apache.xmlbeans.XmlString;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.mteenus.MteenusXTeeServiceImpl;
import com.nortal.jroad.client.mteenus.Sms;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import com.nortal.jroad.client.util.XmlBeansUtil;

/**
 * @author Aleksandr.Koltakov
 */
public class MteenusXteeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private MteenusXTeeServiceImpl mteenusXTeeServiceImpl;

  @Test
  public void testSend() throws XTeeServiceConsumptionException {
    Sms sms = new Sms();
    sms.setIsikukood("37801113714");
    sms.setTeenusId("169");
    sms.setSaatjaNumber("0");
    sms.setSisu("XTee test message");
    mteenusXTeeServiceImpl.send(sms);
  }
}
