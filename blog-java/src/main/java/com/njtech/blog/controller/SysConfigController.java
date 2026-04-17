package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.SysConfigQuery;
import com.njtech.blog.entity.po.SysConfig;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.SysConfigService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 参数配置表 Controller
 */
@RestController("sysConfigController")
@RequestMapping("/sysConfig")
public class SysConfigController extends ABaseController{

	@Resource
	private SysConfigService sysConfigService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(SysConfigQuery query){
		return getSuccessResponseVO(sysConfigService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(SysConfig bean) {
		sysConfigService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<SysConfig> listBean) {
		sysConfigService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<SysConfig> listBean) {
		sysConfigService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getSysConfigById")
	public ResponseVO getSysConfigById(Integer id) {
		return getSuccessResponseVO(sysConfigService.getSysConfigById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateSysConfigById")
	public ResponseVO updateSysConfigById(SysConfig bean,Integer id) {
		sysConfigService.updateSysConfigById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteSysConfigById")
	public ResponseVO deleteSysConfigById(Integer id) {
		sysConfigService.deleteSysConfigById(id);
		return getSuccessResponseVO(null);
	}
}