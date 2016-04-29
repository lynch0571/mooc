package com.suime.admin.rest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confucian.framework.dto.CommonResultBean;
import com.confucian.framework.support.Constants;
import com.confucian.framework.web.AbstractRestController;
import com.suime.admin.service.StudentService;

/**
 * studentRestController
 * @author ice
 */
@RestController
@RequestMapping("/student")
public class StudentRestController extends AbstractRestController {
	/**
     * studentService
     */
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/list", method = {RequestMethod.GET})
    @RequiresAuthentication
    public Object list() {
        CommonResultBean resultBean = new CommonResultBean();
        resultBean.setResult(Constants.NORMAL_RESULT_RIGHT);
        resultBean.setBody(studentService.fetchSearchByPage(null, null, 0, 0));
        return resultBean;
    }
}
