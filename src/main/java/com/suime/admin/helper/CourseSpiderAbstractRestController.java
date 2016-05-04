package com.suime.admin.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.suime.context.model.Course;


/**
 * 课程爬虫抽象控制类
 * @author Lynch
 * Created date: 2016年4月30日 
 * Created time: 下午11:38:35
 */
public abstract class CourseSpiderAbstractRestController extends BaseSpiderAbstractRestController {

	/**
	 * 根据文档获取课程名称
	 * @param doc
	 * @return
	 */
	public String getCourseName(Document doc) {
		return doc.getElementsByClass("l").first().text();
	}

	/**
	 * 根据文档获取课程封面图片地址
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
	 * 根据文档获取章节数量
	 * @param doc
	 * @return
	 */
	public Byte getChapterCount(Document doc) {
		Elements chapterElements = doc.select(".chapter strong");
		return (byte) chapterElements.size();
	}
	
	/**
	 * 根据文档获取小节数量
	 * @param doc
	 * @return
	 */
	public Integer getSectionCount(Document doc) {
		Elements sectionElements = doc.select(".chapter .J-media-item");
		return sectionElements.size();
	}
	
	/**
	 * 根据文档获取课程时长(单位，秒)
	 * @param doc
	 * @return
	 */
	public int getCourseDuration(Document doc) {
		String[] time=doc.select(".static-time .meta-value strong").text().split(" ");
		int duration=0;
		if(time.length==1){
			duration+=Integer.parseInt(time[0])*60;
		}else if(time.length==2){
			duration+=Integer.parseInt(time[0])*3600+Integer.parseInt(time[1])*60;
		}
		return duration;
	}
	
	/**
	 * 根据文档获取课程学习人数
	 * @param doc
	 * @return
	 */
	public int getCourseStudentCount(Document doc) {
		return Integer.parseInt(doc.select(".statics .static-item .meta-value").last().text());
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
	
	public Course getCourseById(int courseId,String type){
		Document doc=null;
		if(type.equals("net")){
			doc=this.getNetDocumentByCourseId(courseId);
		}else{
			doc=this.getLocalDocumentByCourseId(courseId);
		}
		if(doc==null){
			return null;
		}
		Course course=new Course();
		course.setId(courseId);
		course.setName(this.getCourseName(doc));
		if(this.getTeacherId(doc)!=null){
			course.setTeacherId(Integer.parseInt(this.getTeacherId(doc)));
		}
		course.setChapterCount(this.getChapterCount(doc));
		course.setSectionCount(this.getSectionCount(doc));
		course.setStudentCount(this.getCourseStudentCount(doc));
		course.setImage(this.getCourseImg(doc));
		course.setDuration(this.getCourseDuration(doc));
		course.setStatus((byte) 0);
		return course;
	}
}
