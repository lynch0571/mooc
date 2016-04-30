package com.suime.admin.helper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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
}
