package com.suime.context.model;
import java.io.Serializable;

/**
 * user 实体类
 * Created by Lynch 06/04/2016.
 */ 
public class User implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1874115999574144703L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * name
	 */
	private String name;

	/**
	 * cellphone
	 */
	private String cellphone;

	/**
	 * mail
	 */
	private String mail;

	/**
	 * gender
	 */
	private Byte gender;

	public void setId(Long id){
	this.id=id;
	}

	public Long getId(){
		return id;
	}

	public void setName(String name){
	this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setCellphone(String cellphone){
	this.cellphone=cellphone;
	}

	public String getCellphone(){
		return cellphone;
	}

	public void setMail(String mail){
	this.mail=mail;
	}

	public String getMail(){
		return mail;
	}

	public void setGender(Byte gender){
	this.gender=gender;
	}

	public Byte getGender(){
		return gender;
	}

}