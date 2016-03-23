package com.jwy.dao;

import java.util.List;


/**
 * 
 * @author Jingweiyu 
 */
public interface IUserInfoDao {
	/**
	 * �����������ɾ����¼
	 * @param number - �û����
	 */
	public void delete(Integer number);
	/**
	 * ��ѯ�������м�¼
	 * @return list<UserInfo>
	 */
	public List<Object> findAll();
	/**
	 * ����������Ų�ѯ�û���Ϣ
	 * @param number - �������
	 * @return �û���¼
	 */
	public Object findById(Integer number) ;
	/**
	 * ���������û���Ϣ
	 * @param o - �û�ʵ�����
	 */
	public void insert(Object o);
	/**
	 * �����û���Ϣ
	 * @param o - �û�ʵ�����
	 */
	public void update(Object o);
	/**
	 * ��֤�û���¼��Ϣ
	 * @param id - �û���¼��
	 * @param pwd - �û���¼����
	 * @return �û���Ϣ
	 */
	public List findByNamePwd(String id,String pwd);
	/**
	 * ����û�����¼�˺��Ƿ�ʹ��
	 * @param id �û���¼�˺�
	 * @return trueδ��ʹ�ã�false�ѱ�ʹ��
	 */
	public boolean findByName(String id);
	/**
	 * ʹ�ò��ű����ϲ�ѯ���û����ڲ�������
	 * @return lise
	 */
	public List findJion();
	/**
	 * ��ѯָ�������Ƿ���Ա��
	 * @param dept - ���ű��
	 * @return ����˲�����û��Ա������true���򷵻�false��
	 */
	public boolean findBydept(Integer dept);
}
