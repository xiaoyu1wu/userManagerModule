package com.jwy.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Jingweiyu
 */
public class UserInfoDao extends HibernateDaoSupport implements IUserInfoDao {

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer number) {
		UserInfo user = (UserInfo) getHibernateTemplate().get(UserInfo.class,
				number);
		getHibernateTemplate().delete(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Object> findAll() {
		List list = getHibernateTemplate().find("FROM UserInfo");
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Object findById(Integer number) {
		UserInfo user = (UserInfo) getHibernateTemplate().get(UserInfo.class,
				number);
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Object o) {
		getHibernateTemplate().save(o);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object o) {
		getHibernateTemplate().update(o);
	}

	/**
	 * ��֤�û�������
	 * 
	 * @param id
	 *            - ��¼id
	 * @param pwd
	 *            - ��¼����
	 * @return ����list����
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List findByNamePwd(String id, String pwd) {
		List list = getHibernateTemplate()
				.find(
						"FROM UserInfo WHERE id = '" + id + "' AND pwd = '"
								+ pwd + "'");
		return list;
	}

	/**
	 * ��֤��¼�����Ƿ����
	 * 
	 * @param id
	 *            - ��¼����
	 * @return �棬����ʹ�á��٣��Ѿ����ڡ�
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean findByName(String id) {
		List list = getHibernateTemplate().find(
				"FROM UserInfo WHERE id = '" + id + "'");
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ʹ�ò��ű�����ϲ�ѯ���û����ڲ�������
	 * 
	 * @return lise
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List findJion() {
		Query q = getSession()
				.createQuery(
						"from UserInfo u,DeptInfo d where u.dept=d.number order by u.number");
		List list = q.list();
		return list;
	}

	/**
	 * ��ѯָ�������Ƿ���Ա��
	 * 
	 * @param dept
	 *            - ���ű��
	 * @return ����˲�����û��Ա������true���򷵻�false��
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean findBydept(Integer dept) {
		List list = getHibernateTemplate().find(
				"FROM UserInfo WHERE dept = '" + dept + "'");
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
