package com.nortal.jroad.example.client;

import javax.activation.DataHandler;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
  private static final String TEST_OK = "OK";
  private static final String TEST_FAILED = "FAILED";

  @Resource
  private NaidisXRoadService naidisXRoadService;

  @RequestMapping("/test")
  protected ModelAndView test() throws Exception {
    ModelAndView mav = new ModelAndView("test");
    mav.addObject("attachmentEchoResult", getAttachmentEchoResult());
    mav.addObject("echoResult", getEchoResult());
    mav.addObject("axisEchoResult", getAxisEchoResult());
    return mav;
  }

  private String getAttachmentEchoResult() {
    try {
      String attachment = "123456789";
      DataHandler respHandler =
          naidisXRoadService.sendAttachment("text/plain",
                                            attachment.getBytes("UTF-8")).getNest().getAttachmentHandler();
      return new String(FileCopyUtils.copyToByteArray(respHandler.getInputStream()),
                        "UTF-8").equals(attachment) ? TEST_OK : TEST_FAILED;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return TEST_FAILED;
  }

  private String getEchoResult() {
    try {
      String text = "Some echo text!";
      return naidisXRoadService.sendEcho(text).getText().equals(text) ? TEST_OK : TEST_FAILED;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return TEST_FAILED;
  }

  private String getAxisEchoResult() {
    try {
      String text = "Some axis echo text!";
      return naidisXRoadService.sendAxisEcho(text).getText().equals(text) ? TEST_OK : TEST_FAILED;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return TEST_FAILED;
  }
}
