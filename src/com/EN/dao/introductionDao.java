package com.EN.dao;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.EN.entity.departments;
import com.EN.entity.introduction;
import com.EN.util.XmlUtils;

public class introductionDao {

	public void add(introduction intr){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element mb_node = root.addElement("introduction");  //创建menbers结点，并挂到root
			mb_node.setAttributeValue("id", intr.getId());
			mb_node.setAttributeValue("intrIntroduce", intr.getIntdIntroduce());
			XmlUtils.write2Xml(document);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modif(introduction intr){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//introduction[@id='"+intr.getId()+"']");
			e.setAttributeValue("intrIntroduce",intr.getIntdIntroduce());
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
			Element e = (Element) document.selectSingleNode("//introduction[@id='"+id+"']");
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
	
	public introduction find(String type,String id){
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//introduction[@"+type+"='"+id+"']");
			if(e==null){
	            return null;
	        }
			introduction intr = new introduction();
			intr.setId(e.attributeValue("id"));
			intr.setIntdIntroduce(e.attributeValue("intrIntroduce"));
	        return intr;
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		
	}
}
