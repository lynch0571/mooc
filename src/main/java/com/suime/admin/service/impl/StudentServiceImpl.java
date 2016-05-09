package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.StudentMapper;
import com.suime.context.model.Student;
import com.suime.admin.service.StudentService;

/**
 * studentService
 * Created by Lynch 09/05/2016.
 */
@Service("studentService")
public class StudentServiceImpl extends GenericServiceImpl<Student> implements StudentService {

	/**
	 * studentMapper
	 */
	@Autowired
	@Qualifier("studentMapper")
	private StudentMapper studentMapper;

	@Override
	public GenericMapper<Student> getGenericMapper() {
		return studentMapper;
	}
}
