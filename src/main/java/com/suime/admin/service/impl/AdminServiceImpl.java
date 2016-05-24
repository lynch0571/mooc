package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.AdminMapper;
import com.suime.context.model.Admin;
import com.suime.admin.service.AdminService;

/**
 * adminService
 * Created by Lynch 24/05/2016.
 */
@Service("adminService")
public class AdminServiceImpl extends GenericServiceImpl<Admin> implements AdminService {

	/**
	 * adminMapper
	 */
	@Autowired
	@Qualifier("adminMapper")
	private AdminMapper adminMapper;

	@Override
	public GenericMapper<Admin> getGenericMapper() {
		return adminMapper;
	}
}
