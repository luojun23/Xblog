package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.FamilyQuery;
import com.njtech.blog.entity.po.Family;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.FamilyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 家庭信息 Controller
 */
@RestController("familyController")
@RequestMapping("/family")
public class FamilyController extends ABaseController{

	@Resource
	private FamilyService familyService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(FamilyQuery query){
		return getSuccessResponseVO(familyService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Family bean) {
		familyService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Family> listBean) {
		familyService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Family> listBean) {
		familyService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getFamilyById")
	public ResponseVO getFamilyById(Integer id) {
		return getSuccessResponseVO(familyService.getFamilyById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateFamilyById")
	public ResponseVO updateFamilyById(Family bean,Integer id) {
		familyService.updateFamilyById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteFamilyById")
	public ResponseVO deleteFamilyById(Integer id) {
		familyService.deleteFamilyById(id);
		return getSuccessResponseVO(null);
	}
}