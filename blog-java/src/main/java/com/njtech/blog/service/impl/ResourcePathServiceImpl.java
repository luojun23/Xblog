package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.ResourcePathQuery;
import com.njtech.blog.entity.po.ResourcePath;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.ResourcePathMapper;
import com.njtech.blog.service.ResourcePathService;
import com.njtech.blog.utils.StringTools;


/**
 * 资源聚合 业务接口实现
 */
@Service("resourcePathService")
public class ResourcePathServiceImpl implements ResourcePathService {

	@Resource
	private ResourcePathMapper<ResourcePath, ResourcePathQuery> resourcePathMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ResourcePath> findListByParam(ResourcePathQuery param) {
		return this.resourcePathMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ResourcePathQuery param) {
		return this.resourcePathMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<ResourcePath> findListByPage(ResourcePathQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<ResourcePath> list = this.findListByParam(param);
		PaginationResultVO<ResourcePath> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(ResourcePath bean) {
		return this.resourcePathMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<ResourcePath> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.resourcePathMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<ResourcePath> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.resourcePathMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(ResourcePath bean, ResourcePathQuery param) {
		StringTools.checkParam(param);
		return this.resourcePathMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ResourcePathQuery param) {
		StringTools.checkParam(param);
		return this.resourcePathMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public ResourcePath getResourcePathById(Integer id) {
		return this.resourcePathMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateResourcePathById(ResourcePath bean, Integer id) {
		return this.resourcePathMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteResourcePathById(Integer id) {
		return this.resourcePathMapper.deleteById(id);
	}
}