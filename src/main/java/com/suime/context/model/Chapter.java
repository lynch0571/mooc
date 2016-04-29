package com.suime.context.model;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * chapter 实体类
 * Created by Lynch 29/04/2016.
 */ 
public class Chapter implements Serializable {
	/**
	 * id
	 */
	private Integer id;

	/**
	 * name
	 */
	private String name;

	/**
	 * courseId
	 */
	private Integer courseId;

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

	public void setCourseId(Integer courseId){
	this.courseId=courseId;
	}

	public Integer getCourseId(){
		return courseId;
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

	public void setStatus(Byte status){
	this.status=status;
	}

	public Byte getStatus(){
		return status;
	}

}