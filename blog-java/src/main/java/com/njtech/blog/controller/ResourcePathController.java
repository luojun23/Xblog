package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.ResourcePathQuery;
import com.njtech.blog.entity.po.ResourcePath;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.ResourcePathService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 资源聚合 Controller
 */
@RestController("resourcePathController")
@RequestMapping("/resourcePath")
public class ResourcePathController extends ABaseController{

	@Resource
	private ResourcePathService resourcePathService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ResourcePathQuery query){
		return getSuccessResponseVO(resourcePathService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(ResourcePath bean) {
		resourcePathService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<ResourcePath> listBean) {
		resourcePathService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<ResourcePath> listBean) {
		resourcePathService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getResourcePathById")
	public ResponseVO getResourcePathById(Integer id) {
		return getSuccessResponseVO(resourcePathService.getResourcePathById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateResourcePathById")
	public ResponseVO updateResourcePathById(ResourcePath bean,Integer id) {
		resourcePathService.updateResourcePathById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteResourcePathById")
	public ResponseVO deleteResourcePathById(Integer id) {
		resourcePathService.deleteResourcePathById(id);
		return getSuccessResponseVO(null);
	}
}