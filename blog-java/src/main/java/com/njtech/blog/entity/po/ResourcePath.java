package com.njtech.blog.entity.po;

import java.util.Date;
import com.njtech.blog.entity.enums.DateTimePatternEnum;
import com.njtech.blog.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 资源聚合
 */
public class ResourcePath implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 分类
	 */
	private String classify;

	/**
	 * 封面
	 */
	private String cover;

	/**
	 * 链接
	 */
	private String url;

	/**
	 * 简介
	 */
	private String introduction;

	/**
	 * 资源类型
	 */
	private String type;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setClassify(String classify){
		this.classify = classify;
	}

	public String getClassify(){
		return this.classify;
	}

	public void setCover(String cover){
		this.cover = cover;
	}

	public String getCover(){
		return this.cover;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return this.introduction;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，标题:"+(title == null ? "空" : title)+"，分类:"+(classify == null ? "空" : classify)+"，封面:"+(cover == null ? "空" : cover)+"，链接:"+(url == null ? "空" : url)+"，简介:"+(introduction == null ? "空" : introduction)+"，资源类型:"+(type == null ? "空" : type)+"，是否启用[0:否，1:是]:"+(status == null ? "空" : status)+"，备注:"+(remark == null ? "空" : remark)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
