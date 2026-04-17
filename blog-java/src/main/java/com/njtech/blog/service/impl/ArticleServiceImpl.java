package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.ArticleQuery;
import com.njtech.blog.entity.po.Article;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.ArticleMapper;
import com.njtech.blog.service.ArticleService;
import com.njtech.blog.utils.StringTools;


/**
 * 文章表 业务接口实现
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper<Article, ArticleQuery> articleMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Article> findListByParam(ArticleQuery param) {
		return this.articleMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ArticleQuery param) {
		return this.articleMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Article> findListByPage(ArticleQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Article> list = this.findListByParam(param);
		PaginationResultVO<Article> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Article bean) {
		return this.articleMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Article> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.articleMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Article> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.articleMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Article bean, ArticleQuery param) {
		StringTools.checkParam(param);
		return this.articleMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ArticleQuery param) {
		StringTools.checkParam(param);
		return this.articleMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public Article getArticleById(Integer id) {
		return this.articleMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateArticleById(Article bean, Integer id) {
		return this.articleMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteArticleById(Integer id) {
		return this.articleMapper.deleteById(id);
	}
}