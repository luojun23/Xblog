package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.ArticleQuery;
import com.njtech.blog.entity.po.Article;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 文章表 业务接口
 */
public interface ArticleService {

	/**
	 * 根据条件查询列表
	 */
	List<Article> findListByParam(ArticleQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ArticleQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Article> findListByPage(ArticleQuery param);

	/**
	 * 新增
	 */
	Integer add(Article bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Article> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Article> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Article bean,ArticleQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ArticleQuery param);

	/**
	 * 根据Id查询对象
	 */
	Article getArticleById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateArticleById(Article bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteArticleById(Integer id);

}