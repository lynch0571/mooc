package com.suime.admin.spider;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.confucian.framework.web.AbstractRestController;

/**
 * 爬虫抽象控制类
 * @author Lynch
 * Created date: 2016年4月30日 
 * Created time: 下午11:36:51
 */
public abstract class BaseSpiderAbstractRestController extends AbstractRestController {
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
			return null;
		}
	}
}
