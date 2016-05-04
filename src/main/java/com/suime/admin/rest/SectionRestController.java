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
import com.suime.admin.helper.SectionSpiderAbstractRestController;
import com.suime.admin.service.SectionService;
import com.suime.context.model.Section;

/**
 * sectionRestController
 * @author ice
 */
@RestController
@RequestMapping("/section")
public class SectionRestController extends SectionSpiderAbstractRestController {
	@Autowired
	private SectionService sectionService;
	
    @RequestMapping(path = "/list/db", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object list() {
        CommonResultBean resultBean = new CommonResultBean();
        resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
        resultBean.setBody(sectionService.fetchSearchByPage(null, null, 0, 0));
        return resultBean;
    }
    
    @RequestMapping(path = "/list/file/{type}/{id}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object getSectionListByCourseId(	@PathVariable String type,
				    						@PathVariable Integer id
    				){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	resultBean.setBody(this.getSectionsByCourseId(id, type));
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
    public Object getSectionlist(	@PathVariable String type,
						    		@PathVariable Integer idBegin,
									@PathVariable Integer idEnd
    		){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Section> sections=new ArrayList<Section>();
    	for(int i=idBegin;i<=idEnd;i++){
    		List<Section> ss=this.getSectionsByCourseId(i, type);
    		if(ss!=null){
    			sections.addAll(ss);
    		}
    	}
    	resultBean.setBody(sections);
    	
    	return resultBean;
    }
    
    @RequestMapping(path = "/insert/file/{type}/{id}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object insertChapters(	@PathVariable String type,
						    		@PathVariable Integer id
					    		){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Section> sections=this.getSectionsByCourseId(id, type);
    	for(Section s:sections){
    		sectionService.save(s);
    	}
    	resultBean.setBody(sections);
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
    	List<Section> sections=new ArrayList<Section>();
    	for(int i=idBegin;i<=idEnd;i++){
    		List<Section> ss=this.getSectionsByCourseId(i, type);
    		if(ss==null){
    			continue;
    		}
    		for(Section s:ss){
        		sectionService.save(s);
        	}
    		sections.addAll(ss);
    	}
    	resultBean.setBody(sections);
    	return resultBean;
    }
}
