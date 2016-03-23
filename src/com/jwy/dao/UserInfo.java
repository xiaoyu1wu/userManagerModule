package com.jwy.dao;


/**
 * tb_userInfo表实体类
 * @author Jingweiyu 
 */
public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer number;		//用户编号
	private String id;			//登录帐号
	private String name;		//用户姓名
	private String sex;			//用户性别
	private String birthday;	//出生日期
	private String come;		//入职日期
	private String pwd;			//登录密码
	private Integer dept;		//所在部门编号
	private String face;		//照片路径
	private String remark;		//个人介绍

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(String id, String name, String sex, String birthday,
			String come, String pwd, Integer dept, String face, String remark) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.come = come;
		this.pwd = pwd;
		this.dept = dept;
		this.face = face;
		this.remark = remark;
	}

	// Property accessors

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCome() {
		return this.come;
	}

	public void setCome(String come) {
		this.come = come;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getDept() {
		return this.dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
	}

	public String getFace() {
		return this.face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}