package com.njtech.blog.controller;

import java.util.List;

import com.njtech.blog.entity.query.UserQuery;
import com.njtech.blog.entity.po.User;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户信息表 Controller
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController extends ABaseController{

	@Resource
	private UserService userService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(UserQuery query){
		return getSuccessResponseVO(userService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(User bean) {
		userService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<User> listBean) {
		userService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<User> listBean) {
		userService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getUserById")
	public ResponseVO getUserById(Integer id) {
		return getSuccessResponseVO(userService.getUserById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateUserById")
	public ResponseVO updateUserById(User bean,Integer id) {
		userService.updateUserById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteUserById")
	public ResponseVO deleteUserById(Integer id) {
		userService.deleteUserById(id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username查询对象
	 */
	@RequestMapping("/getUserByUsername")
	public ResponseVO getUserByUsername(String username) {
		return getSuccessResponseVO(userService.getUserByUsername(username));
	}

	/**
	 * 根据Username修改对象
	 */
	@RequestMapping("/updateUserByUsername")
	public ResponseVO updateUserByUsername(User bean,String username) {
		userService.updateUserByUsername(bean,username);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username删除
	 */
	@RequestMapping("/deleteUserByUsername")
	public ResponseVO deleteUserByUsername(String username) {
		userService.deleteUserByUsername(username);
		return getSuccessResponseVO(null);
	}
}