package aptoide.injector.Modifier;
import org.xml.sax.SAXException;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by gbfm on 8/11/15.
 */
public interface IAndroidManifestRW extends IXMLRW {
	String getMainActivityName() throws XPathExpressionException;

	void removeLauncherIntent() throws XPathExpressionException;

	void addActivities(String filePath) throws XPathExpressionException, IOException, SAXException;

	void addPermissions(String filePath) throws XPathExpressionException, IOException, SAXException;
}
