package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.CityMapper;
import com.suime.context.model.City;
import com.suime.admin.service.CityService;

/**
 * cityService
 * Created by Lynch 24/05/2016.
 */
@Service("cityService")
public class CityServiceImpl extends GenericServiceImpl<City> implements CityService {

	/**
	 * cityMapper
	 */
	@Autowired
	@Qualifier("cityMapper")
	private CityMapper cityMapper;

	@Override
	public GenericMapper<City> getGenericMapper() {
		return cityMapper;
	}
}
