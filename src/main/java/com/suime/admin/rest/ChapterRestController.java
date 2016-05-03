package com.suime.admin.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confucian.framework.dto.CommonResultBean;
import com.confucian.framework.support.Constants;
import com.suime.admin.helper.ChapterSpiderAbstractRestController;
import com.suime.admin.service.ChapterService;
import com.suime.context.model.Chapter;

/**
 * chapterRestController
 * @author ice
 */
@RestController
@RequestMapping("/chapter")
public class ChapterRestController extends ChapterSpiderAbstractRestController {

	@Autowired
	private ChapterService chapterService;
	
    @RequestMapping(path = "/list/db", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object list() {
        CommonResultBean resultBean = new CommonResultBean();
        resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
        resultBean.setBody(chapterService.fetchSearchByPage(null, null, 0, 0));
        return resultBean;
    }
    
    @RequestMapping(path = "/list/file/{type}/{id}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object getChapterlistByCourseId(	@PathVariable String type,
				    			@PathVariable Integer id
    				){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	resultBean.setBody(this.getChaptersByCourseId(id, type));
    	return resultBean;
    }
    
    /**
     * 批量操作
     * @param type
     * @param idBegin
     * @param idEnd
     * @return
     */
    @RequestMapping(path = "/list/file/{type}/{idBegin}/{idEnd}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object getChapterlist(	@PathVariable String type,
						    		@PathVariable Integer idBegin,
									@PathVariable Integer idEnd
    		){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Chapter> chapters=new ArrayList<Chapter>();
    	for(int i=idBegin;i<=idEnd;i++){
    		List<Chapter> cs=this.getChaptersByCourseId(i, type);
    		if(cs!=null){
    			chapters.addAll(cs);
    		}
    	}
    	resultBean.setBody(chapters);
    	return resultBean;
    }
    
    @RequestMapping(path = "/insert/file/{type}/{id}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object insertChapters(	@PathVariable String type,
						    		@PathVariable Integer id
					    		){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Chapter> chapters=this.getChaptersByCourseId(id, type);
    	for(Chapter c:chapters){
    		chapterService.save(c);
    	}
    	resultBean.setBody(chapters);
    	return resultBean;
    }
    
    /**
     * 批量操作
     * @param type
     * @param idBegin
     * @param idEnd
     * @return
     */
    @RequestMapping(path = "/insert/file/{type}/{idBegin}/{idEnd}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object insertChapters(	@PathVariable String type,
						    		@PathVariable Integer idBegin,
									@PathVariable Integer idEnd
								){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Chapter> chapters=new ArrayList<Chapter>();
    	for(int i=idBegin;i<=idEnd;i++){
    		List<Chapter> cs=this.getChaptersByCourseId(i, type);
    		if(cs==null){
    			continue;
    		}
    		for(Chapter c:cs){
        		chapterService.save(c);
        	}
    		chapters.addAll(cs);
    	}
    	resultBean.setBody(chapters);
    	return resultBean;
    }
    
}
