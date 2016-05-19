package com.suime.admin.spider;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.suime.context.model.Section;

/**
 * 小节爬虫抽象控制类
 * @author Lynch
 * Created date: 2016年4月30日 
 * Created time: 下午11:40:05
 */
public abstract class SectionSpiderAbstractRestController extends BaseSpiderAbstractRestController {

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
	 * @param doc
	 * @return
	 */
	public Integer getSectionCount(Document doc) {
		Elements sectionElements = doc.select(".chapter .J-media-item");
		return sectionElements.size();
	}
	
	public List<Section> getSectionsByCourseId(int courseId,String type){
		Document doc=null;
		if(type.equals("net")){
			doc=this.getNetDocumentByCourseId(courseId);
		}else{
			doc=this.getLocalDocumentByCourseId(courseId);
		}
		if(doc==null){
			return null;
		}
		List<Section> sections = new ArrayList<Section>();
		Elements sectionNameElements = doc.select(".chapter .J-media-item");
		for (int i = 0; i < sectionNameElements.size(); i++) {
			Section s = new Section();
			s.setCourseId(courseId);
			
			String name = sectionNameElements.get(i).text();
			s.setName(name);
			
			s.setChapterNum(Integer.parseInt(name.substring(0, name.indexOf('-')).trim()));
			
			if (sectionNameElements.get(i).attr("class").contains("studyvideo")) {
				s.setType((byte) 0);
				try {
					String time=name.substring(name.lastIndexOf('(')+1, name.lastIndexOf(')'));
					String[] times=time.split(":");
					int sec=0;
					if(times.length==1){
						sec=Integer.parseInt(times[0]);
					}else if(times.length==2){
						sec=Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
					}else if(times.length==3){
						sec=Integer.parseInt(times[0])*3600+Integer.parseInt(times[1])*60+Integer.parseInt(times[2]);
					}
					s.setDuration(sec);
				} catch (NumberFormatException e) {
					System.out.println(courseId+"------------报错----------");
				}
			} else if (sectionNameElements.get(i).attr("class").contains("practise")) {
				s.setType((byte) 1);
			} else if (sectionNameElements.get(i).attr("class").contains("programme")) {
				s.setType((byte) 2);
			}
			s.setStatus((byte)0);
			sections.add(s);
		}
		return sections;
	}
}
