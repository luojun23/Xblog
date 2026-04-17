package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.WeiYanQuery;
import com.njtech.blog.entity.po.WeiYan;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.WeiYanMapper;
import com.njtech.blog.service.WeiYanService;
import com.njtech.blog.utils.StringTools;


/**
 * 微言表 业务接口实现
 */
@Service("weiYanService")
public class WeiYanServiceImpl implements WeiYanService {

	@Resource
	private WeiYanMapper<WeiYan, WeiYanQuery> weiYanMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<WeiYan> findListByParam(WeiYanQuery param) {
		return this.weiYanMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(WeiYanQuery param) {
		return this.weiYanMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<WeiYan> findListByPage(WeiYanQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<WeiYan> list = this.findListByParam(param);
		PaginationResultVO<WeiYan> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(WeiYan bean) {
		return this.weiYanMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<WeiYan> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.weiYanMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<WeiYan> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.weiYanMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(WeiYan bean, WeiYanQuery param) {
		StringTools.checkParam(param);
		return this.weiYanMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(WeiYanQuery param) {
		StringTools.checkParam(param);
		return this.weiYanMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public WeiYan getWeiYanById(Integer id) {
		return this.weiYanMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateWeiYanById(WeiYan bean, Integer id) {
		return this.weiYanMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteWeiYanById(Integer id) {
		return this.weiYanMapper.deleteById(id);
	}
}