/**
 * Copyright 2009 Webmedia Group Ltd. Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package ee.webmedia.xtee.client.service.configuration;

/**
 * Delegates calls to embedded configuration.
 * 
 * @author Tanel Käär (tanelk@webmedia.ee)
 */
public class DelegatingXTeeServiceConfiguration implements XTeeServiceConfiguration {

  protected XTeeServiceConfiguration configuration;

  public DelegatingXTeeServiceConfiguration(XTeeServiceConfiguration configuration) {
    this.configuration = configuration;
  }

  public String getDatabase() {
    return configuration.getDatabase();
  }

  public String getFile() {
    return configuration.getFile();
  }

  public String getIdCode() {
    return configuration.getIdCode();
  }

  public String getInstitution() {
    return configuration.getInstitution();
  }

  public String getMethod() {
    return configuration.getMethod();
  }

  public String getSecurityServer() {
    return configuration.getSecurityServer();
  }

  public String getVersion() {
    return configuration.getVersion();
  }

  public String getWsdlDatabase() {
    return configuration.getWsdlDatabase();
  }

  public boolean getForceDatabaseNamespace() {
    return configuration.getForceDatabaseNamespace();
  }

  public void forceDatabaseNamespace() {
    configuration.forceDatabaseNamespace();
  }


  public boolean useDeprecatedApi() {
    return configuration.useDeprecatedApi();
  }

}
