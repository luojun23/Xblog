package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.LabelQuery;
import com.njtech.blog.entity.po.Label;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.LabelMapper;
import com.njtech.blog.service.LabelService;
import com.njtech.blog.utils.StringTools;


/**
 * 标签 业务接口实现
 */
@Service("labelService")
public class LabelServiceImpl implements LabelService {

	@Resource
	private LabelMapper<Label, LabelQuery> labelMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Label> findListByParam(LabelQuery param) {
		return this.labelMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(LabelQuery param) {
		return this.labelMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Label> findListByPage(LabelQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Label> list = this.findListByParam(param);
		PaginationResultVO<Label> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Label bean) {
		return this.labelMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Label> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.labelMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Label> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.labelMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Label bean, LabelQuery param) {
		StringTools.checkParam(param);
		return this.labelMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(LabelQuery param) {
		StringTools.checkParam(param);
		return this.labelMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public Label getLabelById(Integer id) {
		return this.labelMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateLabelById(Label bean, Integer id) {
		return this.labelMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteLabelById(Integer id) {
		return this.labelMapper.deleteById(id);
	}
}