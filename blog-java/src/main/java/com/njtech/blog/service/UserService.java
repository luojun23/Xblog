package com.njtech.blog.service;

import java.util.List;

import com.njtech.blog.entity.query.UserQuery;
import com.njtech.blog.entity.po.User;
import com.njtech.blog.entity.vo.PaginationResultVO;


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

	/**
	 * 根据Id查询对象
	 */
	User getUserById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateUserById(User bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteUserById(Integer id);


	/**
	 * 根据Username查询对象
	 */
	User getUserByUsername(String username);


	/**
	 * 根据Username修改
	 */
	Integer updateUserByUsername(User bean,String username);


	/**
	 * 根据Username删除
	 */
	Integer deleteUserByUsername(String username);

}