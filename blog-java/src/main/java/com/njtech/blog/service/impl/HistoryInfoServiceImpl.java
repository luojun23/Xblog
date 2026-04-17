package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.HistoryInfoQuery;
import com.njtech.blog.entity.po.HistoryInfo;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.HistoryInfoMapper;
import com.njtech.blog.service.HistoryInfoService;
import com.njtech.blog.utils.StringTools;


/**
 * 历史信息 业务接口实现
 */
@Service("historyInfoService")
public class HistoryInfoServiceImpl implements HistoryInfoService {

	@Resource
	private HistoryInfoMapper<HistoryInfo, HistoryInfoQuery> historyInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<HistoryInfo> findListByParam(HistoryInfoQuery param) {
		return this.historyInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(HistoryInfoQuery param) {
		return this.historyInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<HistoryInfo> findListByPage(HistoryInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<HistoryInfo> list = this.findListByParam(param);
		PaginationResultVO<HistoryInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(HistoryInfo bean) {
		return this.historyInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<HistoryInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.historyInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<HistoryInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.historyInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(HistoryInfo bean, HistoryInfoQuery param) {
		StringTools.checkParam(param);
		return this.historyInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(HistoryInfoQuery param) {
		StringTools.checkParam(param);
		return this.historyInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public HistoryInfo getHistoryInfoById(Integer id) {
		return this.historyInfoMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateHistoryInfoById(HistoryInfo bean, Integer id) {
		return this.historyInfoMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteHistoryInfoById(Integer id) {
		return this.historyInfoMapper.deleteById(id);
	}
}