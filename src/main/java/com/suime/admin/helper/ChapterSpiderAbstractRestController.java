package com.suime.admin.helper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.suime.context.model.Chapter;


/**
 * 章节爬虫抽象控制类
 * @author Lynch
 * Created date: 2016年4月30日 
 * Created time: 下午11:37:19
 */
public abstract class ChapterSpiderAbstractRestController extends BaseSpiderAbstractRestController {
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
	
	public List<Chapter> getChaptersByCourseId(int courseId,String type){
		Document doc=null;
		if(type.equals("net")){
			doc=this.getNetDocumentByCourseId(courseId);
		}else{
			doc=this.getLocalDocumentByCourseId(courseId);
		}
		if(doc==null){
			return null;
		}
		List<Chapter> chapters=new ArrayList<Chapter>();
		for(int i=0;i<getChapterCount(doc);i++){
			Chapter c=new Chapter();
			c.setCourseId(courseId);
			c.setNum((byte) (i+1));
			c.setName(getChapterNames(doc).get(i));
			c.setStatus((byte) 0);
			chapters.add(c);
		}
		return chapters;
	}
}
