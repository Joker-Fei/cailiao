package com.hlg.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.AccreditationType;
import com.hlg.entity.InstrumentType;
import com.hlg.entity.PhotoType;
import com.hlg.entity.ServiceType;
import com.hlg.entity.TestCenterType;
import com.hlg.service.AccreditationTypeService;
import com.hlg.service.InstrumentTypeService;
import com.hlg.service.PhotoTypeService;
import com.hlg.service.ServiceTypeService;
import com.hlg.service.TestCenterTypeService;

/**
 * Servlet implementation class SelectType
 */
@WebServlet("/SelectType")
public class SelectType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		selectType(request);

	}

	public void selectType(HttpServletRequest request) {
		// 中心概况
		TestCenterTypeService testCenterTypeService = new TestCenterTypeService();
		// 仪器一览
		InstrumentTypeService instrumentTypeService = new InstrumentTypeService();
		// 服务指南
		ServiceTypeService serviceTypeService = new ServiceTypeService();
		// 计量认证
		AccreditationTypeService accreditationTypeService = new AccreditationTypeService();
		// 示例照片
		PhotoTypeService photoTypeService = new PhotoTypeService();

		List<TestCenterType> testCenterTypeList = testCenterTypeService
				.findAll();
		List<InstrumentType> instrumentTypeList = instrumentTypeService
				.findAll();
		List<ServiceType> serviceTypeList = serviceTypeService.findAll();
		List<AccreditationType> accreditationTypeList = accreditationTypeService
				.findAll();
		List<PhotoType> photoTypeList = photoTypeService.findAll();

		request.setAttribute("testCenterTypeList", testCenterTypeList);

		request.setAttribute("instrumentTypeList", instrumentTypeList);

		request.setAttribute("serviceTypeList", serviceTypeList);

		request.setAttribute("accreditationTypeList", accreditationTypeList);

		request.setAttribute("photoTypeList", photoTypeList);

	}

}
