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
import com.suime.admin.service.CourseService;
import com.suime.admin.spider.CourseSpiderAbstractRestController;
import com.suime.context.model.Course;

/**
 * courseRestController
 * @author ice
 */
@RestController
@RequestMapping("/course")
public class CourseRestController extends CourseSpiderAbstractRestController {
	
	@Autowired
	private CourseService courseService;
	
	/**
     * 从数据库中获取课程列表
     * @return
     */
    @RequestMapping(path = "/list/db", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object list() {
        CommonResultBean resultBean = new CommonResultBean();
        resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
        resultBean.setBody(courseService.fetchSearchByPage(null, null, 0, 0));
        return resultBean;
    }
    
    /**
     * 从文件中获取课程列表
     * @param type
     * @param idBegin
     * @param idEnd
     * @return
     */
    @RequestMapping(path = "/list/file/{type}/{idBegin}/{idEnd}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object courseListFromFile(	@PathVariable String type,
				    					@PathVariable Integer idBegin,
				    					@PathVariable Integer idEnd
    				){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Course> courses=new ArrayList<Course>();
    	for(int i=idBegin;i<=idEnd;i++){
    		Course course=this.getCourseById(i, type);
    		if(course!=null){
    			courses.add(course);
    		}
    	}
    	resultBean.setBody(courses);
    	return resultBean;
    }
    
    @RequestMapping(path = "/insert/file/{type}/{idBegin}/{idEnd}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object insertTeachers(	@PathVariable String type,
						    		@PathVariable Integer idBegin,
						    		@PathVariable Integer idEnd
					    		){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Course> courses=new ArrayList<Course>();
    	for(int i=idBegin;i<=idEnd;i++){
    		Course course=this.getCourseById(i, type);
    		if(course!=null){
    			courses.add(course);
    			courseService.save(course);
    		}
    	}
    	resultBean.setBody(courses);
    	return resultBean;
    }
    
}
