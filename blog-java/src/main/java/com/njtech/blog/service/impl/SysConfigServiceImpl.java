package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.SysConfigQuery;
import com.njtech.blog.entity.po.SysConfig;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.SysConfigMapper;
import com.njtech.blog.service.SysConfigService;
import com.njtech.blog.utils.StringTools;


/**
 * 参数配置表 业务接口实现
 */
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

	@Resource
	private SysConfigMapper<SysConfig, SysConfigQuery> sysConfigMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<SysConfig> findListByParam(SysConfigQuery param) {
		return this.sysConfigMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(SysConfigQuery param) {
		return this.sysConfigMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<SysConfig> findListByPage(SysConfigQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<SysConfig> list = this.findListByParam(param);
		PaginationResultVO<SysConfig> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(SysConfig bean) {
		return this.sysConfigMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<SysConfig> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.sysConfigMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<SysConfig> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.sysConfigMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(SysConfig bean, SysConfigQuery param) {
		StringTools.checkParam(param);
		return this.sysConfigMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(SysConfigQuery param) {
		StringTools.checkParam(param);
		return this.sysConfigMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public SysConfig getSysConfigById(Integer id) {
		return this.sysConfigMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateSysConfigById(SysConfig bean, Integer id) {
		return this.sysConfigMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteSysConfigById(Integer id) {
		return this.sysConfigMapper.deleteById(id);
	}
}