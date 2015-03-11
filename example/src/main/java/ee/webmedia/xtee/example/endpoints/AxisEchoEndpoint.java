package com.nortal.jroad.example.endpoints;

import org.springframework.stereotype.Component;

import ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest;
import ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse;
import com.nortal.jroad.annotation.XTeeService;
import com.nortal.jroad.endpoint.AbstractXTeeAxisEndpoint;

@XTeeService(name = "AxisEcho", version = "v1", title = "Echo service")
@Component
public class AxisEchoEndpoint extends AbstractXTeeAxisEndpoint<EchoRequest, EchoResponse> {

  @Override
  public Class<EchoRequest> getParingKehaClass() {
    return EchoRequest.class;
  }

  @Override
  public EchoResponse invokeBean(EchoRequest requestBean) {
    return new EchoResponse(requestBean.getText());
  }

}
