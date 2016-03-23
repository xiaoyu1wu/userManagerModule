package com.jwy.cotroller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.jwy.dao.DeptInfo;
import com.jwy.dao.IDeptInfoDao;
import com.jwy.dao.IUserInfoDao;
import com.jwy.dao.UserInfo;

/**
 * 
 * @author Jingweiyu 
 */
public class UserLoginController extends SimpleFormController {
	private IUserInfoDao userInfoDao;
	private IDeptInfoDao deptInfoDao;
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

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView onSubmit(Object command)
			throws Exception {
		UserInfo user = (UserInfo) command;
		List list = (List) userInfoDao.findByNamePwd(user.getId(),user.getPwd());
		if(list.isEmpty()){
			return new ModelAndView(getFormView(),"error","登录失败，用户名不存在或密码不正确！");
		}else{
			user = (UserInfo) list.get(0);
			if(user.getNumber()==1){
				System.out.println("系统管理员登录");
				return new ModelAndView(getSuccessView());
			}else{
				System.out.println("普通用户登录");
				DeptInfo dept = (DeptInfo) deptInfoDao.findById(user.getDept());
				Map map = new HashMap();
				map.put("dept", dept);
				map.put("user", user);
				return new ModelAndView("userInfo","map",map);
			}
		}
	}
}
