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
	 * 检证用户名密码
	 * 
	 * @param id
	 *            - 登录id
	 * @param pwd
	 *            - 登录密码
	 * @return 返回list对象
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
	 * 检证登录名称是否可用
	 * 
	 * @param id
	 *            - 登录名称
	 * @return 真，可以使用。假，已经存在。
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
	 * 使用部门编号联合查询出用户所在部门名称
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
	 * 查询指定部门是否有员工
	 * 
	 * @param dept
	 *            - 部门编号
	 * @return 如果此部门中没有员工返回true否则返回false。
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
