package com.jwy.dao;


/**
 * tb_deptInfo������Ϣ��ʵ����
 * @author Jingweiyu 
 */
public class DeptInfo implements java.io.Serializable {

	// Fields

	private Integer number;		//���ű��
	private String name;		//��������
	private String createDate;	//���Ŵ�������
	private String remark;		//���Ž���

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