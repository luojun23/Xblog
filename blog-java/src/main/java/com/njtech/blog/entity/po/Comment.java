package com.njtech.blog.entity.po;

import java.util.Date;
import com.njtech.blog.entity.enums.DateTimePatternEnum;
import com.njtech.blog.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 文章评论表
 */
public class Comment implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 评论来源标识
	 */
	private Integer source;

	/**
	 * 评论来源类型
	 */
	private String type;

	/**
	 * 父评论ID
	 */
	private Integer parentCommentId;

	/**
	 * 发表用户ID
	 */
	private Integer userId;

	/**
	 * 楼层评论ID
	 */
	private Integer floorCommentId;

	/**
	 * 父发表用户名ID
	 */
	private Integer parentUserId;

	/**
	 * 点赞数
	 */
	private Integer likeCount;

	/**
	 * 评论内容
	 */
	private String commentContent;

	/**
	 * 评论额外信息
	 */
	private String commentInfo;

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

	public void setSource(Integer source){
		this.source = source;
	}

	public Integer getSource(){
		return this.source;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setParentCommentId(Integer parentCommentId){
		this.parentCommentId = parentCommentId;
	}

	public Integer getParentCommentId(){
		return this.parentCommentId;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setFloorCommentId(Integer floorCommentId){
		this.floorCommentId = floorCommentId;
	}

	public Integer getFloorCommentId(){
		return this.floorCommentId;
	}

	public void setParentUserId(Integer parentUserId){
		this.parentUserId = parentUserId;
	}

	public Integer getParentUserId(){
		return this.parentUserId;
	}

	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}

	public Integer getLikeCount(){
		return this.likeCount;
	}

	public void setCommentContent(String commentContent){
		this.commentContent = commentContent;
	}

	public String getCommentContent(){
		return this.commentContent;
	}

	public void setCommentInfo(String commentInfo){
		this.commentInfo = commentInfo;
	}

	public String getCommentInfo(){
		return this.commentInfo;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，评论来源标识:"+(source == null ? "空" : source)+"，评论来源类型:"+(type == null ? "空" : type)+"，父评论ID:"+(parentCommentId == null ? "空" : parentCommentId)+"，发表用户ID:"+(userId == null ? "空" : userId)+"，楼层评论ID:"+(floorCommentId == null ? "空" : floorCommentId)+"，父发表用户名ID:"+(parentUserId == null ? "空" : parentUserId)+"，点赞数:"+(likeCount == null ? "空" : likeCount)+"，评论内容:"+(commentContent == null ? "空" : commentContent)+"，评论额外信息:"+(commentInfo == null ? "空" : commentInfo)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
