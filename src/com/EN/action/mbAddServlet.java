package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import com.EN.entity.menbers;
import com.EN.service.menbersService;
import com.EN.util.WebUtils;
import com.EN.web.formbean.RegisterFormBean;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class mbAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public mbAddServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	
		String save="";//相对保存地址
		String allowedFilesList="jpg,gif,jpeg,png";//允许上传文件类型
        SmartUpload mySmartUpload=new SmartUpload("utf-8");//新建一个上传组件
        long fileSizeMax=1024*1024*10;//文件上传大小最大值
        String ext="";//文件格式
        String url="upload/";//文件存储目录
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
                save+=url+filename+"."+ext;
                try {
                    myFile.saveAs(saveurl,mySmartUpload.SAVE_PHYSICAL);//保存文件
                } catch (SmartUploadException e) {
                    e.printStackTrace();
                    System.out.println("文件保存出错");
                }
               //文件路径saveurl
            }
        }
        
    	menbers mb = new menbers();
    	mb.setMbName(mySmartUpload.getRequest().getParameter("mbName"));
		mb.setMbClass(mySmartUpload.getRequest().getParameter("mbClass"));
		mb.setMbDepartment(mySmartUpload.getRequest().getParameter("mbDepartment"));
		mb.setMbIntroduce(mySmartUpload.getRequest().getParameter("mbIntroduce"));
		mb.setId(WebUtils.makeId());
		mb.setMbPhoto(save);
		
		menbersService mbService = new menbersService();
		mbService.addmb(mb);
	
		String message =String.format(
				"添加成功！<meta http-equiv='refresh' content='1;url=%s'", 
				request.getContextPath()+"/servlet/menFindAllServlet?web_type=back");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;	
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
