package com.njtech.blog.entity.query;


/**
 * 用户信息表参数
 */
public class UserQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户名
	 */
	private String username;

	private String usernameFuzzy;

	/**
	 * 密码
	 */
	private String password;

	private String passwordFuzzy;

	/**
	 * 手机号
	 */
	private String phoneNumber;

	private String phoneNumberFuzzy;

	/**
	 * 用户邮箱
	 */
	private String email;

	private String emailFuzzy;

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

	private String openIdFuzzy;

	/**
	 * 头像
	 */
	private String avatar;

	private String avatarFuzzy;

	/**
	 * 赞赏
	 */
	private String admire;

	private String admireFuzzy;

	/**
	 * 订阅
	 */
	private String subscribe;

	private String subscribeFuzzy;

	/**
	 * 简介
	 */
	private String introduction;

	private String introductionFuzzy;

	/**
	 * 用户类型[0:admin，1:管理员，2:普通用户]
	 */
	private Integer userType;

	/**
	 * 创建时间
	 */
	private String createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 最终修改时间
	 */
	private String updateTime;

	private String updateTimeStart;

	private String updateTimeEnd;

	/**
	 * 最终修改人
	 */
	private String updateBy;

	private String updateByFuzzy;

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

	public void setUsernameFuzzy(String usernameFuzzy){
		this.usernameFuzzy = usernameFuzzy;
	}

	public String getUsernameFuzzy(){
		return this.usernameFuzzy;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPasswordFuzzy(String passwordFuzzy){
		this.passwordFuzzy = passwordFuzzy;
	}

	public String getPasswordFuzzy(){
		return this.passwordFuzzy;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return this.phoneNumber;
	}

	public void setPhoneNumberFuzzy(String phoneNumberFuzzy){
		this.phoneNumberFuzzy = phoneNumberFuzzy;
	}

	public String getPhoneNumberFuzzy(){
		return this.phoneNumberFuzzy;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmailFuzzy(String emailFuzzy){
		this.emailFuzzy = emailFuzzy;
	}

	public String getEmailFuzzy(){
		return this.emailFuzzy;
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

	public void setOpenIdFuzzy(String openIdFuzzy){
		this.openIdFuzzy = openIdFuzzy;
	}

	public String getOpenIdFuzzy(){
		return this.openIdFuzzy;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return this.avatar;
	}

	public void setAvatarFuzzy(String avatarFuzzy){
		this.avatarFuzzy = avatarFuzzy;
	}

	public String getAvatarFuzzy(){
		return this.avatarFuzzy;
	}

	public void setAdmire(String admire){
		this.admire = admire;
	}

	public String getAdmire(){
		return this.admire;
	}

	public void setAdmireFuzzy(String admireFuzzy){
		this.admireFuzzy = admireFuzzy;
	}

	public String getAdmireFuzzy(){
		return this.admireFuzzy;
	}

	public void setSubscribe(String subscribe){
		this.subscribe = subscribe;
	}

	public String getSubscribe(){
		return this.subscribe;
	}

	public void setSubscribeFuzzy(String subscribeFuzzy){
		this.subscribeFuzzy = subscribeFuzzy;
	}

	public String getSubscribeFuzzy(){
		return this.subscribeFuzzy;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return this.introduction;
	}

	public void setIntroductionFuzzy(String introductionFuzzy){
		this.introductionFuzzy = introductionFuzzy;
	}

	public String getIntroductionFuzzy(){
		return this.introductionFuzzy;
	}

	public void setUserType(Integer userType){
		this.userType = userType;
	}

	public Integer getUserType(){
		return this.userType;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return this.createTime;
	}

	public void setCreateTimeStart(String createTimeStart){
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart(){
		return this.createTimeStart;
	}
	public void setCreateTimeEnd(String createTimeEnd){
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd(){
		return this.createTimeEnd;
	}

	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}

	public String getUpdateTime(){
		return this.updateTime;
	}

	public void setUpdateTimeStart(String updateTimeStart){
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeStart(){
		return this.updateTimeStart;
	}
	public void setUpdateTimeEnd(String updateTimeEnd){
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTimeEnd(){
		return this.updateTimeEnd;
	}

	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}

	public String getUpdateBy(){
		return this.updateBy;
	}

	public void setUpdateByFuzzy(String updateByFuzzy){
		this.updateByFuzzy = updateByFuzzy;
	}

	public String getUpdateByFuzzy(){
		return this.updateByFuzzy;
	}

	public void setDeleted(Integer deleted){
		this.deleted = deleted;
	}

	public Integer getDeleted(){
		return this.deleted;
	}

}
