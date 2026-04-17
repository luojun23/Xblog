package com.njtech.blog.entity.query;


/**
 * 资源聚合参数
 */
public class ResourcePathQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 分类
	 */
	private String classify;

	private String classifyFuzzy;

	/**
	 * 封面
	 */
	private String cover;

	private String coverFuzzy;

	/**
	 * 链接
	 */
	private String url;

	private String urlFuzzy;

	/**
	 * 简介
	 */
	private String introduction;

	private String introductionFuzzy;

	/**
	 * 资源类型
	 */
	private String type;

	private String typeFuzzy;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	private String remarkFuzzy;

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

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
	}

	public void setClassify(String classify){
		this.classify = classify;
	}

	public String getClassify(){
		return this.classify;
	}

	public void setClassifyFuzzy(String classifyFuzzy){
		this.classifyFuzzy = classifyFuzzy;
	}

	public String getClassifyFuzzy(){
		return this.classifyFuzzy;
	}

	public void setCover(String cover){
		this.cover = cover;
	}

	public String getCover(){
		return this.cover;
	}

	public void setCoverFuzzy(String coverFuzzy){
		this.coverFuzzy = coverFuzzy;
	}

	public String getCoverFuzzy(){
		return this.coverFuzzy;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrlFuzzy(String urlFuzzy){
		this.urlFuzzy = urlFuzzy;
	}

	public String getUrlFuzzy(){
		return this.urlFuzzy;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return this.introduction;
	}

	public void setIntroductionFuzzy(String introductionFuzzy){
		this.introductionFuzzy = introductionFuzzy;
	}

	public String getIntroductionFuzzy(){
		return this.introductionFuzzy;
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

	public void setRemarkFuzzy(String remarkFuzzy){
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy(){
		return this.remarkFuzzy;
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
