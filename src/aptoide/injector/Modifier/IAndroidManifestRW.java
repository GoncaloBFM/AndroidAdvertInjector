package aptoide.injector.Modifier;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by gbfm on 8/11/15.
 */
public interface IAndroidManifestRW extends IXMLRW {
	String getMainActivityName() throws XPathExpressionException;

	void parseManifestAddendum(String manifestAddendumFile) throws XPathExpressionException, IOException, SAXException, ManifestAddendumException, ParserConfigurationException;
}
