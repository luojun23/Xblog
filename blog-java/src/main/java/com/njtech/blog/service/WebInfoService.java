package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.WebInfoQuery;
import com.njtech.blog.entity.po.WebInfo;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 网站信息表 业务接口
 */
public interface WebInfoService {

	/**
	 * 根据条件查询列表
	 */
	List<WebInfo> findListByParam(WebInfoQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(WebInfoQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<WebInfo> findListByPage(WebInfoQuery param);

	/**
	 * 新增
	 */
	Integer add(WebInfo bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<WebInfo> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<WebInfo> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(WebInfo bean,WebInfoQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(WebInfoQuery param);

	/**
	 * 根据Id查询对象
	 */
	WebInfo getWebInfoById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateWebInfoById(WebInfo bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteWebInfoById(Integer id);

}