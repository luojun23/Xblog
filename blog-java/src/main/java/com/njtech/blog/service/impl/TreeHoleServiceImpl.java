package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.TreeHoleQuery;
import com.njtech.blog.entity.po.TreeHole;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.TreeHoleMapper;
import com.njtech.blog.service.TreeHoleService;
import com.njtech.blog.utils.StringTools;


/**
 * 树洞 业务接口实现
 */
@Service("treeHoleService")
public class TreeHoleServiceImpl implements TreeHoleService {

	@Resource
	private TreeHoleMapper<TreeHole, TreeHoleQuery> treeHoleMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<TreeHole> findListByParam(TreeHoleQuery param) {
		return this.treeHoleMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(TreeHoleQuery param) {
		return this.treeHoleMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<TreeHole> findListByPage(TreeHoleQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<TreeHole> list = this.findListByParam(param);
		PaginationResultVO<TreeHole> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(TreeHole bean) {
		return this.treeHoleMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<TreeHole> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.treeHoleMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<TreeHole> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.treeHoleMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(TreeHole bean, TreeHoleQuery param) {
		StringTools.checkParam(param);
		return this.treeHoleMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(TreeHoleQuery param) {
		StringTools.checkParam(param);
		return this.treeHoleMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public TreeHole getTreeHoleById(Integer id) {
		return this.treeHoleMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateTreeHoleById(TreeHole bean, Integer id) {
		return this.treeHoleMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteTreeHoleById(Integer id) {
		return this.treeHoleMapper.deleteById(id);
	}
}