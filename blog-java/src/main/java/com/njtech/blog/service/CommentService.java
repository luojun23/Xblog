package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.CommentQuery;
import com.njtech.blog.entity.po.Comment;
import com.njtech.blog.entity.vo.PaginationResultVO;


/**
 * 文章评论表 业务接口
 */
public interface CommentService {

	/**
	 * 根据条件查询列表
	 */
	List<Comment> findListByParam(CommentQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(CommentQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Comment> findListByPage(CommentQuery param);

	/**
	 * 新增
	 */
	Integer add(Comment bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Comment> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Comment> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Comment bean,CommentQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(CommentQuery param);

	/**
	 * 根据Id查询对象
	 */
	Comment getCommentById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateCommentById(Comment bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteCommentById(Integer id);

}