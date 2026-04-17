package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.WeiYanQuery;
import com.njtech.blog.entity.po.WeiYan;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.WeiYanService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 微言表 Controller
 */
@RestController("weiYanController")
@RequestMapping("/weiYan")
public class WeiYanController extends ABaseController{

	@Resource
	private WeiYanService weiYanService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(WeiYanQuery query){
		return getSuccessResponseVO(weiYanService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(WeiYan bean) {
		weiYanService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<WeiYan> listBean) {
		weiYanService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<WeiYan> listBean) {
		weiYanService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getWeiYanById")
	public ResponseVO getWeiYanById(Integer id) {
		return getSuccessResponseVO(weiYanService.getWeiYanById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateWeiYanById")
	public ResponseVO updateWeiYanById(WeiYan bean,Integer id) {
		weiYanService.updateWeiYanById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteWeiYanById")
	public ResponseVO deleteWeiYanById(Integer id) {
		weiYanService.deleteWeiYanById(id);
		return getSuccessResponseVO(null);
	}
}