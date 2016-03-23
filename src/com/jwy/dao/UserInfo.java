package com.jwy.dao;


/**
 * tb_userInfo��ʵ����
 * @author Jingweiyu 
 */
public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer number;		//�û����
	private String id;			//��¼�ʺ�
	private String name;		//�û�����
	private String sex;			//�û��Ա�
	private String birthday;	//��������
	private String come;		//��ְ����
	private String pwd;			//��¼����
	private Integer dept;		//���ڲ��ű��
	private String face;		//��Ƭ·��
	private String remark;		//���˽���

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