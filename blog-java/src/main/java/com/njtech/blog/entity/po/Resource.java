package com.njtech.blog.entity.po;

import java.util.Date;
import com.njtech.blog.entity.enums.DateTimePatternEnum;
import com.njtech.blog.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 资源信息
 */
public class Resource implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 资源类型
	 */
	private String type;

	/**
	 * 资源路径
	 */
	private String path;

	/**
	 * 资源内容的大小，单位：字节
	 */
	private Integer size;

	/**
	 * 文件名称
	 */
	private String originalName;

	/**
	 * 资源的 MIME 类型
	 */
	private String mimeType;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;

	/**
	 * 存储平台
	 */
	private String storeType;

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

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return this.path;
	}

	public void setSize(Integer size){
		this.size = size;
	}

	public Integer getSize(){
		return this.size;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return this.originalName;
	}

	public void setMimeType(String mimeType){
		this.mimeType = mimeType;
	}

	public String getMimeType(){
		return this.mimeType;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setStoreType(String storeType){
		this.storeType = storeType;
	}

	public String getStoreType(){
		return this.storeType;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，用户ID:"+(userId == null ? "空" : userId)+"，资源类型:"+(type == null ? "空" : type)+"，资源路径:"+(path == null ? "空" : path)+"，资源内容的大小，单位：字节:"+(size == null ? "空" : size)+"，文件名称:"+(originalName == null ? "空" : originalName)+"，资源的 MIME 类型:"+(mimeType == null ? "空" : mimeType)+"，是否启用[0:否，1:是]:"+(status == null ? "空" : status)+"，存储平台:"+(storeType == null ? "空" : storeType)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
