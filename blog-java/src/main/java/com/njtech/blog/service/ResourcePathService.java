package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.ResourcePathQuery;
import com.njtech.blog.entity.po.ResourcePath;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 资源聚合 业务接口
 */
public interface ResourcePathService {

	/**
	 * 根据条件查询列表
	 */
	List<ResourcePath> findListByParam(ResourcePathQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ResourcePathQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ResourcePath> findListByPage(ResourcePathQuery param);

	/**
	 * 新增
	 */
	Integer add(ResourcePath bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<ResourcePath> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<ResourcePath> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(ResourcePath bean,ResourcePathQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ResourcePathQuery param);

	/**
	 * 根据Id查询对象
	 */
	ResourcePath getResourcePathById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateResourcePathById(ResourcePath bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteResourcePathById(Integer id);

}