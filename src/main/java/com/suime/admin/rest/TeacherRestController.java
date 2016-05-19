package com.suime.admin.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confucian.framework.dto.CommonResultBean;
import com.confucian.framework.support.Constants;
import com.suime.admin.service.TeacherService;
import com.suime.admin.spider.TeacherSpiderAbstractRestController;
import com.suime.context.model.Teacher;

/**
 * teacherRestController
 * @author ice
 */
@RestController
@RequestMapping("/teacher")
public class TeacherRestController extends TeacherSpiderAbstractRestController {
	/**
     * teacherService
     */
    @Autowired
    private TeacherService teacherService;

    /**
     * 从数据库中获取教师列表
     * @return
     */
    @RequestMapping(path = "/list/db", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object list() {
        CommonResultBean resultBean = new CommonResultBean();
        resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
        resultBean.setBody(teacherService.fetchSearchByPage(null, null, 0, 0));
        return resultBean;
    }
    
    /**
     * 从文件中获取教师列表
     * @param type
     * @param idBegin
     * @param idEnd
     * @return
     */
    @RequestMapping(path = "/list/file/{type}/{idBegin}/{idEnd}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object teacherListFromFile(	@PathVariable String type,
				    					@PathVariable Integer idBegin,
				    					@PathVariable Integer idEnd
    				){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Teacher> teachers=new ArrayList<Teacher>();
    	for(int i=idBegin;i<=idEnd;i++){
    		Document doc=null;
    		if(type.equals("local")){
    			doc=this.getLocalDocumentByCourseId(i);
    		}else if (type.equals("net")){
    			doc=this.getNetDocumentByCourseId(i);
    		}
    		if(doc!=null){
    			Teacher teacher=new Teacher();
    			if(this.getTeacherId(doc)!=null){
    				teacher.setId(Integer.parseInt(this.getTeacherId(doc)));
    				teacher.setName(this.getTeacherName(doc));
    				teacher.setJob(this.getTeacherJob(doc));
    				teacher.setPhoto(this.getTeacherPhoto(doc));
    				//去重
    				boolean isExist=false;
    				for(int j=0;j<teachers.size();j++){
    					if(teachers.get(j).getId().equals(teacher.getId())){
    						isExist=true;
    						break;
    					}
    				}
    				if(!isExist){
    					teachers.add(teacher);
    				}
    			}
    		}
    	}
    	resultBean.setBody(teachers);
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
    	List<Teacher> teachers=new ArrayList<Teacher>();
    	for(int i=idBegin;i<=idEnd;i++){
    		Document doc=null;
    		if(type.equals("local")){
    			doc=this.getLocalDocumentByCourseId(i);
    		}else if (type.equals("net")){
    			doc=this.getNetDocumentByCourseId(i);
    		}
    		if(doc!=null){
    			Teacher teacher=new Teacher();
    			if(this.getTeacherId(doc)!=null){
    				teacher.setId(Integer.parseInt(this.getTeacherId(doc)));
    				teacher.setName(this.getTeacherName(doc));
    				teacher.setJob(this.getTeacherJob(doc));
    				teacher.setPhoto(this.getTeacherPhoto(doc));
    				teacher.setStatus((byte) 0);
    				//去重
    				boolean isExist=false;
    				for(int j=0;j<teachers.size();j++){
    					if(teachers.get(j).getId().equals(teacher.getId())){
    						isExist=true;
    						break;
    					}
    				}
    				if(!isExist){
    					teachers.add(teacher);
    					teacherService.save(teacher);
    				}
    			}
    		}
    	}
    	resultBean.setBody(teachers);
    	return resultBean;
    }
    
}
