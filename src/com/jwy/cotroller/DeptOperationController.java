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
	 * ��ʾ���в���
	 * @param request
	 * @param response
	 * @return ���ز��Ź�����ҳ��
	 */
	public ModelAndView showDept(HttpServletRequest request,HttpServletResponse response){
		List list = deptInfoDao.findAll();	//��ȡ����������Ϣ
		return new ModelAndView("dept/showDept","list",list);
	}
	/**
	 * �������²�����Ϣ
	 * @param request
	 * @param response
	 * @return ���ز��Ź�����ҳ��
	 */
	public ModelAndView insertOrUpdateDept(HttpServletRequest request,HttpServletResponse response){
		DeptInfo dept = new DeptInfo();	//����dept����
		dept.setName(request.getParameter("name"));		//��ȡ��������
		dept.setCreateDate(request.getParameter("createDate"));	//��ȡ���Ŵ���ʱ��
		dept.setRemark(request.getParameter("remark"));	//��ȡ���Ž���
		dept.setNumber(Integer.valueOf(request.getParameter("number")));	//��ȡ���ű��
		if(dept.getNumber()==0){
			deptInfoDao.insert(dept);	//���ò��뷽��
		}else{
			deptInfoDao.update(dept);	//���ø��·���
		}
		return showDept(request, response);
	}
	
	/**
	 * ɾ��������Ϣ
	 * @param request
	 * @param response
	 * @return ���ز��Ź�����ҳ��
	 * @throws Exception
	 */
	public ModelAndView deleteDept(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Integer number = Integer.valueOf(request.getParameter("number"));
		
		//��ɾ������֮ǰ�Ȳ�ѯ�ò�������û��Ա�������������ɾ���ò���
		boolean bool = userInfoDao.findBydept(number);
		String message = "";	//��ʾ��Ϣ
		if(bool){	//������û��Ա��������ɾ��
			deptInfoDao.delete(number);	//����ɾ���ķ���
			message = "����ɾ���ɹ���";
			
		}else{		//��Ա�����ڸò���
			message = "����ɾ����Ա���Ĳ��ţ�";
		}
		PrintWriter out = response.getWriter();	//��ȡour����
		out.print("<script type='text/javascript'>");
		out.print("alert('"+message+"');");		//�����ʾ��Ϣ
		out.print("window.location='deptOperation.html?method=showDept';");	//ת�벿�Ź�����ҳ
		out.print("</script>");
		out.close();	//�ر�out����
		return null;
	}
	/**
	 * ���ղ��ű�Ų�ѯ������Ϣ
	 * @param request
	 * @param response
	 * @return ���ظ��²�����Ϣҳ��
	 */
	public ModelAndView findById(HttpServletRequest request,HttpServletResponse response){
		//���ղ��ű�Ų��Ҳ���
		DeptInfo dept = (DeptInfo) deptInfoDao.findById(Integer.valueOf(request.getParameter("number")));
		return new ModelAndView("dept/insertOrUpdateDept","dept",dept);
	}
}
