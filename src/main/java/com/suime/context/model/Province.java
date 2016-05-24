package com.suime.context.model;
import java.io.Serializable;

/**
 * province 实体类
 * Created by Lynch 24/05/2016.
 */ 
public class Province implements Serializable {
	/**
	 * id
	 */
	private Short id;

	/**
	 * name
	 */
	private String name;

	/**
	 * actived
	 */
	private Byte actived;

	public void setId(Short id){
	this.id=id;
	}

	public Short getId(){
		return id;
	}

	public void setName(String name){
	this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setActived(Byte actived){
	this.actived=actived;
	}

	public Byte getActived(){
		return actived;
	}

}