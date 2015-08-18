package aptoide.injector.Modifier;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gbfm on 8/12/15.
 */
public interface IAndroidPublicIdsRW extends IXMLRW {
	 LinkedList<Resource> addResources(String filePath) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException;
}
