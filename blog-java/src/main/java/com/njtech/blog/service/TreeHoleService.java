package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.TreeHoleQuery;
import com.njtech.blog.entity.po.TreeHole;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 树洞 业务接口
 */
public interface TreeHoleService {

	/**
	 * 根据条件查询列表
	 */
	List<TreeHole> findListByParam(TreeHoleQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(TreeHoleQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<TreeHole> findListByPage(TreeHoleQuery param);

	/**
	 * 新增
	 */
	Integer add(TreeHole bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<TreeHole> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<TreeHole> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(TreeHole bean,TreeHoleQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(TreeHoleQuery param);

	/**
	 * 根据Id查询对象
	 */
	TreeHole getTreeHoleById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateTreeHoleById(TreeHole bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteTreeHoleById(Integer id);

}