package com.njtech.blog.entity.query;



/**
 * 标签参数
 */
public class LabelQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 分类ID
	 */
	private Integer sortId;

	/**
	 * 标签名称
	 */
	private String labelName;

	private String labelNameFuzzy;

	/**
	 * 标签描述
	 */
	private String labelDescription;

	private String labelDescriptionFuzzy;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setSortId(Integer sortId){
		this.sortId = sortId;
	}

	public Integer getSortId(){
		return this.sortId;
	}

	public void setLabelName(String labelName){
		this.labelName = labelName;
	}

	public String getLabelName(){
		return this.labelName;
	}

	public void setLabelNameFuzzy(String labelNameFuzzy){
		this.labelNameFuzzy = labelNameFuzzy;
	}

	public String getLabelNameFuzzy(){
		return this.labelNameFuzzy;
	}

	public void setLabelDescription(String labelDescription){
		this.labelDescription = labelDescription;
	}

	public String getLabelDescription(){
		return this.labelDescription;
	}

	public void setLabelDescriptionFuzzy(String labelDescriptionFuzzy){
		this.labelDescriptionFuzzy = labelDescriptionFuzzy;
	}

	public String getLabelDescriptionFuzzy(){
		return this.labelDescriptionFuzzy;
	}

}
