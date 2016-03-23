package com.jwy.cotroller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.jwy.dao.IDeptInfoDao;
import com.jwy.dao.IUserInfoDao;
import com.jwy.dao.UserInfo;

/**
 * 
 * @author Jingweiyu
 */
public class UserOperationController extends MultiActionController {

	private IUserInfoDao userInfoDao;
	private FileUpload fileUpload;
	private IDeptInfoDao deptInfoDao;

	/**
	 * @param userInfoDao
	 *            the userInfoDao to set
	 */
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	/**
	 * @param deptInfoDao
	 *            the deptInfoDao to set
	 */
	public void setDeptInfoDao(IDeptInfoDao deptInfoDao) {
		this.deptInfoDao = deptInfoDao;
	}

	/**
	 * @param fileUpload
	 *            the fileUpload to set
	 */
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}

	public ModelAndView showUser(HttpServletRequest request,
			HttpServletResponse response) {

		List list = userInfoDao.findJion();
		return new ModelAndView("user/showUser", "list", list);
	}

	/**
	 * 添加新用户
	 * 
	 * @param request
	 * @param response
	 * @return null
	 * @throws Exception
	 */
	public ModelAndView insertUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = fileUpload.upload(request, response);// 首先上传图片，并返回表单中的其他信息
		if (map != null) { // map不为空登录账号可以使用
			UserInfo user = new UserInfo(); // 声明user实体对象
			user.setId(map.get("id"));
			user.setPwd(map.get("pwd"));
			user.setName(map.get("name"));
			user.setSex(map.get("sex"));
			user.setBirthday(map.get("birthday"));
			user.setCome(map.get("come"));
			user.setDept(Integer.valueOf(map.get("dept").toString()));
			user.setFace(map.get("face"));
			user.setRemark(map.get("remark"));
			userInfoDao.insert(user); // 调用插入数据的方法
		} else { // 登录账号已经被使用
			PrintWriter out = response.getWriter(); // 获取out对象
			out.print("<script type='text/javascript'>");
			out.print("alert('不能用此登录账号注册，此账号已经被使用！');");// 输出提示信息
			out.print("window.history.go(-1);"); // 后退网页
			out.print("</script>");
			out.close();
		}
		return null;
	}

	/**
	 * 更新用用户信息
	 * 
	 * @param request
	 * @param response
	 * @return 用户管理首页
	 * @throws Exception 
	 */
	public ModelAndView updateUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = fileUpload.upload(request, response);// 首先上传图片，并返回表单中的其他信息
		UserInfo user = new UserInfo(); // 声明user实体对象
		user.setId(map.get("id")); // 为对象属性赋值
		user.setPwd(map.get("pwd"));
		user.setName(map.get("name"));
		user.setSex(map.get("sex"));
		user.setBirthday(map.get("birthday"));
		user.setCome(map.get("come"));
		user.setDept(Integer.valueOf(map.get("dept").toString()));
		user.setFace(map.get("face"));
		user.setRemark(map.get("remark"));
		user.setNumber(Integer.valueOf(map.get("number").toString()));
		userInfoDao.update(user); // 调用更新数据库的方法
		return showUser(request, response); // 返回用户管理首页
	}

	/**
	 * 用据主键编号删除用户
	 * 
	 * @param request
	 * @param response
	 * @return null
	 * @throws Exception
	 */
	public ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer number = Integer.valueOf(request.getParameter("number")); // 获取用户编号

		UserInfo user = (UserInfo) userInfoDao.findById(number);
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "face\\"+user.getFace();			//获取照片存放路径
		
		userInfoDao.delete(number); //调用删除数据记录的方法
		new File(path).delete();	//删除照片
		
		PrintWriter out = response.getWriter(); 	//获取out对象
		out.print("<script type='text/javascript'>");
		out.print("alert('员工删除成功！');"); 		//输出提示信息
		out.print("window.location='userOperation.html?method=showUser';"); // 返回用户管理首页
		out.print("</script>");
		out.close();
		return null;
	}

	/**
	 * 跟据主键编号查找用户信息
	 * 
	 * @param request
	 * @param response
	 * @return 返回用户更新页面
	 */
	public ModelAndView findById(HttpServletRequest request,
			HttpServletResponse response) {
		String number = request.getParameter("number");
		List list = deptInfoDao.findAll(); // 查询部门编号与名称
		if (number == null || number.equals("")) { // 插入新记录
			return new ModelAndView("user/insertUser", "map", list);
		} else { // 更新记录
			UserInfo user = (UserInfo) userInfoDao.findById(Integer
					.valueOf(number));
			Map map = new HashMap();
			map.put("user", user);
			map.put("list", list);
			System.out.println(user.getName());
			return new ModelAndView("user/updateUser", "map", map);
		}
	}
}
