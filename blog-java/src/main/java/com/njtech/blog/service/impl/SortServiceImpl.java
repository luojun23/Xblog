package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.SortQuery;
import com.njtech.blog.entity.po.Sort;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.SortMapper;
import com.njtech.blog.service.SortService;
import com.njtech.blog.utils.StringTools;


/**
 * 分类 业务接口实现
 */
@Service("sortService")
public class SortServiceImpl implements SortService {

	@Resource
	private SortMapper<Sort, SortQuery> sortMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Sort> findListByParam(SortQuery param) {
		return this.sortMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(SortQuery param) {
		return this.sortMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Sort> findListByPage(SortQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Sort> list = this.findListByParam(param);
		PaginationResultVO<Sort> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Sort bean) {
		return this.sortMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Sort> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.sortMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Sort> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.sortMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Sort bean, SortQuery param) {
		StringTools.checkParam(param);
		return this.sortMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(SortQuery param) {
		StringTools.checkParam(param);
		return this.sortMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public Sort getSortById(Integer id) {
		return this.sortMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateSortById(Sort bean, Integer id) {
		return this.sortMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteSortById(Integer id) {
		return this.sortMapper.deleteById(id);
	}
}