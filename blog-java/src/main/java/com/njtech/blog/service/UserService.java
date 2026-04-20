package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.UserQuery;
import com.njtech.blog.entity.po.User;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.entity.vo.UserVO;


/**
 * 用户信息表 业务接口
 */
public interface UserService {

	/**
	 * 根据条件查询列表
	 */
	List<User> findListByParam(UserQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(UserQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<User> findListByPage(UserQuery param);

	/**
	 * 新增
	 */
	Integer add(User bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<User> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<User> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(User bean,UserQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(UserQuery param);



	ResponseVO<UserVO> regist(UserVO user);

	/**
	 * 发送邮箱验证码
	 * @param email 邮箱地址
	 * @return 发送结果
	 */
	ResponseVO<String> sendEmailCode(String email);

}