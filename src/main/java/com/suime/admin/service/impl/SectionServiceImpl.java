package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.SectionMapper;
import com.suime.context.model.Section;
import com.suime.admin.service.SectionService;

/**
 * sectionService
 * Created by Lynch 29/04/2016.
 */
@Service("sectionService")
public class SectionServiceImpl extends GenericServiceImpl<Section> implements SectionService {

	/**
	 * sectionMapper
	 */
	@Autowired
	@Qualifier("sectionMapper")
	private SectionMapper sectionMapper;

	@Override
	public GenericMapper<Section> getGenericMapper() {
		return sectionMapper;
	}
}
