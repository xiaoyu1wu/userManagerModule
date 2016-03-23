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
	 * ������û�
	 * 
	 * @param request
	 * @param response
	 * @return null
	 * @throws Exception
	 */
	public ModelAndView insertUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = fileUpload.upload(request, response);// �����ϴ�ͼƬ�������ر��е�������Ϣ
		if (map != null) { // map��Ϊ�յ�¼�˺ſ���ʹ��
			UserInfo user = new UserInfo(); // ����userʵ�����
			user.setId(map.get("id"));
			user.setPwd(map.get("pwd"));
			user.setName(map.get("name"));
			user.setSex(map.get("sex"));
			user.setBirthday(map.get("birthday"));
			user.setCome(map.get("come"));
			user.setDept(Integer.valueOf(map.get("dept").toString()));
			user.setFace(map.get("face"));
			user.setRemark(map.get("remark"));
			userInfoDao.insert(user); // ���ò������ݵķ���
		} else { // ��¼�˺��Ѿ���ʹ��
			PrintWriter out = response.getWriter(); // ��ȡout����
			out.print("<script type='text/javascript'>");
			out.print("alert('�����ô˵�¼�˺�ע�ᣬ���˺��Ѿ���ʹ�ã�');");// �����ʾ��Ϣ
			out.print("window.history.go(-1);"); // ������ҳ
			out.print("</script>");
			out.close();
		}
		return null;
	}

	/**
	 * �������û���Ϣ
	 * 
	 * @param request
	 * @param response
	 * @return �û�������ҳ
	 * @throws Exception 
	 */
	public ModelAndView updateUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = fileUpload.upload(request, response);// �����ϴ�ͼƬ�������ر��е�������Ϣ
		UserInfo user = new UserInfo(); // ����userʵ�����
		user.setId(map.get("id")); // Ϊ�������Ը�ֵ
		user.setPwd(map.get("pwd"));
		user.setName(map.get("name"));
		user.setSex(map.get("sex"));
		user.setBirthday(map.get("birthday"));
		user.setCome(map.get("come"));
		user.setDept(Integer.valueOf(map.get("dept").toString()));
		user.setFace(map.get("face"));
		user.setRemark(map.get("remark"));
		user.setNumber(Integer.valueOf(map.get("number").toString()));
		userInfoDao.update(user); // ���ø������ݿ�ķ���
		return showUser(request, response); // �����û�������ҳ
	}

	/**
	 * �þ��������ɾ���û�
	 * 
	 * @param request
	 * @param response
	 * @return null
	 * @throws Exception
	 */
	public ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer number = Integer.valueOf(request.getParameter("number")); // ��ȡ�û����

		UserInfo user = (UserInfo) userInfoDao.findById(number);
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "face\\"+user.getFace();			//��ȡ��Ƭ���·��
		
		userInfoDao.delete(number); //����ɾ�����ݼ�¼�ķ���
		new File(path).delete();	//ɾ����Ƭ
		
		PrintWriter out = response.getWriter(); 	//��ȡout����
		out.print("<script type='text/javascript'>");
		out.print("alert('Ա��ɾ���ɹ���');"); 		//�����ʾ��Ϣ
		out.print("window.location='userOperation.html?method=showUser';"); // �����û�������ҳ
		out.print("</script>");
		out.close();
		return null;
	}

	/**
	 * ����������Ų����û���Ϣ
	 * 
	 * @param request
	 * @param response
	 * @return �����û�����ҳ��
	 */
	public ModelAndView findById(HttpServletRequest request,
			HttpServletResponse response) {
		String number = request.getParameter("number");
		List list = deptInfoDao.findAll(); // ��ѯ���ű��������
		if (number == null || number.equals("")) { // �����¼�¼
			return new ModelAndView("user/insertUser", "map", list);
		} else { // ���¼�¼
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
