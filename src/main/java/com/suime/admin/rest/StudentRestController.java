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
import com.suime.admin.service.StudentService;
import com.suime.admin.spider.StudentSpiderAbstractRestController;
import com.suime.context.model.Student;

/**
 * studentRestController
 * @author ice
 */
@RestController
@RequestMapping("/student")
public class StudentRestController extends StudentSpiderAbstractRestController {
	/**
     * studentService
     */
    @Autowired
    private StudentService studentService;

    /**
     * 从数据库中获取用户列表
     * @return
     */
    @RequestMapping(path = "/list/db", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object list() {
        CommonResultBean resultBean = new CommonResultBean();
        resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
        resultBean.setBody(studentService.fetchSearchByPage(null, null, 0, 0));
        return resultBean;
    }
    
    /**
     * 从文件中获取用户列表
     * @param path
     * @param idBegin
     * @param idEnd
     * @return
     */
    @RequestMapping(path = "/list/file/{path}/{idBegin}/{idEnd}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object listFromFile(	@PathVariable String path,
				   				@PathVariable Integer idBegin,
				    			@PathVariable Integer idEnd
    				){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Student> students=new ArrayList<Student>();
    	for(int i=idBegin;i<=idEnd;i++){
    		Student stu=this.getStudentById(path,i);
    		if(stu!=null){
    			students.add(stu);
    		}
    	}
    	resultBean.setBody(students);
    	return resultBean;
    }
    
    /**
     * @param path
     * @param idBegin
     * @param idEnd
     * @return
     */
    @RequestMapping(path = "/insert/file/{path}/{idBegin}/{idEnd}", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object inserts(	@PathVariable String path,
						    @PathVariable Integer idBegin,
						    @PathVariable Integer idEnd
					    ){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	List<Student> students=new ArrayList<Student>();
    	for(int i=idBegin;i<=idEnd;i++){
    		Student stu=this.getStudentById(path,i);
    		if(stu!=null){
    			students.add(stu);
    			studentService.save(stu);
    		}
    	}
    	resultBean.setBody(students);
    	return resultBean;
    }
}
