package com.EN.action;


import java.io.IOException;

import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class imageUpload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public imageUpload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 String allowedFilesList="jpg,gif,jpeg,png";//允许上传文件类型
	        SmartUpload mySmartUpload=new SmartUpload("utf-8");//新建一个上传组件
	        long fileSizeMax=1024*1024*10;//文件上传大小最大值
	        String ext="";//文件格式
	        String url="update/";//文件存储目录
	        mySmartUpload.initialize(this.getServletConfig(),request,response);//初始化上传组件
	        mySmartUpload.setAllowedFilesList(allowedFilesList);//设置上传类型
	        try {
	            mySmartUpload.upload();//上载文件
	        } catch (SmartUploadException e) {
	            e.printStackTrace();
	            System.out.println("只允许上传"+allowedFilesList+"类型图片");
	        }
	        com.jspsmart.upload.SmartFile myFile=mySmartUpload.getFiles().getFile(0);//获取第一个上载文件
	        if(myFile.isMissing()){//判断是否有文件
	            System.out.println("请选择要上传的文件");
	        }else{
	            ext=myFile.getFileExt();//获取文件格式
	            int fileSize=myFile.getSize();//获取文件大小
	            String saveurl="";//保存地址
	            if(fileSize<fileSizeMax){
	                String filename=String.valueOf(Calendar.getInstance().getTimeInMillis());//获取当前毫秒数
	                saveurl=request.getRealPath("/");//获取网站根目录
	                saveurl+=url+filename+"."+ext;
	                try {
	                	System.out.println("save:"+saveurl);
	                    myFile.saveAs(saveurl,mySmartUpload.SAVE_PHYSICAL);//保存文件
	                } catch (SmartUploadException e) {
	                    e.printStackTrace();
	                    System.out.println("文件保存出错");
	                }
	                //-----------------------上传完成，开始生成缩略图-------------------------
	                java.io.File file=new java.io.File(saveurl);//读入刚刚上传的文件
	            }
	        }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
