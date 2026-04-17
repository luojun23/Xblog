package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.HistoryInfoQuery;
import com.njtech.blog.entity.po.HistoryInfo;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.HistoryInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 历史信息 Controller
 */
@RestController("historyInfoController")
@RequestMapping("/historyInfo")
public class HistoryInfoController extends ABaseController{

	@Resource
	private HistoryInfoService historyInfoService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(HistoryInfoQuery query){
		return getSuccessResponseVO(historyInfoService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(HistoryInfo bean) {
		historyInfoService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<HistoryInfo> listBean) {
		historyInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<HistoryInfo> listBean) {
		historyInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getHistoryInfoById")
	public ResponseVO getHistoryInfoById(Integer id) {
		return getSuccessResponseVO(historyInfoService.getHistoryInfoById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateHistoryInfoById")
	public ResponseVO updateHistoryInfoById(HistoryInfo bean,Integer id) {
		historyInfoService.updateHistoryInfoById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteHistoryInfoById")
	public ResponseVO deleteHistoryInfoById(Integer id) {
		historyInfoService.deleteHistoryInfoById(id);
		return getSuccessResponseVO(null);
	}
}