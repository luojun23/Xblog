package com.njtech.blog.entity.po;

import java.util.Date;
import com.njtech.blog.entity.enums.DateTimePatternEnum;
import com.njtech.blog.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 用户信息表
 */
public class User implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 手机号
	 */
	private String phoneNumber;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer userStatus;

	/**
	 * 性别[1:男，2:女，0:保密]
	 */
	private Integer gender;

	/**
	 * openId
	 */
	private String openId;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 赞赏
	 */
	private String admire;

	/**
	 * 订阅
	 */
	private String subscribe;

	/**
	 * 简介
	 */
	private String introduction;

	/**
	 * 用户类型[0:admin，1:管理员，2:普通用户]
	 */
	private Integer userType;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 最终修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
	 * 最终修改人
	 */
	private String updateBy;

	/**
	 * 是否启用[0:未删除，1:已删除]
	 */
	private Integer deleted;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return this.phoneNumber;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setUserStatus(Integer userStatus){
		this.userStatus = userStatus;
	}

	public Integer getUserStatus(){
		return this.userStatus;
	}

	public void setGender(Integer gender){
		this.gender = gender;
	}

	public Integer getGender(){
		return this.gender;
	}

	public void setOpenId(String openId){
		this.openId = openId;
	}

	public String getOpenId(){
		return this.openId;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return this.avatar;
	}

	public void setAdmire(String admire){
		this.admire = admire;
	}

	public String getAdmire(){
		return this.admire;
	}

	public void setSubscribe(String subscribe){
		this.subscribe = subscribe;
	}

	public String getSubscribe(){
		return this.subscribe;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return this.introduction;
	}

	public void setUserType(Integer userType){
		this.userType = userType;
	}

	public Integer getUserType(){
		return this.userType;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}

	public Date getUpdateTime(){
		return this.updateTime;
	}

	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}

	public String getUpdateBy(){
		return this.updateBy;
	}

	public void setDeleted(Integer deleted){
		this.deleted = deleted;
	}

	public Integer getDeleted(){
		return this.deleted;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，用户名:"+(username == null ? "空" : username)+"，密码:"+(password == null ? "空" : password)+"，手机号:"+(phoneNumber == null ? "空" : phoneNumber)+"，用户邮箱:"+(email == null ? "空" : email)+"，是否启用[0:否，1:是]:"+(userStatus == null ? "空" : userStatus)+"，性别[1:男，2:女，0:保密]:"+(gender == null ? "空" : gender)+"，openId:"+(openId == null ? "空" : openId)+"，头像:"+(avatar == null ? "空" : avatar)+"，赞赏:"+(admire == null ? "空" : admire)+"，订阅:"+(subscribe == null ? "空" : subscribe)+"，简介:"+(introduction == null ? "空" : introduction)+"，用户类型[0:admin，1:管理员，2:普通用户]:"+(userType == null ? "空" : userType)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最终修改时间:"+(updateTime == null ? "空" : DateUtil.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最终修改人:"+(updateBy == null ? "空" : updateBy)+"，是否启用[0:未删除，1:已删除]:"+(deleted == null ? "空" : deleted);
	}
}
