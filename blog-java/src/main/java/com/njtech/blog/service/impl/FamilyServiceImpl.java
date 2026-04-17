package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.FamilyQuery;
import com.njtech.blog.entity.po.Family;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.FamilyMapper;
import com.njtech.blog.service.FamilyService;
import com.njtech.blog.utils.StringTools;


/**
 * 家庭信息 业务接口实现
 */
@Service("familyService")
public class FamilyServiceImpl implements FamilyService {

	@Resource
	private FamilyMapper<Family, FamilyQuery> familyMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Family> findListByParam(FamilyQuery param) {
		return this.familyMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(FamilyQuery param) {
		return this.familyMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Family> findListByPage(FamilyQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Family> list = this.findListByParam(param);
		PaginationResultVO<Family> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Family bean) {
		return this.familyMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Family> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.familyMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Family> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.familyMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Family bean, FamilyQuery param) {
		StringTools.checkParam(param);
		return this.familyMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(FamilyQuery param) {
		StringTools.checkParam(param);
		return this.familyMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public Family getFamilyById(Integer id) {
		return this.familyMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateFamilyById(Family bean, Integer id) {
		return this.familyMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteFamilyById(Integer id) {
		return this.familyMapper.deleteById(id);
	}
}