package com.njtech.blog.entity.query;


/**
 * 历史信息参数
 */
public class HistoryInfoQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * ip
	 */
	private String ip;

	private String ipFuzzy;

	/**
	 * 国家
	 */
	private String nation;

	private String nationFuzzy;

	/**
	 * 省份
	 */
	private String province;

	private String provinceFuzzy;

	/**
	 * 城市
	 */
	private String city;

	private String cityFuzzy;

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

	public void setIp(String ip){
		this.ip = ip;
	}

	public String getIp(){
		return this.ip;
	}

	public void setIpFuzzy(String ipFuzzy){
		this.ipFuzzy = ipFuzzy;
	}

	public String getIpFuzzy(){
		return this.ipFuzzy;
	}

	public void setNation(String nation){
		this.nation = nation;
	}

	public String getNation(){
		return this.nation;
	}

	public void setNationFuzzy(String nationFuzzy){
		this.nationFuzzy = nationFuzzy;
	}

	public String getNationFuzzy(){
		return this.nationFuzzy;
	}

	public void setProvince(String province){
		this.province = province;
	}

	public String getProvince(){
		return this.province;
	}

	public void setProvinceFuzzy(String provinceFuzzy){
		this.provinceFuzzy = provinceFuzzy;
	}

	public String getProvinceFuzzy(){
		return this.provinceFuzzy;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return this.city;
	}

	public void setCityFuzzy(String cityFuzzy){
		this.cityFuzzy = cityFuzzy;
	}

	public String getCityFuzzy(){
		return this.cityFuzzy;
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
