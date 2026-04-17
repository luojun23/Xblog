package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.SortQuery;
import com.njtech.blog.entity.po.Sort;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.SortService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分类 Controller
 */
@RestController("sortController")
@RequestMapping("/sort")
public class SortController extends ABaseController{

	@Resource
	private SortService sortService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(SortQuery query){
		return getSuccessResponseVO(sortService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Sort bean) {
		sortService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Sort> listBean) {
		sortService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Sort> listBean) {
		sortService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getSortById")
	public ResponseVO getSortById(Integer id) {
		return getSuccessResponseVO(sortService.getSortById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateSortById")
	public ResponseVO updateSortById(Sort bean,Integer id) {
		sortService.updateSortById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteSortById")
	public ResponseVO deleteSortById(Integer id) {
		sortService.deleteSortById(id);
		return getSuccessResponseVO(null);
	}
}