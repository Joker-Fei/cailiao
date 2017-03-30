package com.EN.dao;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.EN.entity.education;
import com.EN.util.XmlUtils;

public class educationDao {
	public void add(education intr){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element mb_node = root.addElement("education");  //创建menbers结点，并挂到root
			mb_node.setAttributeValue("id", intr.getId());
			mb_node.setAttributeValue("education", intr.getEducation());
			XmlUtils.write2Xml(document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modif(education intr){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//education[@id='"+intr.getId()+"']");
			e.setAttributeValue("education",intr.getEducation());
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
			Element e = (Element) document.selectSingleNode("//education[@id='"+id+"']");
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
	
	public education find(String type,String id){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//education[@"+type+"='"+id+"']");
			if(e==null){
	            return null;
	        }
			education intr = new education();
			intr.setId(e.attributeValue("id"));
			intr.setEducation(e.attributeValue("education"));
	        return intr;
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
