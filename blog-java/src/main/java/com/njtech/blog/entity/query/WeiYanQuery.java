package com.njtech.blog.entity.query;


/**
 * 微言表参数
 */
public class WeiYanQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 点赞数
	 */
	private Integer likeCount;

	/**
	 * 内容
	 */
	private String content;

	private String contentFuzzy;

	/**
	 * 类型
	 */
	private String type;

	private String typeFuzzy;

	/**
	 * 来源标识
	 */
	private Integer source;

	/**
	 * 是否公开[0:仅自己可见，1:所有人可见]
	 */
	private Integer isPublic;

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

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}

	public Integer getLikeCount(){
		return this.likeCount;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setContentFuzzy(String contentFuzzy){
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy(){
		return this.contentFuzzy;
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

	public void setSource(Integer source){
		this.source = source;
	}

	public Integer getSource(){
		return this.source;
	}

	public void setIsPublic(Integer isPublic){
		this.isPublic = isPublic;
	}

	public Integer getIsPublic(){
		return this.isPublic;
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
