package Jaxp.parse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLUtils {
	
	
	public static Document getDocument(String path) throws SAXException, IOException, ParserConfigurationException {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path);
		return document;
	}

	public static void writeToXML(Document document,String path) throws TransformerFactoryConfigurationError, FileNotFoundException, TransformerException {
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		
		transformer.transform(new DOMSource(document),	new StreamResult(new FileOutputStream(path)));
		
	}

}
