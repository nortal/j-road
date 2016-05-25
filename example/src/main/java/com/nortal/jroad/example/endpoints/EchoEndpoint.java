/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.example.endpoints;

import org.springframework.stereotype.Component;

import com.nortal.jroad.annotation.XTeeService;
import com.nortal.jroad.endpoint.AbstractXTeeJAXBEndpoint;
import com.nortal.jroad.example.model.EchoRequest;
import com.nortal.jroad.example.model.EchoResponse;

/**
 * Sample service endpoint. {@link XTeeService} annotation is not mandatory, if it were to be omitted here, default
 * values used would be "echo" (from the class name <code>EchoEndpoint</code>) and "v1".
 * 
 * @author Dmitri Danilkin
 */
@Component
@XTeeService(name = "Echo", version = "v1", title = "Echo service")
public class EchoEndpoint extends AbstractXTeeJAXBEndpoint<EchoRequest> {
  @Override
  protected Class<EchoRequest> getParingKehaClass() {
    // As incoming object's Element name is "keha", the query class must be shown
    return EchoRequest.class;
  }

  @Override
  protected EchoResponse invokeBean(EchoRequest requestBean) {
    // Creation of a response object -- must correspond to
    // response type defined in XML Schema definition.
    EchoResponse response = new EchoResponse();

    // Initialization of response object fields
    response.setText(requestBean.getText());

    // returning the response object
    return response;
  }
}
