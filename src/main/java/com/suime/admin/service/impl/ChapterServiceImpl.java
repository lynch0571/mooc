package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.ChapterMapper;
import com.suime.context.model.Chapter;
import com.suime.admin.service.ChapterService;

/**
 * chapterService
 * Created by Lynch 29/04/2016.
 */
@Service("chapterService")
public class ChapterServiceImpl extends GenericServiceImpl<Chapter> implements ChapterService {

	/**
	 * chapterMapper
	 */
	@Autowired
	@Qualifier("chapterMapper")
	private ChapterMapper chapterMapper;

	@Override
	public GenericMapper<Chapter> getGenericMapper() {
		return chapterMapper;
	}
}
