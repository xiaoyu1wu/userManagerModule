package com.jwy.cotroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.jwy.dao.DeptInfo;
import com.jwy.dao.DeptInfoDao;
import com.jwy.dao.IDeptInfoDao;
import com.jwy.dao.IUserInfoDao;
import com.jwy.dao.UserInfoDao;

/**
 * 
 * @author Jingweiyu 
 */
public class DeptOperationController extends MultiActionController {
	private IDeptInfoDao deptInfoDao;
	private IUserInfoDao userInfoDao;

	/**
	 * @param deptInfoDao the deptInfoDao to set
	 */
	public void setDeptInfoDao(IDeptInfoDao deptInfoDao) {
		this.deptInfoDao = deptInfoDao;
	}
	/**
	 * @param userInfoDao the userInfoDao to set
	 */
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	/**
	 * 显示所有部门
	 * @param request
	 * @param response
	 * @return 返回部门管理首页面
	 */
	public ModelAndView showDept(HttpServletRequest request,HttpServletResponse response){
		List list = deptInfoDao.findAll();	//获取表中所有信息
		return new ModelAndView("dept/showDept","list",list);
	}
	/**
	 * 插入或更新部门信息
	 * @param request
	 * @param response
	 * @return 返回部门管理首页面
	 */
	public ModelAndView insertOrUpdateDept(HttpServletRequest request,HttpServletResponse response){
		DeptInfo dept = new DeptInfo();	//声明dept对象
		dept.setName(request.getParameter("name"));		//获取部门名称
		dept.setCreateDate(request.getParameter("createDate"));	//获取部门创建时间
		dept.setRemark(request.getParameter("remark"));	//获取部门介绍
		dept.setNumber(Integer.valueOf(request.getParameter("number")));	//获取部门编号
		if(dept.getNumber()==0){
			deptInfoDao.insert(dept);	//调用插入方法
		}else{
			deptInfoDao.update(dept);	//调用更新方法
		}
		return showDept(request, response);
	}
	
	/**
	 * 删除部门信息
	 * @param request
	 * @param response
	 * @return 返回部门管理首页面
	 * @throws Exception
	 */
	public ModelAndView deleteDept(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Integer number = Integer.valueOf(request.getParameter("number"));
		
		//在删除部门之前先查询该部门中有没有员工，如果有则不能删除该部门
		boolean bool = userInfoDao.findBydept(number);
		String message = "";	//提示信息
		if(bool){	//部门中没有员工，可以删除
			deptInfoDao.delete(number);	//调用删除的方法
			message = "部门删除成功！";
			
		}else{		//有员工属于该部门
			message = "不能删除有员工的部门！";
		}
		PrintWriter out = response.getWriter();	//获取our对象
		out.print("<script type='text/javascript'>");
		out.print("alert('"+message+"');");		//输出提示信息
		out.print("window.location='deptOperation.html?method=showDept';");	//转入部门管理首页
		out.print("</script>");
		out.close();	//关闭out对象
		return null;
	}
	/**
	 * 按照部门编号查询部门信息
	 * @param request
	 * @param response
	 * @return 返回更新部门信息页面
	 */
	public ModelAndView findById(HttpServletRequest request,HttpServletResponse response){
		//按照部门编号查找部门
		DeptInfo dept = (DeptInfo) deptInfoDao.findById(Integer.valueOf(request.getParameter("number")));
		return new ModelAndView("dept/insertOrUpdateDept","dept",dept);
	}
}
