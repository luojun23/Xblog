package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.HistoryInfoQuery;
import com.njtech.blog.entity.po.HistoryInfo;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 历史信息 业务接口
 */
public interface HistoryInfoService {

	/**
	 * 根据条件查询列表
	 */
	List<HistoryInfo> findListByParam(HistoryInfoQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(HistoryInfoQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<HistoryInfo> findListByPage(HistoryInfoQuery param);

	/**
	 * 新增
	 */
	Integer add(HistoryInfo bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<HistoryInfo> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<HistoryInfo> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(HistoryInfo bean,HistoryInfoQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(HistoryInfoQuery param);

	/**
	 * 根据Id查询对象
	 */
	HistoryInfo getHistoryInfoById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateHistoryInfoById(HistoryInfo bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteHistoryInfoById(Integer id);

}