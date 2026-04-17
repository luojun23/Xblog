package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.WeiYanQuery;
import com.njtech.blog.entity.po.WeiYan;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 微言表 业务接口
 */
public interface WeiYanService {

	/**
	 * 根据条件查询列表
	 */
	List<WeiYan> findListByParam(WeiYanQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(WeiYanQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<WeiYan> findListByPage(WeiYanQuery param);

	/**
	 * 新增
	 */
	Integer add(WeiYan bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<WeiYan> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<WeiYan> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(WeiYan bean,WeiYanQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(WeiYanQuery param);

	/**
	 * 根据Id查询对象
	 */
	WeiYan getWeiYanById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateWeiYanById(WeiYan bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteWeiYanById(Integer id);

}