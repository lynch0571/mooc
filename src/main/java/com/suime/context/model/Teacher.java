package com.suime.context.model;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * teacher 实体类
 * Created by Lynch 30/04/2016.
 */ 
public class Teacher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5256737516773520123L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * name
	 */
	private String name;

	/**
	 * gender
	 */
	private Byte gender;

	/**
	 * cellphone
	 */
	private String cellphone;

	/**
	 * mail
	 */
	private String mail;

	/**
	 * password
	 */
	private String password;

	/**
	 * job
	 */
	private String job;

	/**
	 * photo
	 */
	private String photo;

	/**
	 * createTime
	 */
	private Timestamp createTime;

	/**
	 * updateTime
	 */
	private Timestamp updateTime;

	/**
	 * description
	 */
	private String description;

	/**
	 * status
	 */
	private Byte status;

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

	public void setGender(Byte gender){
	this.gender=gender;
	}

	public Byte getGender(){
		return gender;
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

	public void setPassword(String password){
	this.password=password;
	}

	public String getPassword(){
		return password;
	}

	public void setJob(String job){
	this.job=job;
	}

	public String getJob(){
		return job;
	}

	public void setPhoto(String photo){
	this.photo=photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setCreateTime(Timestamp createTime){
	this.createTime=createTime;
	}

	public Timestamp getCreateTime(){
		return createTime;
	}

	public void setUpdateTime(Timestamp updateTime){
	this.updateTime=updateTime;
	}

	public Timestamp getUpdateTime(){
		return updateTime;
	}

	public void setDescription(String description){
	this.description=description;
	}

	public String getDescription(){
		return description;
	}

	public void setStatus(Byte status){
	this.status=status;
	}

	public Byte getStatus(){
		return status;
	}

}