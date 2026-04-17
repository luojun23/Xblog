package com.njtech.blog.entity.query;


/**
 * 文章评论表参数
 */
public class CommentQuery extends BaseParam {


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

	private String typeFuzzy;

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

	private String commentContentFuzzy;

	/**
	 * 评论额外信息
	 */
	private String commentInfo;

	private String commentInfoFuzzy;

	/**
	 * 创建时间
	 */
	private String createTime;

	private String createTimeStart;

	private String createTimeEnd;


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

	public void setTypeFuzzy(String typeFuzzy){
		this.typeFuzzy = typeFuzzy;
	}

	public String getTypeFuzzy(){
		return this.typeFuzzy;
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

	public void setCommentContentFuzzy(String commentContentFuzzy){
		this.commentContentFuzzy = commentContentFuzzy;
	}

	public String getCommentContentFuzzy(){
		return this.commentContentFuzzy;
	}

	public void setCommentInfo(String commentInfo){
		this.commentInfo = commentInfo;
	}

	public String getCommentInfo(){
		return this.commentInfo;
	}

	public void setCommentInfoFuzzy(String commentInfoFuzzy){
		this.commentInfoFuzzy = commentInfoFuzzy;
	}

	public String getCommentInfoFuzzy(){
		return this.commentInfoFuzzy;
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

}
