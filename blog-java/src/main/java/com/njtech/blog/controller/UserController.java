package com.njtech.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.codec.Base64;
import com.njtech.blog.entity.query.UserQuery;
import com.njtech.blog.entity.po.User;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.entity.vo.UserVO;
import com.njtech.blog.service.UserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户信息表 Controller
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController extends ABaseController{

	@Resource
	private UserService userService;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 用户名/密码注册
	 */
	@RequestMapping("/regist")
	public ResponseVO<UserVO> regist(@Validated @RequestBody UserVO user) {
		return userService.regist(user);
	}

	/**
	 * 获取图形验证码
	 */
	@RequestMapping("/captcha")
	public ResponseVO<Map<String, String>> captcha(HttpSession session) {
		// 生成图形验证码，宽200，高80，4位验证码，干扰线数量5
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 80, 4, 5);
		
		// 获取验证码文本
		String code = lineCaptcha.getCode();


		// 生成唯一key
		String key = UUID.randomUUID().toString().replace("-", "");

		session.setAttribute("captcha:" + key, code);
		// 将图片转为Base64
		String imageBase64 = "data:image/png;base64," + Base64.encode(lineCaptcha.getImageBytes());
		
		Map<String, String> result = new HashMap<>();
		result.put("key", key);
		result.put("imageBase64", imageBase64);
		
		return getSuccessResponseVO(result);
	}

	/**
	 * 验证图形验证码
	 */
	@RequestMapping("/verifyCaptcha")
	public ResponseVO<Boolean> verifyCaptcha(@RequestParam String key, @RequestParam String code,HttpSession session) {
		if (key == null || code == null) {
			return getSuccessResponseVO(false);
		}
		
		String redisKey = "captcha:" + key;
		String storedCode = (String) session.getAttribute(redisKey);
		
		if (storedCode == null) {
			return getSuccessResponseVO(false);
		}
		
		// 验证成功后删除验证码
		if (storedCode.equalsIgnoreCase(code)) {
			session.removeAttribute("captcha:" + key);
			return getSuccessResponseVO(true);
		}
		
		return getSuccessResponseVO(false);
	}
}