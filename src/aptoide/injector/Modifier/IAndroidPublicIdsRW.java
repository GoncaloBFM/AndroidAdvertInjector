package aptoide.injector.Modifier;

import org.xml.sax.SAXException;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by gbfm on 8/12/15.
 */
public interface IAndroidPublicIdsRW extends IXMLRW {
	 java.util.LinkedList<Resource> addResources(String filePath) throws XPathExpressionException, IOException, SAXException;
}
