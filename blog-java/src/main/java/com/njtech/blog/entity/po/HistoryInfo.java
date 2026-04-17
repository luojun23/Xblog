package com.njtech.blog.entity.po;

import java.util.Date;
import com.njtech.blog.entity.enums.DateTimePatternEnum;
import com.njtech.blog.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 历史信息
 */
public class HistoryInfo implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * ip
	 */
	private String ip;

	/**
	 * 国家
	 */
	private String nation;

	/**
	 * 省份
	 */
	private String province;

	/**
	 * 城市
	 */
	private String city;

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

	public void setIp(String ip){
		this.ip = ip;
	}

	public String getIp(){
		return this.ip;
	}

	public void setNation(String nation){
		this.nation = nation;
	}

	public String getNation(){
		return this.nation;
	}

	public void setProvince(String province){
		this.province = province;
	}

	public String getProvince(){
		return this.province;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return this.city;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，用户ID:"+(userId == null ? "空" : userId)+"，ip:"+(ip == null ? "空" : ip)+"，国家:"+(nation == null ? "空" : nation)+"，省份:"+(province == null ? "空" : province)+"，城市:"+(city == null ? "空" : city)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
