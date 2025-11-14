/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.wsdl;

import org.springframework.util.Assert;
import org.springframework.ws.wsdl.wsdl11.provider.SuffixBasedMessagesProvider;
import org.w3c.dom.Element;

/**
 * X-Road specific implementation of strategy for adding messages to a <code>Definition</code>
 * Adds top-level element declarations (that have no inline content) to the definition.
 * Used by {@link XTeeWsdlDefinition}
 */
public class XTeeMessagesProvider extends SuffixBasedMessagesProvider {
  @Override
  protected boolean isMessageElement(Element element) {
    boolean isMessageElement = "element".equals(element.getLocalName())
                               && "http://www.w3.org/2001/XMLSchema".equals(element.getNamespaceURI());
    if (!isMessageElement) {
      return false;
    }

    String elementName = this.getElementName(element);
    Assert.hasText(elementName, "Element has no name");
    return !element.hasChildNodes();
  }

}
