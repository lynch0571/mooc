package com.suime.context.model;
import java.util.Date;
import java.io.Serializable;

/**
 * school 实体类
 * Created by Lynch 24/05/2016.
 */ 
public class School implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9166437232572351267L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * name
	 */
	private String name;

	/**
	 * spell
	 */
	private String spell;

	/**
	 * cityId
	 */
	private Integer cityId;

	/**
	 * actived
	 */
	private Byte actived;

	/**
	 * createdAt
	 */
	private Date createdAt;

	/**
	 * updatedAt
	 */
	private Date updatedAt;

	/**
	 * provinceId
	 */
	private Long provinceId;

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

	public void setSpell(String spell){
	this.spell=spell;
	}

	public String getSpell(){
		return spell;
	}

	public void setCityId(Integer cityId){
	this.cityId=cityId;
	}

	public Integer getCityId(){
		return cityId;
	}

	public void setActived(Byte actived){
	this.actived=actived;
	}

	public Byte getActived(){
		return actived;
	}

	public void setCreatedAt(Date createdAt){
	this.createdAt=createdAt;
	}

	public Date getCreatedAt(){
		return createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
	this.updatedAt=updatedAt;
	}

	public Date getUpdatedAt(){
		return updatedAt;
	}

	public void setProvinceId(Long provinceId){
	this.provinceId=provinceId;
	}

	public Long getProvinceId(){
		return provinceId;
	}

}