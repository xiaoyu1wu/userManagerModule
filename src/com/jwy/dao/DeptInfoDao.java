package com.jwy.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Jingweiyu 
 */
public class DeptInfoDao extends HibernateDaoSupport implements IDeptInfoDao {


	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer number) {
		DeptInfo dept = (DeptInfo)getHibernateTemplate().load(DeptInfo.class, number);
		getHibernateTemplate().delete(dept);
		
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Object> findAll() {
		List list = getHibernateTemplate().find("FROM DeptInfo");
		return list;
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Object findById(Integer number) {
		DeptInfo dept = (DeptInfo) getHibernateTemplate().get(DeptInfo.class,number);
		return dept;
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Object o) {
		getHibernateTemplate().save(o);
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object o) {
		getHibernateTemplate().update(o);
	}
}
