package com.jwy.dao;

import java.util.List;

/**
 * 对tb_deptinfo表操作的dao类
 * @author Jingweiyu 
 */
public interface IDeptInfoDao {
	/**
	 * 按照主键删除一条记录 
	 * @param number 主键编号
	 */
	public void delete(Integer number);
	/**
	 * 查询所有记录
	 * @return -list对象
	 */
	public List<Object> findAll() ;
	/**
	 * 按照主键查找记录
	 * @param number 主键编号
	 * @return 返回一个实体对象
	 */
	public Object findById(Integer number);
	/**
	 * 向数据表中插入一条记录
	 * @param o 实体对象
	 */
	public void insert(Object o) ;
	/**
	 * 更新数据表中的记录
	 * @param o 实体对象
	 */
	public void update(Object o) ;
}
