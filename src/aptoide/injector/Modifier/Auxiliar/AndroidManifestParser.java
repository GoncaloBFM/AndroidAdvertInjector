package aptoide.injector.Modifier.Auxiliar;

import aptoide.injector.Modifier.XMLRW.XMLRW;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by gbfm on 8/21/15.
 */
public class AndroidManifestParser extends XMLRW implements IAndroidManifestParser {

	private static final String MAIN_ACTIVITY_FILE_NAME = "/manifest/application/activity/intent-filter/category[@name=\"android.intent.category.LAUNCHER\"]/../../@name";

	public AndroidManifestParser(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
		super(pathToPublicIdFile);
	}

	@Override
	public String getLaunchActivityName() throws XPathExpressionException {
		return this.getString(MAIN_ACTIVITY_FILE_NAME);
	}

}
