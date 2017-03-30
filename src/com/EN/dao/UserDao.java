package com.EN.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.EN.entity.User;
import com.EN.util.XmlUtils;

public class UserDao{

	public User find(String userName, String userPwd) {
		// TODO Auto-generated method stub
		try{
            Document document = XmlUtils.getDocument();
            //ʹ��XPath���ʽ������XML�ڵ�
            Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"' and @userPwd='"+userPwd+"']");
            if(e==null){
                return null;
            }
            User user = new User();
            user.setId(e.attributeValue("id"));
            user.setEmail(e.attributeValue("email"));
            user.setUserPwd(e.attributeValue("userPwd"));
            user.setUserName(e.attributeValue("userName"));
            String birth = e.attributeValue("birthday");
            
            user.setBirthday(birth);
            
            return user;
        
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	@SuppressWarnings("deprecation")
	public void add(User user) {
		// TODO Auto-generated method stub
		try{
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element user_node = root.addElement("user");  //创建user结点，并挂到root
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("userName", user.getUserName());
			user_node.setAttributeValue("userPwd", user.getUserPwd());
			user_node.setAttributeValue("email", user.getEmail());
			
			user_node.setAttributeValue("birthday", user.getBirthday());
		
			XmlUtils.write2Xml(document);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User find(String userName) {
		// TODO Auto-generated method stub
		try{
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@id='"+userName+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setUserPwd(e.attributeValue("userPwd"));
			user.setUserName(e.attributeValue("userName"));
			String birth = e.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(birth);
			
			return user;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void modif(User user){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@id='"+user.getId()+"']");
			e.setAttributeValue("id", user.getId());
			e.setAttributeValue("userName", user.getUserName());
			e.setAttributeValue("userPwd", user.getUserPwd());
			e.setAttributeValue("email", user.getEmail());
			e.setAttributeValue("birthday", user.getBirthday());
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
