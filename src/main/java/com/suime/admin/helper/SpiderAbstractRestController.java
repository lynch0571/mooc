package com.suime.admin.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.confucian.framework.web.AbstractRestController;

/**
 * 爬虫抽象控制类 该类封装爬虫常用的方法，在需要用到的地方继承该类即可
 * 
 * @author Lynch Created date: 2016年4月29日 Created time: 下午11:57:20
 */
public abstract class SpiderAbstractRestController extends AbstractRestController {
	/**
	 * 在线课程路径
	 */
	private String courseNetPath = "http://www.imooc.com/learn/";
	/**
	 * 本地课程路径
	 */
	private String courseLocalPath = "/Users/fire/git/mooc/src/main/resources/html/course_";

	/**
	 * 根据课程id获取在线HTML文档
	 * 
	 * @param courseId
	 * @return
	 * @throws IOException
	 */
	public Document getNetDocumentByCourseId(int courseId) {
		try {
			return Jsoup.connect(courseNetPath + courseId).get();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 根据课程id获取本地HTML文档
	 * 
	 * @param courseId
	 * @return
	 * @throws IOException
	 */
	public Document getLocalDocumentByCourseId(int courseId){
		try {
			File in = new File(courseLocalPath + courseId + ".html");
			return Jsoup.parse(in, "UTF-8", "");
		} catch (IOException e) {
			//e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据文档获取课程名称
	 * 
	 * @param doc
	 * @return
	 */
	public String getCourseName(Document doc) {
		return doc.getElementsByClass("l").first().text();
	}

	/**
	 * 根据文档获取课程封面图片地址
	 * 
	 * @param doc
	 * @return
	 */
	public String getCourseImg(Document doc) {
		Elements scriptElements = doc.getElementsByTag("script");
		String img = null;
		for (Element script : scriptElements) {
			img = script.dataNodes().toString();
			if (img.contains("var GC")) {
				// 正则参考：http://blog.csdn.net/reylen/article/details/45870203
				Pattern p = Pattern.compile(
						"((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)");
				Matcher m = p.matcher(img);
				if (m.find()) {
					return m.group(0);
				}
			}
		}
		return "";
	}

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

	/**
	 * 根据文档获取章节列表
	 * 
	 * @param doc
	 * @return
	 */
	public List<String> getChapterNames(Document doc) {
		List<String> chapterNames = new ArrayList<String>();
		Elements chapterElements = doc.select(".chapter strong");
		for (int i = 0; i < chapterElements.size(); i++) {
			chapterNames.add(chapterElements.get(i).text());
		}
		return chapterNames;
	}

	/**
	 * 根据文档获取章节数量
	 * 
	 * @param doc
	 * @return
	 */
	public int getChapterCount(Document doc) {
		Elements chapterElements = doc.select(".chapter strong");
		return chapterElements.size();
	}

	/**
	 * 根据文档获取小节列表
	 * 
	 * @param doc
	 * @return
	 */
	public List<String> getSectionNames(Document doc) {
		List<String> sectionNames = new ArrayList<String>();
		Elements sectionElements = doc.select(".chapter .J-media-item");
		for (int i = 0; i < sectionElements.size(); i++) {
			sectionNames.add(sectionElements.get(i).text());
		}
		return sectionNames;
	}

	/**
	 * 根据文档获取小节数量
	 * 
	 * @param doc
	 * @return
	 */
	public int getSectionCount(Document doc) {
		Elements sectionElements = doc.select(".chapter .J-media-item");
		return sectionElements.size();
	}

}
