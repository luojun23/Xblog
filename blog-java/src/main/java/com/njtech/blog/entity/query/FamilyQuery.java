package com.njtech.blog.entity.query;


/**
 * 家庭信息参数
 */
public class FamilyQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 背景封面
	 */
	private String bgCover;

	private String bgCoverFuzzy;

	/**
	 * 男生头像
	 */
	private String manCover;

	private String manCoverFuzzy;

	/**
	 * 女生头像
	 */
	private String womanCover;

	private String womanCoverFuzzy;

	/**
	 * 男生昵称
	 */
	private String manName;

	private String manNameFuzzy;

	/**
	 * 女生昵称
	 */
	private String womanName;

	private String womanNameFuzzy;

	/**
	 * 计时
	 */
	private String timing;

	private String timingFuzzy;

	/**
	 * 倒计时标题
	 */
	private String countdownTitle;

	private String countdownTitleFuzzy;

	/**
	 * 倒计时时间
	 */
	private String countdownTime;

	private String countdownTimeFuzzy;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;

	/**
	 * 额外信息
	 */
	private String familyInfo;

	private String familyInfoFuzzy;

	/**
	 * 点赞数
	 */
	private Integer likeCount;

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

	public void setBgCover(String bgCover){
		this.bgCover = bgCover;
	}

	public String getBgCover(){
		return this.bgCover;
	}

	public void setBgCoverFuzzy(String bgCoverFuzzy){
		this.bgCoverFuzzy = bgCoverFuzzy;
	}

	public String getBgCoverFuzzy(){
		return this.bgCoverFuzzy;
	}

	public void setManCover(String manCover){
		this.manCover = manCover;
	}

	public String getManCover(){
		return this.manCover;
	}

	public void setManCoverFuzzy(String manCoverFuzzy){
		this.manCoverFuzzy = manCoverFuzzy;
	}

	public String getManCoverFuzzy(){
		return this.manCoverFuzzy;
	}

	public void setWomanCover(String womanCover){
		this.womanCover = womanCover;
	}

	public String getWomanCover(){
		return this.womanCover;
	}

	public void setWomanCoverFuzzy(String womanCoverFuzzy){
		this.womanCoverFuzzy = womanCoverFuzzy;
	}

	public String getWomanCoverFuzzy(){
		return this.womanCoverFuzzy;
	}

	public void setManName(String manName){
		this.manName = manName;
	}

	public String getManName(){
		return this.manName;
	}

	public void setManNameFuzzy(String manNameFuzzy){
		this.manNameFuzzy = manNameFuzzy;
	}

	public String getManNameFuzzy(){
		return this.manNameFuzzy;
	}

	public void setWomanName(String womanName){
		this.womanName = womanName;
	}

	public String getWomanName(){
		return this.womanName;
	}

	public void setWomanNameFuzzy(String womanNameFuzzy){
		this.womanNameFuzzy = womanNameFuzzy;
	}

	public String getWomanNameFuzzy(){
		return this.womanNameFuzzy;
	}

	public void setTiming(String timing){
		this.timing = timing;
	}

	public String getTiming(){
		return this.timing;
	}

	public void setTimingFuzzy(String timingFuzzy){
		this.timingFuzzy = timingFuzzy;
	}

	public String getTimingFuzzy(){
		return this.timingFuzzy;
	}

	public void setCountdownTitle(String countdownTitle){
		this.countdownTitle = countdownTitle;
	}

	public String getCountdownTitle(){
		return this.countdownTitle;
	}

	public void setCountdownTitleFuzzy(String countdownTitleFuzzy){
		this.countdownTitleFuzzy = countdownTitleFuzzy;
	}

	public String getCountdownTitleFuzzy(){
		return this.countdownTitleFuzzy;
	}

	public void setCountdownTime(String countdownTime){
		this.countdownTime = countdownTime;
	}

	public String getCountdownTime(){
		return this.countdownTime;
	}

	public void setCountdownTimeFuzzy(String countdownTimeFuzzy){
		this.countdownTimeFuzzy = countdownTimeFuzzy;
	}

	public String getCountdownTimeFuzzy(){
		return this.countdownTimeFuzzy;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setFamilyInfo(String familyInfo){
		this.familyInfo = familyInfo;
	}

	public String getFamilyInfo(){
		return this.familyInfo;
	}

	public void setFamilyInfoFuzzy(String familyInfoFuzzy){
		this.familyInfoFuzzy = familyInfoFuzzy;
	}

	public String getFamilyInfoFuzzy(){
		return this.familyInfoFuzzy;
	}

	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}

	public Integer getLikeCount(){
		return this.likeCount;
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

}
