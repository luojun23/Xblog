package com.njtech.blog.entity.po;

import java.util.Date;
import com.njtech.blog.entity.enums.DateTimePatternEnum;
import com.njtech.blog.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 家庭信息
 */
public class Family implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 背景封面
	 */
	private String bgCover;

	/**
	 * 男生头像
	 */
	private String manCover;

	/**
	 * 女生头像
	 */
	private String womanCover;

	/**
	 * 男生昵称
	 */
	private String manName;

	/**
	 * 女生昵称
	 */
	private String womanName;

	/**
	 * 计时
	 */
	private String timing;

	/**
	 * 倒计时标题
	 */
	private String countdownTitle;

	/**
	 * 倒计时时间
	 */
	private String countdownTime;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;

	/**
	 * 额外信息
	 */
	private String familyInfo;

	/**
	 * 点赞数
	 */
	private Integer likeCount;

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


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setBgCover(String bgCover){
		this.bgCover = bgCover;
	}

	public String getBgCover(){
		return this.bgCover;
	}

	public void setManCover(String manCover){
		this.manCover = manCover;
	}

	public String getManCover(){
		return this.manCover;
	}

	public void setWomanCover(String womanCover){
		this.womanCover = womanCover;
	}

	public String getWomanCover(){
		return this.womanCover;
	}

	public void setManName(String manName){
		this.manName = manName;
	}

	public String getManName(){
		return this.manName;
	}

	public void setWomanName(String womanName){
		this.womanName = womanName;
	}

	public String getWomanName(){
		return this.womanName;
	}

	public void setTiming(String timing){
		this.timing = timing;
	}

	public String getTiming(){
		return this.timing;
	}

	public void setCountdownTitle(String countdownTitle){
		this.countdownTitle = countdownTitle;
	}

	public String getCountdownTitle(){
		return this.countdownTitle;
	}

	public void setCountdownTime(String countdownTime){
		this.countdownTime = countdownTime;
	}

	public String getCountdownTime(){
		return this.countdownTime;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setFamilyInfo(String familyInfo){
		this.familyInfo = familyInfo;
	}

	public String getFamilyInfo(){
		return this.familyInfo;
	}

	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}

	public Integer getLikeCount(){
		return this.likeCount;
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

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，用户ID:"+(userId == null ? "空" : userId)+"，背景封面:"+(bgCover == null ? "空" : bgCover)+"，男生头像:"+(manCover == null ? "空" : manCover)+"，女生头像:"+(womanCover == null ? "空" : womanCover)+"，男生昵称:"+(manName == null ? "空" : manName)+"，女生昵称:"+(womanName == null ? "空" : womanName)+"，计时:"+(timing == null ? "空" : timing)+"，倒计时标题:"+(countdownTitle == null ? "空" : countdownTitle)+"，倒计时时间:"+(countdownTime == null ? "空" : countdownTime)+"，是否启用[0:否，1:是]:"+(status == null ? "空" : status)+"，额外信息:"+(familyInfo == null ? "空" : familyInfo)+"，点赞数:"+(likeCount == null ? "空" : likeCount)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最终修改时间:"+(updateTime == null ? "空" : DateUtil.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
