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
 * 上传照片
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
		Map<String, String> map = new HashMap<String, String>();// 声明map对象对于保存表单信息
		File file = null; // 声明文件对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List items = upload.parseRequest(request);// 解析请求信息
		Iterator itr = items.iterator();// 枚举方法
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next(); // 获取表单对象
			if (!item.isFormField()) {// 判断如果是文件
				if (!item.getName().equals("") && item.getName() != null) {// 判断是否选择了新的照片
					// 判断用户登录名称是否已经被使用，判断是新建还是更新
					if (!userInfoDao.findByName(map.get("id"))
							&& map.get("number") == null) {
						Map m = null;
						return m; // 如果已经被使用，返回一个空的Map对象
					}

					String name = item.getName(); // 获取文件扩展名
					name = name.substring(name.lastIndexOf('.'), name.length());// 使用用户登录账号为文件重命名

					file = new File(request.getSession().getServletContext()
							.getRealPath("/")
							+ "\\face", map.get("id").toString() + name); // 获取根目录对应的真实物理路径
					item.write(file); // 保存文件在服务器的物理磁盘中
					map.put("face", map.get("id").toString() + name); // 将文件名保存在map对象中
				}
			} else {// 不是文件，直接将表单中的信息存入map对象
				map.put(item.getFieldName(), new String(item.getString()
						.getBytes("iso-8859-1"), "GBK"));
			}
		}
		return map; // 返回map对象
	}
}
