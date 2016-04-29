package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.TeacherMapper;
import com.suime.context.model.Teacher;
import com.suime.admin.service.TeacherService;

/**
 * teacherService
 * Created by Lynch 29/04/2016.
 */
@Service("teacherService")
public class TeacherServiceImpl extends GenericServiceImpl<Teacher> implements TeacherService {

	/**
	 * teacherMapper
	 */
	@Autowired
	@Qualifier("teacherMapper")
	private TeacherMapper teacherMapper;

	@Override
	public GenericMapper<Teacher> getGenericMapper() {
		return teacherMapper;
	}
}
