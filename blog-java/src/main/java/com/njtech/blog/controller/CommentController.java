package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.CommentQuery;
import com.njtech.blog.entity.po.Comment;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.CommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 文章评论表 Controller
 */
@RestController("commentController")
@RequestMapping("/comment")
public class CommentController extends ABaseController{

	@Resource
	private CommentService commentService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(CommentQuery query){
		return getSuccessResponseVO(commentService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Comment bean) {
		commentService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Comment> listBean) {
		commentService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Comment> listBean) {
		commentService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getCommentById")
	public ResponseVO getCommentById(Integer id) {
		return getSuccessResponseVO(commentService.getCommentById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateCommentById")
	public ResponseVO updateCommentById(Comment bean,Integer id) {
		commentService.updateCommentById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteCommentById")
	public ResponseVO deleteCommentById(Integer id) {
		commentService.deleteCommentById(id);
		return getSuccessResponseVO(null);
	}
}