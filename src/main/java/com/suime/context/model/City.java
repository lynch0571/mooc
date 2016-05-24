package com.suime.context.model;
import java.io.Serializable;

/**
 * city 实体类
 * Created by Lynch 24/05/2016.
 */ 
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 677933469734754279L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * name
	 */
	private String name;

	/**
	 * provinceId
	 */
	private Short provinceId;

	/**
	 * actived
	 */
	private Byte actived;

	public void setId(Integer id){
	this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setName(String name){
	this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setProvinceId(Short provinceId){
	this.provinceId=provinceId;
	}

	public Short getProvinceId(){
		return provinceId;
	}

	public void setActived(Byte actived){
	this.actived=actived;
	}

	public Byte getActived(){
		return actived;
	}

}