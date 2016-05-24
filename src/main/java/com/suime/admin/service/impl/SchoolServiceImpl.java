package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.SchoolMapper;
import com.suime.context.model.School;
import com.suime.admin.service.SchoolService;

/**
 * schoolService
 * Created by Lynch 24/05/2016.
 */
@Service("schoolService")
public class SchoolServiceImpl extends GenericServiceImpl<School> implements SchoolService {

	/**
	 * schoolMapper
	 */
	@Autowired
	@Qualifier("schoolMapper")
	private SchoolMapper schoolMapper;

	@Override
	public GenericMapper<School> getGenericMapper() {
		return schoolMapper;
	}
}
