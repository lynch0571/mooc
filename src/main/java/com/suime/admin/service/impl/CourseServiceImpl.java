package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.CourseMapper;
import com.suime.context.model.Course;
import com.suime.admin.service.CourseService;

/**
 * courseService
 * Created by Lynch 30/04/2016.
 */
@Service("courseService")
public class CourseServiceImpl extends GenericServiceImpl<Course> implements CourseService {

	/**
	 * courseMapper
	 */
	@Autowired
	@Qualifier("courseMapper")
	private CourseMapper courseMapper;

	@Override
	public GenericMapper<Course> getGenericMapper() {
		return courseMapper;
	}
}
