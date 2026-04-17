package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.TreeHoleQuery;
import com.njtech.blog.entity.po.TreeHole;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.TreeHoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 树洞 Controller
 */
@RestController("treeHoleController")
@RequestMapping("/treeHole")
public class TreeHoleController extends ABaseController{

	@Resource
	private TreeHoleService treeHoleService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(TreeHoleQuery query){
		return getSuccessResponseVO(treeHoleService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(TreeHole bean) {
		treeHoleService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<TreeHole> listBean) {
		treeHoleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<TreeHole> listBean) {
		treeHoleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getTreeHoleById")
	public ResponseVO getTreeHoleById(Integer id) {
		return getSuccessResponseVO(treeHoleService.getTreeHoleById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateTreeHoleById")
	public ResponseVO updateTreeHoleById(TreeHole bean,Integer id) {
		treeHoleService.updateTreeHoleById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteTreeHoleById")
	public ResponseVO deleteTreeHoleById(Integer id) {
		treeHoleService.deleteTreeHoleById(id);
		return getSuccessResponseVO(null);
	}
}