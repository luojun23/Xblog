package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.WebInfoQuery;
import com.njtech.blog.entity.po.WebInfo;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.WebInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 网站信息表 Controller
 */
@RestController("webInfoController")
@RequestMapping("/webInfo")
public class WebInfoController extends ABaseController{

	@Resource
	private WebInfoService webInfoService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(WebInfoQuery query){
		return getSuccessResponseVO(webInfoService.findListByPage(query));
	}


}