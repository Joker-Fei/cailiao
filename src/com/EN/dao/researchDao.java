package com.EN.dao;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.EN.entity.research;
import com.EN.entity.research;
import com.EN.util.XmlUtils;

public class researchDao {
	
	public void add(research intr){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element mb_node = root.addElement("research");  //创建menbers结点，并挂到root
			mb_node.setAttributeValue("id", intr.getId());
			mb_node.setAttributeValue("research", intr.getResearch());
			XmlUtils.write2Xml(document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modif(research intr){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//research[@id='"+intr.getId()+"']");
			e.setAttributeValue("research",intr.getResearch());
			XmlUtils.write2Xml(document);	

		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String id){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element e = (Element) document.selectSingleNode("//research[@id='"+id+"']");
			e.getParent().remove(e);
			XmlUtils.write2Xml(document);	
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public research find(String type,String id){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//research[@"+type+"='"+id+"']");
			if(e==null){
	            return null;
	        }
			research intr = new research();
			intr.setId(e.attributeValue("id"));
			intr.setResearch(e.attributeValue("research"));
	        return intr;
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		
	}
}
