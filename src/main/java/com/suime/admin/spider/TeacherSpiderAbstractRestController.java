package com.suime.admin.spider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;

/**
 * 教师爬虫抽象控制类
 * @author Lynch
 * Created date: 2016年4月30日 
 * Created time: 下午11:40:48
 */
public abstract class TeacherSpiderAbstractRestController extends BaseSpiderAbstractRestController {
	/**
	 * 获取教师id
	 * 
	 * @param doc
	 * @return
	 */
	public String getTeacherId(Document doc) {
		String href = doc.select(".teacher-info .tit a").attr("href");
		// 格式：/u/100203/courses?sort=publish
		return href==""?null:href.substring(href.indexOf('u') + 2, href.lastIndexOf('/'));
	}
	
	/**
	 * 获取教师昵称
	 * 
	 * @param doc
	 * @return
	 */
	public String getTeacherName(Document doc) {
		return doc.select(".teacher-info .tit a").text();
	}
	
	/**
	 * 获取教师职务
	 * 
	 * @param doc
	 * @return
	 */
	public String getTeacherJob(Document doc) {
		return doc.select(".teacher-info .job").text();
	}
	
	/**
	 * 获取教师头像
	 * 
	 * @param doc
	 * @return
	 */
	public String getTeacherPhoto(Document doc) {
		Pattern p = Pattern.compile(
				"((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)");
		Matcher m = p.matcher(doc.select(".teacher-info").html());
		if (m.find()) {
			return m.group(0);
		}
		return "";
	}
}
