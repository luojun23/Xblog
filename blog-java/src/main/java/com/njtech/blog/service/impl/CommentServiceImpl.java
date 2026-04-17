package com.njtech.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.CommentQuery;
import com.njtech.blog.entity.po.Comment;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.CommentMapper;
import com.njtech.blog.service.CommentService;
import com.njtech.blog.utils.StringTools;


/**
 * 文章评论表 业务接口实现
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper<Comment, CommentQuery> commentMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Comment> findListByParam(CommentQuery param) {
		return this.commentMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(CommentQuery param) {
		return this.commentMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Comment> findListByPage(CommentQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Comment> list = this.findListByParam(param);
		PaginationResultVO<Comment> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Comment bean) {
		return this.commentMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Comment> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.commentMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Comment> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.commentMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Comment bean, CommentQuery param) {
		StringTools.checkParam(param);
		return this.commentMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(CommentQuery param) {
		StringTools.checkParam(param);
		return this.commentMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public Comment getCommentById(Integer id) {
		return this.commentMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateCommentById(Comment bean, Integer id) {
		return this.commentMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteCommentById(Integer id) {
		return this.commentMapper.deleteById(id);
	}
}