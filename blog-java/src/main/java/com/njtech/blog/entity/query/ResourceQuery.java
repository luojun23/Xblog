package com.njtech.blog.entity.query;


/**
 * 资源信息参数
 */
public class ResourceQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 资源类型
	 */
	private String type;

	private String typeFuzzy;

	/**
	 * 资源路径
	 */
	private String path;

	private String pathFuzzy;

	/**
	 * 资源内容的大小，单位：字节
	 */
	private Integer size;

	/**
	 * 文件名称
	 */
	private String originalName;

	private String originalNameFuzzy;

	/**
	 * 资源的 MIME 类型
	 */
	private String mimeType;

	private String mimeTypeFuzzy;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;

	/**
	 * 存储平台
	 */
	private String storeType;

	private String storeTypeFuzzy;

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

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return this.path;
	}

	public void setPathFuzzy(String pathFuzzy){
		this.pathFuzzy = pathFuzzy;
	}

	public String getPathFuzzy(){
		return this.pathFuzzy;
	}

	public void setSize(Integer size){
		this.size = size;
	}

	public Integer getSize(){
		return this.size;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return this.originalName;
	}

	public void setOriginalNameFuzzy(String originalNameFuzzy){
		this.originalNameFuzzy = originalNameFuzzy;
	}

	public String getOriginalNameFuzzy(){
		return this.originalNameFuzzy;
	}

	public void setMimeType(String mimeType){
		this.mimeType = mimeType;
	}

	public String getMimeType(){
		return this.mimeType;
	}

	public void setMimeTypeFuzzy(String mimeTypeFuzzy){
		this.mimeTypeFuzzy = mimeTypeFuzzy;
	}

	public String getMimeTypeFuzzy(){
		return this.mimeTypeFuzzy;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setStoreType(String storeType){
		this.storeType = storeType;
	}

	public String getStoreType(){
		return this.storeType;
	}

	public void setStoreTypeFuzzy(String storeTypeFuzzy){
		this.storeTypeFuzzy = storeTypeFuzzy;
	}

	public String getStoreTypeFuzzy(){
		return this.storeTypeFuzzy;
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
