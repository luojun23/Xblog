package com.njtech.blog.entity.query;



/**
 * 参数配置表参数
 */
public class SysConfigQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String configName;

	private String configNameFuzzy;

	/**
	 * 键名
	 */
	private String configKey;

	private String configKeyFuzzy;

	/**
	 * 键值
	 */
	private String configValue;

	private String configValueFuzzy;

	/**
	 * 1 私用 2 公开
	 */
	private String configType;

	private String configTypeFuzzy;


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

	public void setConfigNameFuzzy(String configNameFuzzy){
		this.configNameFuzzy = configNameFuzzy;
	}

	public String getConfigNameFuzzy(){
		return this.configNameFuzzy;
	}

	public void setConfigKey(String configKey){
		this.configKey = configKey;
	}

	public String getConfigKey(){
		return this.configKey;
	}

	public void setConfigKeyFuzzy(String configKeyFuzzy){
		this.configKeyFuzzy = configKeyFuzzy;
	}

	public String getConfigKeyFuzzy(){
		return this.configKeyFuzzy;
	}

	public void setConfigValue(String configValue){
		this.configValue = configValue;
	}

	public String getConfigValue(){
		return this.configValue;
	}

	public void setConfigValueFuzzy(String configValueFuzzy){
		this.configValueFuzzy = configValueFuzzy;
	}

	public String getConfigValueFuzzy(){
		return this.configValueFuzzy;
	}

	public void setConfigType(String configType){
		this.configType = configType;
	}

	public String getConfigType(){
		return this.configType;
	}

	public void setConfigTypeFuzzy(String configTypeFuzzy){
		this.configTypeFuzzy = configTypeFuzzy;
	}

	public String getConfigTypeFuzzy(){
		return this.configTypeFuzzy;
	}

}
