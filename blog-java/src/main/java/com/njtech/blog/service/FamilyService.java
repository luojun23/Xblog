package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.FamilyQuery;
import com.njtech.blog.entity.po.Family;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 家庭信息 业务接口
 */
public interface FamilyService {

	/**
	 * 根据条件查询列表
	 */
	List<Family> findListByParam(FamilyQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(FamilyQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Family> findListByPage(FamilyQuery param);

	/**
	 * 新增
	 */
	Integer add(Family bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Family> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Family> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Family bean,FamilyQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(FamilyQuery param);

	/**
	 * 根据Id查询对象
	 */
	Family getFamilyById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateFamilyById(Family bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteFamilyById(Integer id);

}