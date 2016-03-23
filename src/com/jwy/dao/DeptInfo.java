package com.jwy.dao;


/**
 * tb_deptInfo部门信息表实体类
 * @author Jingweiyu 
 */
public class DeptInfo implements java.io.Serializable {

	// Fields

	private Integer number;		//部门编号
	private String name;		//部门名称
	private String createDate;	//部门创建日期
	private String remark;		//部门介绍

	// Constructors

	/** default constructor */
	public DeptInfo() {
	}

	/** full constructor */
	public DeptInfo(String name, String createDate, String remark) {
		this.name = name;
		this.createDate = createDate;
		this.remark = remark;
	}

	// Property accessors

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}