package com.njtech.blog.entity.query;


/**
 * 文章表参数
 */
public class ArticleQuery extends BaseParam {


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

	private String articleCoverFuzzy;

	/**
	 * 博文标题
	 */
	private String articleTitle;

	private String articleTitleFuzzy;

	/**
	 * 博文内容
	 */
	private String articleContent;

	private String articleContentFuzzy;

	/**
	 * 视频链接
	 */
	private String videoUrl;

	private String videoUrlFuzzy;

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

	private String passwordFuzzy;

	/**
	 * 提示
	 */
	private String tips;

	private String tipsFuzzy;

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

	public void setArticleCoverFuzzy(String articleCoverFuzzy){
		this.articleCoverFuzzy = articleCoverFuzzy;
	}

	public String getArticleCoverFuzzy(){
		return this.articleCoverFuzzy;
	}

	public void setArticleTitle(String articleTitle){
		this.articleTitle = articleTitle;
	}

	public String getArticleTitle(){
		return this.articleTitle;
	}

	public void setArticleTitleFuzzy(String articleTitleFuzzy){
		this.articleTitleFuzzy = articleTitleFuzzy;
	}

	public String getArticleTitleFuzzy(){
		return this.articleTitleFuzzy;
	}

	public void setArticleContent(String articleContent){
		this.articleContent = articleContent;
	}

	public String getArticleContent(){
		return this.articleContent;
	}

	public void setArticleContentFuzzy(String articleContentFuzzy){
		this.articleContentFuzzy = articleContentFuzzy;
	}

	public String getArticleContentFuzzy(){
		return this.articleContentFuzzy;
	}

	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl(){
		return this.videoUrl;
	}

	public void setVideoUrlFuzzy(String videoUrlFuzzy){
		this.videoUrlFuzzy = videoUrlFuzzy;
	}

	public String getVideoUrlFuzzy(){
		return this.videoUrlFuzzy;
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

	public void setPasswordFuzzy(String passwordFuzzy){
		this.passwordFuzzy = passwordFuzzy;
	}

	public String getPasswordFuzzy(){
		return this.passwordFuzzy;
	}

	public void setTips(String tips){
		this.tips = tips;
	}

	public String getTips(){
		return this.tips;
	}

	public void setTipsFuzzy(String tipsFuzzy){
		this.tipsFuzzy = tipsFuzzy;
	}

	public String getTipsFuzzy(){
		return this.tipsFuzzy;
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
