package com.njtech.blog.entity.query;



/**
 * 分类参数
 */
public class SortQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 分类名称
	 */
	private String sortName;

	private String sortNameFuzzy;

	/**
	 * 分类描述
	 */
	private String sortDescription;

	private String sortDescriptionFuzzy;

	/**
	 * 分类类型[0:导航栏分类，1:普通分类]
	 */
	private Integer sortType;

	/**
	 * 分类优先级：数字小的在前面
	 */
	private Integer priority;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setSortName(String sortName){
		this.sortName = sortName;
	}

	public String getSortName(){
		return this.sortName;
	}

	public void setSortNameFuzzy(String sortNameFuzzy){
		this.sortNameFuzzy = sortNameFuzzy;
	}

	public String getSortNameFuzzy(){
		return this.sortNameFuzzy;
	}

	public void setSortDescription(String sortDescription){
		this.sortDescription = sortDescription;
	}

	public String getSortDescription(){
		return this.sortDescription;
	}

	public void setSortDescriptionFuzzy(String sortDescriptionFuzzy){
		this.sortDescriptionFuzzy = sortDescriptionFuzzy;
	}

	public String getSortDescriptionFuzzy(){
		return this.sortDescriptionFuzzy;
	}

	public void setSortType(Integer sortType){
		this.sortType = sortType;
	}

	public Integer getSortType(){
		return this.sortType;
	}

	public void setPriority(Integer priority){
		this.priority = priority;
	}

	public Integer getPriority(){
		return this.priority;
	}

}
