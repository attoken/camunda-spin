/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.spin.impl.xml.dom;

import org.camunda.spin.logging.SpinCoreLogger;
import org.camunda.spin.logging.SpinLogger;
import org.camunda.spin.spi.Configurable;
import org.camunda.spin.spi.DataFormat;
import org.camunda.spin.spi.DataFormatMapper;
import org.camunda.spin.spi.DataFormatReader;
import org.camunda.spin.spi.TypeDetector;
import org.camunda.spin.xml.tree.SpinXmlTreeAttribute;
import org.camunda.spin.xml.tree.SpinXmlTreeElement;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * @author Daniel Meyer
 *
 */
public class XmlDomDataFormat implements DataFormat<SpinXmlTreeElement> {

  protected static final SpinCoreLogger LOG = SpinLogger.CORE_LOGGER;

  public Class<? extends SpinXmlTreeElement> getWrapperType() {
    return SpinXmlDomElement.class;
  }

  public SpinXmlTreeElement createWrapperInstance(Object parameter) {
    return createElementWrapper((Element) parameter);
  }

  public String getName() {
    return "application/xml; implementation=dom";
  }

  public SpinXmlTreeElement createElementWrapper(Element element) {
    return new SpinXmlDomElement(element, this);
  }

  public SpinXmlTreeAttribute createAttributeWrapper(Attr attr) {
    return new SpinXmlDomAttribute(attr, this);
  }

  public XmlDomDataFormat newInstance() {
    return new XmlDomDataFormat();
  }

  public Configurable<?> getConfiguration() {
    return null;
  }

  public DataFormatReader getReader() {
    return new XmlDomDataFormatReader();
  }

  public DataFormatMapper getMapper() {
    throw LOG.methodNotImplement("getMapper");
  }

  public String getCanonicalTypeName(Object object) {
    throw LOG.methodNotImplement("getCanonicalTypeName");
  }

  public void addTypeDetector(TypeDetector typeDetector) {
    throw LOG.methodNotImplement("addTypeDetector");
  }

}
