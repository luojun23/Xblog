package com.njtech.blog.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import cn.hutool.core.util.RandomUtil;
import com.njtech.blog.entity.enums.ResponseCodeEnum;
import com.njtech.blog.entity.vo.ResponseVO;
import com.njtech.blog.entity.vo.UserVO;
import com.njtech.blog.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.njtech.blog.entity.enums.PageSize;
import com.njtech.blog.entity.query.UserQuery;
import com.njtech.blog.entity.po.User;
import com.njtech.blog.entity.vo.PaginationResultVO;
import com.njtech.blog.entity.query.SimplePage;
import com.njtech.blog.mappers.UserMapper;
import com.njtech.blog.service.UserService;
import com.njtech.blog.utils.StringTools;
import org.springframework.util.StringUtils;


/**
 * 用户信息表 业务接口实现
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper<User, UserQuery> userMapper;

	@Resource
	private JavaMailSender mailSender;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Value("${spring.mail.username}")
	private String fromEmail;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<User> findListByParam(UserQuery param) {
		return this.userMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(UserQuery param) {
		return this.userMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<User> findListByPage(UserQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<User> list = this.findListByParam(param);
		PaginationResultVO<User> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(User bean) {
		return this.userMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<User> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.userMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<User> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.userMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(User bean, UserQuery param) {
		StringTools.checkParam(param);
		return this.userMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(UserQuery param) {
		StringTools.checkParam(param);
		return this.userMapper.deleteByParam(param);
	}


	@Override
	public ResponseVO<UserVO> regist(UserVO user) {
		if (user.getUsername().matches("\\d{11}")){
			throw new BusinessException("用户名不能为11位数字！");
		}
		if (user.getUsername().contains("@")) {
			throw new BusinessException("用户名不能包含@！");
		}
		if (StringUtils.hasText(user.getPhoneNumber()) && StringUtils.hasText(user.getEmail())) {
			throw new BusinessException("手机号与邮箱只能选择其中一个！");
		}

		return null;
	}

	/**
	 * 发送邮箱验证码
	 */
	@Override
	public ResponseVO<String> sendEmailCode(String email) {
		// 校验邮箱格式
		if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new BusinessException("邮箱格式不正确！");
		}

		// 生成6位数字验证码
		String code = RandomUtil.randomNumbers(6);

		// 发送邮件
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(fromEmail);
			message.setTo(email);
			message.setSubject("Xblog - 邮箱验证码");
			message.setText("您的验证码是：" + code + "\n\n验证码5分钟内有效，请勿泄露给他人。\n\n如非本人操作，请忽略此邮件。");
			mailSender.send(message);
		} catch (Exception e) {
			throw new BusinessException("邮件发送失败，请稍后重试！");
		}

		// 将验证码存入Redis，5分钟过期
		stringRedisTemplate.opsForValue().set("email:code:" + email, code, 5, TimeUnit.MINUTES);

		// 构建成功响应
		ResponseVO<String> responseVO = new ResponseVO<>();
		responseVO.setStatus("success");
		responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
		responseVO.setInfo("验证码已发送");
		responseVO.setData(null);
		return responseVO;
	}
}