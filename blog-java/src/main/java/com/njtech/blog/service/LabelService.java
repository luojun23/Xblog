package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.LabelQuery;
import com.njtech.blog.entity.po.Label;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 标签 业务接口
 */
public interface LabelService {

	/**
	 * 根据条件查询列表
	 */
	List<Label> findListByParam(LabelQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(LabelQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Label> findListByPage(LabelQuery param);

	/**
	 * 新增
	 */
	Integer add(Label bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Label> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Label> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Label bean,LabelQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(LabelQuery param);

	/**
	 * 根据Id查询对象
	 */
	Label getLabelById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateLabelById(Label bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteLabelById(Integer id);

}