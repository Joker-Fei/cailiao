package com.hlg.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hlg.entity.CoorperationDetail;
import com.hlg.entity.CoorperationType;
import com.hlg.entity.NewsDetail;
import com.hlg.entity.NewsType;
import com.hlg.entity.SubjectDetail;
import com.hlg.entity.SubjectType;
import com.hlg.entity.WorkDetail;
import com.hlg.entity.WorkType;
import com.hlg.service.CoorperationDetailService;
import com.hlg.service.CoorperationTypeService;
import com.hlg.service.NewsDetailService;
import com.hlg.service.NewsTypeService;
import com.hlg.service.SubjectDetailService;
import com.hlg.service.SubjectTypeService;
import com.hlg.service.WorkDetailService;
import com.hlg.service.WorkTypeService;

public class ListInfoUtil {

	// 学院新闻方法
	public void newsInfo(HttpServletRequest request) {

		NewsDetailService newsDetailService = new NewsDetailService();

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
	}

	// 学院科研合作方法
	public void coorperationInfo(HttpServletRequest request) {

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();

		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);
	}

	// 学院学科介绍方法
	public void subjectInfo(HttpServletRequest request) {

		SubjectDetailService subjectDetailService = new SubjectDetailService();

		List<SubjectDetail> subjectDetailList = subjectDetailService.findAll();
		request.setAttribute("subjectDetailList", subjectDetailList);
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);
	}

	public void workInfo(HttpServletRequest request) {
		WorkDetailService workDetailService = new WorkDetailService();

		List<WorkDetail> workDetailList = workDetailService.findAll();
		request.setAttribute("workDetailList", workDetailList);
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();
		request.setAttribute("workTypeList", workTypeList);
	}
}
