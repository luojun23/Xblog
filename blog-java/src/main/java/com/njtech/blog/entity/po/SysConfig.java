package com.njtech.blog.entity.po;

import java.io.Serializable;


/**
 * 参数配置表
 */
public class SysConfig implements Serializable {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String configName;

	/**
	 * 键名
	 */
	private String configKey;

	/**
	 * 键值
	 */
	private String configValue;

	/**
	 * 1 私用 2 公开
	 */
	private String configType;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setConfigName(String configName){
		this.configName = configName;
	}

	public String getConfigName(){
		return this.configName;
	}

	public void setConfigKey(String configKey){
		this.configKey = configKey;
	}

	public String getConfigKey(){
		return this.configKey;
	}

	public void setConfigValue(String configValue){
		this.configValue = configValue;
	}

	public String getConfigValue(){
		return this.configValue;
	}

	public void setConfigType(String configType){
		this.configType = configType;
	}

	public String getConfigType(){
		return this.configType;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，名称:"+(configName == null ? "空" : configName)+"，键名:"+(configKey == null ? "空" : configKey)+"，键值:"+(configValue == null ? "空" : configValue)+"，1 私用 2 公开:"+(configType == null ? "空" : configType);
	}
}
