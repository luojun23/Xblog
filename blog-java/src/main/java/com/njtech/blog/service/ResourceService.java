package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.ResourceQuery;
import com.njtech.blog.entity.po.Resource;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 资源信息 业务接口
 */
public interface ResourceService {

	/**
	 * 根据条件查询列表
	 */
	List<Resource> findListByParam(ResourceQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ResourceQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Resource> findListByPage(ResourceQuery param);

	/**
	 * 新增
	 */
	Integer add(Resource bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Resource> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Resource> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Resource bean,ResourceQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ResourceQuery param);

	/**
	 * 根据Id查询对象
	 */
	Resource getResourceById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateResourceById(Resource bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteResourceById(Integer id);


	/**
	 * 根据Path查询对象
	 */
	Resource getResourceByPath(String path);


	/**
	 * 根据Path修改
	 */
	Integer updateResourceByPath(Resource bean,String path);


	/**
	 * 根据Path删除
	 */
	Integer deleteResourceByPath(String path);

}