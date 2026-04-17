package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.WebInfoQuery;
import com.njtech.blog.entity.po.WebInfo;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.WebInfoMapper;
import com.njtech.blog.service.WebInfoService;
import com.njtech.blog.utils.StringTools;


/**
 * 网站信息表 业务接口实现
 */
@Service("webInfoService")
public class WebInfoServiceImpl implements WebInfoService {

	@Resource
	private WebInfoMapper<WebInfo, WebInfoQuery> webInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<WebInfo> findListByParam(WebInfoQuery param) {
		return this.webInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(WebInfoQuery param) {
		return this.webInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<WebInfo> findListByPage(WebInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<WebInfo> list = this.findListByParam(param);
		PaginationResultVO<WebInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(WebInfo bean) {
		return this.webInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<WebInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.webInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<WebInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.webInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(WebInfo bean, WebInfoQuery param) {
		StringTools.checkParam(param);
		return this.webInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(WebInfoQuery param) {
		StringTools.checkParam(param);
		return this.webInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public WebInfo getWebInfoById(Integer id) {
		return this.webInfoMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateWebInfoById(WebInfo bean, Integer id) {
		return this.webInfoMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteWebInfoById(Integer id) {
		return this.webInfoMapper.deleteById(id);
	}
}