package com.EN.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	
	private static String filename = "DB.xml";
	
	public static Document getDocument() throws DocumentException{
		
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();
		
		SAXReader reader = new SAXReader();
		return reader.read(new File(realpath));
		
	}
	
	public static void write2Xml(Document document) throws IOException{
		
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream(realpath), format );
        writer.write( document );
        writer.close();

	}
	
	
}
