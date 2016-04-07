package com.suime.admin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confucian.framework.dto.CommonResultBean;
import com.confucian.framework.support.Constants;
import com.confucian.framework.web.AbstractRestController;
import com.confucian.mybatis.support.sql.Conds;
import com.suime.admin.service.UserService;

/**
 * userRestController
 * @author Lynch
 */
@RestController
@RequestMapping("/user")
public class UserRestController extends AbstractRestController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public Object list(){
		CommonResultBean result = new CommonResultBean();
		result.setResult(Constants.NORMAL_RESULT_RIGHT);
		
		Conds conds=new Conds();
		result.setBody(this.userService.fetchSearchByPage(conds, null, 1, 50));
		return result;
	}
}
