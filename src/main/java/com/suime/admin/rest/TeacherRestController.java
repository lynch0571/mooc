package com.suime.admin.rest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confucian.framework.dto.CommonResultBean;
import com.confucian.framework.support.Constants;
import com.suime.admin.helper.SpiderAbstractRestController;
import com.suime.admin.service.TeacherService;
import com.suime.context.model.Teacher;

/**
 * teacherRestController
 * @author ice
 */
@RestController
@RequestMapping("/teacher")
public class TeacherRestController extends SpiderAbstractRestController {
	/**
     * teacherService
     */
    @Autowired
    private TeacherService teacherService;

    /**
     * 获取教师列表
     * @return
     */
    @RequestMapping(path = "/list", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object list() {
        CommonResultBean resultBean = new CommonResultBean();
        resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
        resultBean.setBody(teacherService.fetchSearchByPage(null, null, 0, 0));
        return resultBean;
    }
    
    @RequestMapping(path = "/add", method = {RequestMethod.POST})
    @RequiresAuthentication
    public Object add(){
    	CommonResultBean resultBean = new CommonResultBean();
    	resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
    	Teacher teacher=new Teacher();
    	Document doc=this.getLocalDocumentByCourseId(6);
    	
    	teacher.setId(Integer.parseInt(this.getTeacherId(doc)));
    	teacher.setName(this.getTeacherName(doc));
    	teacher.setJob(this.getTeacherJob(doc));
    	teacher.setPhoto(this.getTeacherPhoto(doc));
    	
    	resultBean.setBody(teacher);
    	return resultBean;
    }
}
