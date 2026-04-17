package com.njtech.blog.entity.po;

import java.util.Date;
import com.njtech.blog.entity.enums.DateTimePatternEnum;
import com.njtech.blog.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 文章表
 */
public class Article implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 分类ID
	 */
	private Integer sortId;

	/**
	 * 标签ID
	 */
	private Integer labelId;

	/**
	 * 封面
	 */
	private String articleCover;

	/**
	 * 博文标题
	 */
	private String articleTitle;

	/**
	 * 博文内容
	 */
	private String articleContent;

	/**
	 * 视频链接
	 */
	private String videoUrl;

	/**
	 * 浏览量
	 */
	private Integer viewCount;

	/**
	 * 点赞数
	 */
	private Integer likeCount;

	/**
	 * 是否可见[0:否，1:是]
	 */
	private Integer viewStatus;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 提示
	 */
	private String tips;

	/**
	 * 是否推荐[0:否，1:是]
	 */
	private Integer recommendStatus;

	/**
	 * 是否启用评论[0:否，1:是]
	 */
	private Integer commentStatus;

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

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setSortId(Integer sortId){
		this.sortId = sortId;
	}

	public Integer getSortId(){
		return this.sortId;
	}

	public void setLabelId(Integer labelId){
		this.labelId = labelId;
	}

	public Integer getLabelId(){
		return this.labelId;
	}

	public void setArticleCover(String articleCover){
		this.articleCover = articleCover;
	}

	public String getArticleCover(){
		return this.articleCover;
	}

	public void setArticleTitle(String articleTitle){
		this.articleTitle = articleTitle;
	}

	public String getArticleTitle(){
		return this.articleTitle;
	}

	public void setArticleContent(String articleContent){
		this.articleContent = articleContent;
	}

	public String getArticleContent(){
		return this.articleContent;
	}

	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl(){
		return this.videoUrl;
	}

	public void setViewCount(Integer viewCount){
		this.viewCount = viewCount;
	}

	public Integer getViewCount(){
		return this.viewCount;
	}

	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}

	public Integer getLikeCount(){
		return this.likeCount;
	}

	public void setViewStatus(Integer viewStatus){
		this.viewStatus = viewStatus;
	}

	public Integer getViewStatus(){
		return this.viewStatus;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setTips(String tips){
		this.tips = tips;
	}

	public String getTips(){
		return this.tips;
	}

	public void setRecommendStatus(Integer recommendStatus){
		this.recommendStatus = recommendStatus;
	}

	public Integer getRecommendStatus(){
		return this.recommendStatus;
	}

	public void setCommentStatus(Integer commentStatus){
		this.commentStatus = commentStatus;
	}

	public Integer getCommentStatus(){
		return this.commentStatus;
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
		return "id:"+(id == null ? "空" : id)+"，用户ID:"+(userId == null ? "空" : userId)+"，分类ID:"+(sortId == null ? "空" : sortId)+"，标签ID:"+(labelId == null ? "空" : labelId)+"，封面:"+(articleCover == null ? "空" : articleCover)+"，博文标题:"+(articleTitle == null ? "空" : articleTitle)+"，博文内容:"+(articleContent == null ? "空" : articleContent)+"，视频链接:"+(videoUrl == null ? "空" : videoUrl)+"，浏览量:"+(viewCount == null ? "空" : viewCount)+"，点赞数:"+(likeCount == null ? "空" : likeCount)+"，是否可见[0:否，1:是]:"+(viewStatus == null ? "空" : viewStatus)+"，密码:"+(password == null ? "空" : password)+"，提示:"+(tips == null ? "空" : tips)+"，是否推荐[0:否，1:是]:"+(recommendStatus == null ? "空" : recommendStatus)+"，是否启用评论[0:否，1:是]:"+(commentStatus == null ? "空" : commentStatus)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最终修改时间:"+(updateTime == null ? "空" : DateUtil.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最终修改人:"+(updateBy == null ? "空" : updateBy)+"，是否启用[0:未删除，1:已删除]:"+(deleted == null ? "空" : deleted);
	}
}
