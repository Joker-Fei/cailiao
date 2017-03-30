package com.EN.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.EN.entity.departments;
import com.EN.entity.menbers;
import com.EN.util.XmlUtils;

public class menbersDao {
	
	public void add(menbers mb){
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element mb_node = root.addElement("menbers");  //创建menbers结点，并挂到root
			mb_node.setAttributeValue("id", mb.getId());
			mb_node.setAttributeValue("mbName", mb.getMbName());
			mb_node.setAttributeValue("mbDepartment", mb.getMbDepartment());
			mb_node.setAttributeValue("mbClass", mb.getMbClass());
			mb_node.setAttributeValue("mbIntroduce", mb.getMbIntroduce());
			mb_node.setAttributeValue("mbPhoto", mb.getMbPhoto());
			XmlUtils.write2Xml(document);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			Element e = (Element) document.selectSingleNode("//menbers[@id='"+id+"']");
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
	public List<menbers> findAll(){
		Document document;
		try {
			document = XmlUtils.getDocument();
			List<menbers> lsmen = new ArrayList<menbers>();
			
			List<Element> lse= document.selectNodes("root/menbers");
			for(int i=0;i<lse.size();i++){
				menbers men = new menbers();
				men.setId(lse.get(i).attributeValue("id"));
				men.setMbName(lse.get(i).attributeValue("mbName"));
				men.setMbClass(lse.get(i).attributeValue("mbClass"));
				men.setMbDepartment(lse.get(i).attributeValue("mbDepartment"));
				men.setMbIntroduce(lse.get(i).attributeValue("mbIntroduce"));
				men.setMbPhoto(lse.get(i).attributeValue("mbPhoto"));
		        lsmen.add(men);
			}
			return lsmen;
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public menbers find(String type, String Name){
		
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//menbers[@"+type+"='"+Name+"']");
			if(e==null){
                return null;
            }
			
			menbers mb = new menbers();
	        mb.setId(e.attributeValue("id"));
	        mb.setMbName(e.attributeValue("mbName"));
	        mb.setMbClass(e.attributeValue("mbClass"));
	        mb.setMbDepartment(e.attributeValue("mbDepartment"));
	        mb.setMbIntroduce(e.attributeValue("mbIntroduce"));
	        mb.setMbPhoto(e.attributeValue("mbPhoto"));
	        return mb;
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;	
	}
	
	public void modif(menbers mb){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//menbers[@id='"+mb.getId()+"']");
			e.setAttributeValue("mbName", mb.getMbName());
			e.setAttributeValue("mbDepartment",mb.getMbDepartment());
			e.setAttributeValue("mbClass",mb.getMbClass());
			e.setAttributeValue("mbIntroduce",mb.getMbIntroduce());
			e.setAttributeValue("mbPhoto",mb.getMbPhoto());
			XmlUtils.write2Xml(document);	

		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
