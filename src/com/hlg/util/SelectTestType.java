package com.hlg.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

public class SelectTestType {

	public void selectType(HttpServletRequest request) {

		// HttpSession selectTypeSesion = request.getSession();

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

		/*
		 * selectTypeSesion.setAttribute("testCenterTypeList",
		 * testCenterTypeList);
		 * System.out.println(testCenterTypeList.get(0).getId());
		 * selectTypeSesion.setAttribute("instrumentTypeList",
		 * instrumentTypeList); selectTypeSesion.setAttribute("serviceTypeList",
		 * serviceTypeList);
		 * selectTypeSesion.setAttribute("accreditationTypeList",
		 * accreditationTypeList);
		 * selectTypeSesion.setAttribute("photoTypeList", photoTypeList);
		 */

		request.setAttribute("testCenterTypeList", testCenterTypeList);

		request.setAttribute("instrumentTypeList", instrumentTypeList);

		request.setAttribute("serviceTypeList", serviceTypeList);

		request.setAttribute("accreditationTypeList", accreditationTypeList);

		request.setAttribute("photoTypeList", photoTypeList);

	}
}
