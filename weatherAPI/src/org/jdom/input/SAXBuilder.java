package org.jdom.input;

import org.jdom.Document;
import org.xml.sax.InputSource;

public interface SAXBuilder {

	Document build(InputSource is);

}
