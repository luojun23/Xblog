package com.njtech.blog.entity.po;

import java.io.Serializable;


/**
 * 分类
 */
public class Sort implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 分类名称
	 */
	private String sortName;

	/**
	 * 分类描述
	 */
	private String sortDescription;

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

	public void setSortDescription(String sortDescription){
		this.sortDescription = sortDescription;
	}

	public String getSortDescription(){
		return this.sortDescription;
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

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，分类名称:"+(sortName == null ? "空" : sortName)+"，分类描述:"+(sortDescription == null ? "空" : sortDescription)+"，分类类型[0:导航栏分类，1:普通分类]:"+(sortType == null ? "空" : sortType)+"，分类优先级：数字小的在前面:"+(priority == null ? "空" : priority);
	}
}
