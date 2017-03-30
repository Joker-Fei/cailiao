package com.EN.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.EN.entity.User;
import com.EN.entity.departments;
import com.EN.util.XmlUtils;

public class departmentsDao {

	public void add(departments dm){
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element mb_node = root.addElement("departments");  //创建menbers结点，并挂到root
			mb_node.setAttributeValue("id", dm.getId());
			mb_node.setAttributeValue("dmName", dm.getDmName());
			mb_node.setAttributeValue("dmIntroduce", dm.getDmIntroduce());
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
			Element e = (Element) document.selectSingleNode("//departments[@id='"+id+"']");
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
	public departments find(String type, String dmName){
		
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//departments[@"+type+"='"+dmName+"']");
			if(type.equals("id")&&dmName.equals("1")){
				e = (Element) document.selectSingleNode("//departments");
			}
			if(e==null){
                return null;
            }
			departments dm = new departments();
	        dm.setId(e.attributeValue("id"));
	        dm.setDmName(e.attributeValue("dmName"));
	        dm.setDmIntroduce(e.attributeValue("dmIntroduce"));
	        return dm;
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;	  

	}
	public List<departments> findAll(){
		Document document;
		try {
			document = XmlUtils.getDocument();
			List<departments> lsdm = new ArrayList<departments>();
			
			List<Element> lse= document.selectNodes("root/departments");
			for(int i=0;i<lse.size();i++){
				departments dm = new departments();
				dm.setId(lse.get(i).attributeValue("id"));
				dm.setDmName(lse.get(i).attributeValue("dmName"));
				dm.setDmIntroduce(lse.get(i).attributeValue("dmIntroduce"));
				lsdm.add(dm);
			}
			
			return lsdm;
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void modif(departments dm){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//departments[@id='"+dm.getId()+"']");
			e.setAttributeValue("dmName", dm.getDmName());
			e.setAttributeValue("dmIntroduce",dm.getDmIntroduce());
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
