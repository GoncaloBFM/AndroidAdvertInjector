package aptoide.injector.Modifier;

/**
 * Created by gbfm on 8/11/15.
 */
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

public class AndroidManifestRW extends XMLRW implements IAndroidManifestRW {

	private static final String MANIFEST_NODE = "/manifest";
	private static final String APPLICATION_NODE = MANIFEST_NODE + "/application";
	private static final String APP_LAUNCHER_INTENT_FILTER = APPLICATION_NODE + "/activity/intent-filter/category[@name=\"android.intent.category.LAUNCHER\"]/..";
	private static final String MAIN_ACTIVITY_NODE = APP_LAUNCHER_INTENT_FILTER + "/..";
	private static final String MAIN_ACTIVITY_FILE_NAME = MAIN_ACTIVITY_NODE + "/@name";

	public AndroidManifestRW(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
		super(pathToPublicIdFile);
	}

	@Override
	public String getMainActivityName() throws XPathExpressionException {
		return (String) this.xpath.compile(MAIN_ACTIVITY_FILE_NAME).evaluate(this.document, XPathConstants.STRING);
	}

	@Override
	public void removeLauncherIntent() throws XPathExpressionException {
		Node mainActivityNode = (Node) this.xpath.compile(MAIN_ACTIVITY_NODE).evaluate(this.document, XPathConstants.NODE);
		Node intentFilter = (Node) this.xpath.compile(APP_LAUNCHER_INTENT_FILTER).evaluate(this.document, XPathConstants.NODE);
		mainActivityNode.removeChild(intentFilter);
	}

	@Override
	public void addActivities(String filePath) throws XPathExpressionException, IOException, SAXException {
		Node applicationNode = (Node) this.xpath.compile(APPLICATION_NODE).evaluate(this.document, XPathConstants.NODE);
		this.insertNodesFromFile(filePath, applicationNode);
	}

	@Override
	public void addPermissions(String filePath) throws XPathExpressionException, IOException, SAXException {
		Node applicationNode = (Node) this.xpath.compile(MANIFEST_NODE).evaluate(this.document, XPathConstants.NODE);
		this.insertNodesFromFile(filePath, applicationNode);
	}
}