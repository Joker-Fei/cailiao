package com.EN.dao;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.EN.util.XmlUtils;
import com.EN.entity.contactus;

public class contactusDao {
	
	public void add(contactus intr){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element mb_node = root.addElement("contactus");  //创建menbers结点，并挂到root
			mb_node.setAttributeValue("id", intr.getId());
			mb_node.setAttributeValue("contactus", intr.getContactus());
			XmlUtils.write2Xml(document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modif(contactus intr){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//contactus[@id='"+intr.getId()+"']");
			e.setAttributeValue("contactus",intr.getContactus());
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
			Element e = (Element) document.selectSingleNode("//contactus[@id='"+id+"']");
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
	
	public contactus find(String type,String id){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//contactus[@"+type+"='"+id+"']");
			if(e==null){
	            return null;
	        }
			contactus intr = new contactus();
			intr.setId(e.attributeValue("id"));
			intr.setContactus(e.attributeValue("contactus"));
	        return intr;
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
