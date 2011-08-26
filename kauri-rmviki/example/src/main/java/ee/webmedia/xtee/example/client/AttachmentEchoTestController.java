package ee.webmedia.xtee.example.client;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ee.webmedia.xtee.jaxb.ByteArrayDataSource;

public class AttachmentEchoTestController extends SimpleFormController {

  @Resource
  private NaidisXTeeService naidisXTeeService;

  {
    setCommandClass(String.class);
  }

  @Override
  protected ModelAndView onSubmit(HttpServletRequest request,
                                  HttpServletResponse response,
                                  Object command,
                                  BindException errors) throws Exception {
    ModelAndView mav = new ModelAndView("test");
    String attachment = "attachment\ntesting";
    DataHandler reqHandler = new DataHandler(new ByteArrayDataSource("text/plain", attachment.getBytes("UTF-8")));
    DataHandler respHandler = naidisXTeeService.sendAttachment(reqHandler);
    mav.addObject("testresult",
                  new String(FileCopyUtils.copyToByteArray(respHandler.getInputStream()), "UTF-8").equals(attachment)
                                                                                                                     ? "Test passed!"
                                                                                                                     : "Test failed!");
    return mav;
  }

  public NaidisXTeeService getAttachmentEchoService() {
    return naidisXTeeService;
  }

  public void setAttachmentEchoService(NaidisXTeeService attachmentEchoService) {
    this.naidisXTeeService = attachmentEchoService;
  }
}
