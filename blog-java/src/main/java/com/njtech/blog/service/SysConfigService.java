package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.SysConfigQuery;
import com.njtech.blog.entity.po.SysConfig;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 参数配置表 业务接口
 */
public interface SysConfigService {

	/**
	 * 根据条件查询列表
	 */
	List<SysConfig> findListByParam(SysConfigQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(SysConfigQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<SysConfig> findListByPage(SysConfigQuery param);

	/**
	 * 新增
	 */
	Integer add(SysConfig bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<SysConfig> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<SysConfig> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(SysConfig bean,SysConfigQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(SysConfigQuery param);

	/**
	 * 根据Id查询对象
	 */
	SysConfig getSysConfigById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateSysConfigById(SysConfig bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteSysConfigById(Integer id);

}