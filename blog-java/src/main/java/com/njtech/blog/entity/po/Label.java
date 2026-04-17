package com.njtech.blog.entity.po;

import java.io.Serializable;


/**
 * 标签
 */
public class Label implements Serializable {


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

	/**
	 * 标签描述
	 */
	private String labelDescription;


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

	public void setLabelDescription(String labelDescription){
		this.labelDescription = labelDescription;
	}

	public String getLabelDescription(){
		return this.labelDescription;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，分类ID:"+(sortId == null ? "空" : sortId)+"，标签名称:"+(labelName == null ? "空" : labelName)+"，标签描述:"+(labelDescription == null ? "空" : labelDescription);
	}
}
