package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.SortQuery;
import com.njtech.blog.entity.po.Sort;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 分类 业务接口
 */
public interface SortService {

	/**
	 * 根据条件查询列表
	 */
	List<Sort> findListByParam(SortQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(SortQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Sort> findListByPage(SortQuery param);

	/**
	 * 新增
	 */
	Integer add(Sort bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Sort> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Sort> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Sort bean,SortQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(SortQuery param);

	/**
	 * 根据Id查询对象
	 */
	Sort getSortById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateSortById(Sort bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteSortById(Integer id);

}