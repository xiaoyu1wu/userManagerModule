package com.jwy.cotroller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jwy.dao.IUserInfoDao;

/**
 * �ϴ���Ƭ
 * 
 * @author Jingweiyu
 */
public class FileUpload {

	private IUserInfoDao userInfoDao;

	/**
	 * @param userInfoDao
	 *            the userInfoDao to set
	 */
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public Map upload(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, String> map = new HashMap<String, String>();// ����map������ڱ������Ϣ
		File file = null; // �����ļ�����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List items = upload.parseRequest(request);// ����������Ϣ
		Iterator itr = items.iterator();// ö�ٷ���
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next(); // ��ȡ������
			if (!item.isFormField()) {// �ж�������ļ�
				if (!item.getName().equals("") && item.getName() != null) {// �ж��Ƿ�ѡ�����µ���Ƭ
					// �ж��û���¼�����Ƿ��Ѿ���ʹ�ã��ж����½����Ǹ���
					if (!userInfoDao.findByName(map.get("id"))
							&& map.get("number") == null) {
						Map m = null;
						return m; // ����Ѿ���ʹ�ã�����һ���յ�Map����
					}

					String name = item.getName(); // ��ȡ�ļ���չ��
					name = name.substring(name.lastIndexOf('.'), name.length());// ʹ���û���¼�˺�Ϊ�ļ�������

					file = new File(request.getSession().getServletContext()
							.getRealPath("/")
							+ "\\face", map.get("id").toString() + name); // ��ȡ��Ŀ¼��Ӧ����ʵ����·��
					item.write(file); // �����ļ��ڷ����������������
					map.put("face", map.get("id").toString() + name); // ���ļ���������map������
				}
			} else {// �����ļ���ֱ�ӽ����е���Ϣ����map����
				map.put(item.getFieldName(), new String(item.getString()
						.getBytes("iso-8859-1"), "GBK"));
			}
		}
		return map; // ����map����
	}
}
