package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.UserMapper;
import com.suime.context.model.User;
import com.suime.admin.service.UserService;

/**
 * userService
 * Created by Lynch 06/04/2016.
 */
@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

	/**
	 * userMapper
	 */
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	@Override
	public GenericMapper<User> getGenericMapper() {
		return userMapper;
	}
}
