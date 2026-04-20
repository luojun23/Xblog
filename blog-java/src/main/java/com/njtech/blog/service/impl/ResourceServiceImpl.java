package com.njtech.blog.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.ResourceQuery;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.ResourceMapper;
import com.njtech.blog.service.ResourceService;
import com.njtech.blog.utils.StringTools;

import javax.annotation.Resource;


/**
 * 资源信息 业务接口实现
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Resource
	private ResourceMapper<com.njtech.blog.entity.po.Resource, ResourceQuery> resourceMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<com.njtech.blog.entity.po.Resource> findListByParam(ResourceQuery param) {
		return this.resourceMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ResourceQuery param) {
		return this.resourceMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<com.njtech.blog.entity.po.Resource> findListByPage(ResourceQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<com.njtech.blog.entity.po.Resource> list = this.findListByParam(param);
		PaginationResultVO<com.njtech.blog.entity.po.Resource> result = new PaginationResultVO<>(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(com.njtech.blog.entity.po.Resource bean) {
		return this.resourceMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<com.njtech.blog.entity.po.Resource> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.resourceMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<com.njtech.blog.entity.po.Resource> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.resourceMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(com.njtech.blog.entity.po.Resource bean, ResourceQuery param) {
		StringTools.checkParam(param);
		return this.resourceMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ResourceQuery param) {
		StringTools.checkParam(param);
		return this.resourceMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public com.njtech.blog.entity.po.Resource getResourceById(Integer id) {
		return this.resourceMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateResourceById(com.njtech.blog.entity.po.Resource bean, Integer id) {
		return this.resourceMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteResourceById(Integer id) {
		return this.resourceMapper.deleteById(id);
	}

	/**
	 * 根据Path获取对象
	 */
	@Override
	public com.njtech.blog.entity.po.Resource getResourceByPath(String path) {
		return this.resourceMapper.selectByPath(path);
	}

	/**
	 * 根据Path修改
	 */
	@Override
	public Integer updateResourceByPath(com.njtech.blog.entity.po.	Resource bean, String path) {
		return this.resourceMapper.updateByPath(bean, path);
	}

	/**
	 * 根据Path删除
	 */
	@Override
	public Integer deleteResourceByPath(String path) {
		return this.resourceMapper.deleteByPath(path);
	}
}