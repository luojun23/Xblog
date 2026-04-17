package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.ArticleQuery;
import com.njtech.blog.entity.po.Article;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.ArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 文章表 Controller
 */
@RestController("articleController")
@RequestMapping("/article")
public class ArticleController extends ABaseController{

	@Resource
	private ArticleService articleService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ArticleQuery query){
		return getSuccessResponseVO(articleService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Article bean) {
		articleService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Article> listBean) {
		articleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Article> listBean) {
		articleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getArticleById")
	public ResponseVO getArticleById(Integer id) {
		return getSuccessResponseVO(articleService.getArticleById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateArticleById")
	public ResponseVO updateArticleById(Article bean,Integer id) {
		articleService.updateArticleById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteArticleById")
	public ResponseVO deleteArticleById(Integer id) {
		articleService.deleteArticleById(id);
		return getSuccessResponseVO(null);
	}
}