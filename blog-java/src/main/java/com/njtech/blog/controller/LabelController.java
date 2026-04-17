package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.LabelQuery;
import com.njtech.blog.entity.po.Label;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.LabelService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 标签 Controller
 */
@RestController("labelController")
@RequestMapping("/label")
public class LabelController extends ABaseController{

	@Resource
	private LabelService labelService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(LabelQuery query){
		return getSuccessResponseVO(labelService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Label bean) {
		labelService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Label> listBean) {
		labelService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Label> listBean) {
		labelService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getLabelById")
	public ResponseVO getLabelById(Integer id) {
		return getSuccessResponseVO(labelService.getLabelById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateLabelById")
	public ResponseVO updateLabelById(Label bean,Integer id) {
		labelService.updateLabelById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteLabelById")
	public ResponseVO deleteLabelById(Integer id) {
		labelService.deleteLabelById(id);
		return getSuccessResponseVO(null);
	}
}