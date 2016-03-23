package com.jwy.dao;

import java.util.List;

/**
 * ��tb_deptinfo�������dao��
 * @author Jingweiyu 
 */
public interface IDeptInfoDao {
	/**
	 * ��������ɾ��һ����¼ 
	 * @param number �������
	 */
	public void delete(Integer number);
	/**
	 * ��ѯ���м�¼
	 * @return -list����
	 */
	public List<Object> findAll() ;
	/**
	 * �����������Ҽ�¼
	 * @param number �������
	 * @return ����һ��ʵ�����
	 */
	public Object findById(Integer number);
	/**
	 * �����ݱ��в���һ����¼
	 * @param o ʵ�����
	 */
	public void insert(Object o) ;
	/**
	 * �������ݱ��еļ�¼
	 * @param o ʵ�����
	 */
	public void update(Object o) ;
}
