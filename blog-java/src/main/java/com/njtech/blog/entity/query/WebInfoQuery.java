package com.njtech.blog.entity.query;



/**
 * 网站信息表参数
 */
public class WebInfoQuery extends BaseParam {


	/**
	 * id
	 */
	private Integer id;

	/**
	 * 网站名称
	 */
	private String webName;

	private String webNameFuzzy;

	/**
	 * 网站信息
	 */
	private String webTitle;

	private String webTitleFuzzy;

	/**
	 * 公告
	 */
	private String notices;

	private String noticesFuzzy;

	/**
	 * 页脚
	 */
	private String footer;

	private String footerFuzzy;

	/**
	 * 背景
	 */
	private String backgroundImage;

	private String backgroundImageFuzzy;

	/**
	 * 头像
	 */
	private String avatar;

	private String avatarFuzzy;

	/**
	 * 随机头像
	 */
	private String randomAvatar;

	private String randomAvatarFuzzy;

	/**
	 * 随机名称
	 */
	private String randomName;

	private String randomNameFuzzy;

	/**
	 * 随机封面
	 */
	private String randomCover;

	private String randomCoverFuzzy;

	/**
	 * 看板娘消息
	 */
	private String waifuJson;

	private String waifuJsonFuzzy;

	/**
	 * 是否启用[0:否，1:是]
	 */
	private Integer status;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setWebName(String webName){
		this.webName = webName;
	}

	public String getWebName(){
		return this.webName;
	}

	public void setWebNameFuzzy(String webNameFuzzy){
		this.webNameFuzzy = webNameFuzzy;
	}

	public String getWebNameFuzzy(){
		return this.webNameFuzzy;
	}

	public void setWebTitle(String webTitle){
		this.webTitle = webTitle;
	}

	public String getWebTitle(){
		return this.webTitle;
	}

	public void setWebTitleFuzzy(String webTitleFuzzy){
		this.webTitleFuzzy = webTitleFuzzy;
	}

	public String getWebTitleFuzzy(){
		return this.webTitleFuzzy;
	}

	public void setNotices(String notices){
		this.notices = notices;
	}

	public String getNotices(){
		return this.notices;
	}

	public void setNoticesFuzzy(String noticesFuzzy){
		this.noticesFuzzy = noticesFuzzy;
	}

	public String getNoticesFuzzy(){
		return this.noticesFuzzy;
	}

	public void setFooter(String footer){
		this.footer = footer;
	}

	public String getFooter(){
		return this.footer;
	}

	public void setFooterFuzzy(String footerFuzzy){
		this.footerFuzzy = footerFuzzy;
	}

	public String getFooterFuzzy(){
		return this.footerFuzzy;
	}

	public void setBackgroundImage(String backgroundImage){
		this.backgroundImage = backgroundImage;
	}

	public String getBackgroundImage(){
		return this.backgroundImage;
	}

	public void setBackgroundImageFuzzy(String backgroundImageFuzzy){
		this.backgroundImageFuzzy = backgroundImageFuzzy;
	}

	public String getBackgroundImageFuzzy(){
		return this.backgroundImageFuzzy;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return this.avatar;
	}

	public void setAvatarFuzzy(String avatarFuzzy){
		this.avatarFuzzy = avatarFuzzy;
	}

	public String getAvatarFuzzy(){
		return this.avatarFuzzy;
	}

	public void setRandomAvatar(String randomAvatar){
		this.randomAvatar = randomAvatar;
	}

	public String getRandomAvatar(){
		return this.randomAvatar;
	}

	public void setRandomAvatarFuzzy(String randomAvatarFuzzy){
		this.randomAvatarFuzzy = randomAvatarFuzzy;
	}

	public String getRandomAvatarFuzzy(){
		return this.randomAvatarFuzzy;
	}

	public void setRandomName(String randomName){
		this.randomName = randomName;
	}

	public String getRandomName(){
		return this.randomName;
	}

	public void setRandomNameFuzzy(String randomNameFuzzy){
		this.randomNameFuzzy = randomNameFuzzy;
	}

	public String getRandomNameFuzzy(){
		return this.randomNameFuzzy;
	}

	public void setRandomCover(String randomCover){
		this.randomCover = randomCover;
	}

	public String getRandomCover(){
		return this.randomCover;
	}

	public void setRandomCoverFuzzy(String randomCoverFuzzy){
		this.randomCoverFuzzy = randomCoverFuzzy;
	}

	public String getRandomCoverFuzzy(){
		return this.randomCoverFuzzy;
	}

	public void setWaifuJson(String waifuJson){
		this.waifuJson = waifuJson;
	}

	public String getWaifuJson(){
		return this.waifuJson;
	}

	public void setWaifuJsonFuzzy(String waifuJsonFuzzy){
		this.waifuJsonFuzzy = waifuJsonFuzzy;
	}

	public String getWaifuJsonFuzzy(){
		return this.waifuJsonFuzzy;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

}
