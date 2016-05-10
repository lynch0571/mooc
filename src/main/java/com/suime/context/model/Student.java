package com.suime.context.model;

import java.sql.Timestamp;
import java.io.Serializable;

/**
 * student 实体类 Created by Lynch 09/05/2016.
 */
public class Student implements Serializable {
	/**
	 * id
	 */
	private Integer id;

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
	 * password
	 */
	private String password;

	/**
	 * gender
	 */
	private Byte gender;

	/**
	 * type
	 */
	private String type;

	/**
	 * studyTime
	 */
	private String studyTime;

	/**
	 * integral
	 */
	private Integer integral;

	/**
	 * experience
	 */
	private Integer experience;

	/**
	 * createTime
	 */
	private Timestamp createTime;

	/**
	 * updateTime
	 */
	private Timestamp updateTime;

	/**
	 * status
	 */
	private Byte status;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Byte getGender() {
		return gender;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getStudyTime() {
		return studyTime;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getStatus() {
		return status;
	}

}