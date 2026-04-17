package com.njtech.blog.entity.po;

import java.io.Serializable;


/**
 * 网站信息表
 */
public class WebInfo implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 网站名称
	 */
	private String webName;

	/**
	 * 网站信息
	 */
	private String webTitle;

	/**
	 * 公告
	 */
	private String notices;

	/**
	 * 页脚
	 */
	private String footer;

	/**
	 * 背景
	 */
	private String backgroundImage;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 随机头像
	 */
	private String randomAvatar;

	/**
	 * 随机名称
	 */
	private String randomName;

	/**
	 * 随机封面
	 */
	private String randomCover;

	/**
	 * 看板娘消息
	 */
	private String waifuJson;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setWebName(String webName){
		this.webName = webName;
	}

	public String getWebName(){
		return this.webName;
	}

	public void setWebTitle(String webTitle){
		this.webTitle = webTitle;
	}

	public String getWebTitle(){
		return this.webTitle;
	}

	public void setNotices(String notices){
		this.notices = notices;
	}

	public String getNotices(){
		return this.notices;
	}

	public void setFooter(String footer){
		this.footer = footer;
	}

	public String getFooter(){
		return this.footer;
	}

	public void setBackgroundImage(String backgroundImage){
		this.backgroundImage = backgroundImage;
	}

	public String getBackgroundImage(){
		return this.backgroundImage;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return this.avatar;
	}

	public void setRandomAvatar(String randomAvatar){
		this.randomAvatar = randomAvatar;
	}

	public String getRandomAvatar(){
		return this.randomAvatar;
	}

	public void setRandomName(String randomName){
		this.randomName = randomName;
	}

	public String getRandomName(){
		return this.randomName;
	}

	public void setRandomCover(String randomCover){
		this.randomCover = randomCover;
	}

	public String getRandomCover(){
		return this.randomCover;
	}

	public void setWaifuJson(String waifuJson){
		this.waifuJson = waifuJson;
	}

	public String getWaifuJson(){
		return this.waifuJson;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，网站名称:"+(webName == null ? "空" : webName)+"，网站信息:"+(webTitle == null ? "空" : webTitle)+"，公告:"+(notices == null ? "空" : notices)+"，页脚:"+(footer == null ? "空" : footer)+"，背景:"+(backgroundImage == null ? "空" : backgroundImage)+"，头像:"+(avatar == null ? "空" : avatar)+"，随机头像:"+(randomAvatar == null ? "空" : randomAvatar)+"，随机名称:"+(randomName == null ? "空" : randomName)+"，随机封面:"+(randomCover == null ? "空" : randomCover)+"，看板娘消息:"+(waifuJson == null ? "空" : waifuJson)+"，是否启用[0:否，1:是]:"+(status == null ? "空" : status);
	}
}
