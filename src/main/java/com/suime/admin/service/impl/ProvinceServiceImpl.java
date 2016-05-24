package com.suime.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.confucian.mybatis.support.mapper.GenericMapper;
import com.confucian.mybatis.support.service.impl.GenericServiceImpl;
import com.suime.admin.dao.ProvinceMapper;
import com.suime.context.model.Province;
import com.suime.admin.service.ProvinceService;

/**
 * provinceService
 * Created by Lynch 24/05/2016.
 */
@Service("provinceService")
public class ProvinceServiceImpl extends GenericServiceImpl<Province> implements ProvinceService {

	/**
	 * provinceMapper
	 */
	@Autowired
	@Qualifier("provinceMapper")
	private ProvinceMapper provinceMapper;

	@Override
	public GenericMapper<Province> getGenericMapper() {
		return provinceMapper;
	}
}
