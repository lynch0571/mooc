package com.suime.admin.spider;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.druid.util.StringUtils;
import com.suime.admin.Tools.MD5Util;
import com.suime.context.model.Student;


/**
 * 学生爬虫抽象控制类
 * @author Lynch
 * Created date: 2016年5月9日 
 * Created time: 下午11:55:35
 */
public abstract class StudentSpiderAbstractRestController extends BaseSpiderAbstractRestController {
	
	private static String userLocalPath="/Users/fire/Desktop/moocuser/mooc_user_2010000-2019999/user_";
	private static String userLocalPartPath="/Users/fire/Desktop/moocuser/";
	
	public Document getLocalDocumentByUserId(int userId){
		try {
			File in = new File(userLocalPath + userId + ".html");
			return Jsoup.parse(in, "UTF-8", "");
		} catch (IOException e) {
			return null;
		}
	}
	
	public Document getLocalDocumentByUserId(String path,int userId){
		try {
			File in = new File(userLocalPartPath + path + "/user_" + userId + ".html");
			return Jsoup.parse(in, "UTF-8", "");
		} catch (IOException e) {
			return null;
		}
	}
	
	/**获取用户名
	 * @param doc
	 * @return
	 */
	public String getName(Document doc){
		return doc.select(".user-name span").text();
	}
	
	/**获取用户性别
	 * @param doc
	 * @return
	 */
	public String getGender(Document doc){
		return doc.select(".about-info .gender").size()<=0?null:doc.select(".about-info .gender").get(0).attr("title");
	}

	public byte formatGender(String gender){
		if("男".equals(gender)){
			return 1;
		}else if("女".equals(gender)){
			return 2;
		}else{
			return 0;
		}
	}
	
	/**获取用户类型
	 * @param doc
	 * @return
	 */
	public String getType(Document doc){
		return doc.select(".about-info").text();
	}
	
	/**获取用户学习时长
	 * @param doc
	 * @return
	 */
	public String getStudyTime(Document doc){
		return doc.select(".study-time em").text();
	}
	
	/**获取用户积分
	 * @param doc
	 * @return
	 */
	public Integer getIntegral(Document doc){
		return StringUtils.isEmpty(doc.select(".integral em").text())?0:Integer.parseInt(doc.select(".integral em").text());
	}
	
	/**获取用户经验值
	 * @param doc
	 * @return
	 */
	public Integer getExperience(Document doc){
		return StringUtils.isEmpty(doc.select(".experience em").text())?0:Integer.parseInt(doc.select(".experience em").text());
	}
	
	public Student getStudentById(Integer userId){
		Document doc=this.getLocalDocumentByUserId(userId);
		if(doc==null){
			return null;
		}
		Student stu=new Student();
		stu.setId(userId);
		stu.setPassword(MD5Util.MD5(String.valueOf(userId)));
		stu.setName(getName(doc));
		stu.setGender(formatGender(getGender(doc)));
		stu.setType(getType(doc));
		stu.setStudyTime(getStudyTime(doc));
		stu.setIntegral(getIntegral(doc));
		stu.setExperience(getExperience(doc));
		stu.setStatus((byte)0);
		return stu;
	}
	
	public Student getStudentById(String path,Integer userId){
		Document doc=null;
		if(!path.equals("0")){
			doc=this.getLocalDocumentByUserId(path,userId);
		}else{
			doc=this.getLocalDocumentByUserId(userId);
		}
		if(doc==null){
			return null;
		}
		Student stu=new Student();
		stu.setId(userId);
		stu.setPassword(MD5Util.MD5(String.valueOf(userId)));
		stu.setName(getName(doc));
		stu.setGender(formatGender(getGender(doc)));
		stu.setType(getType(doc));
		stu.setStudyTime(getStudyTime(doc));
		stu.setIntegral(getIntegral(doc));
		stu.setExperience(getExperience(doc));
		stu.setStatus((byte)0);
		return stu;
	}
	
}
