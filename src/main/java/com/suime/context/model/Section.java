package com.suime.context.model;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * section 实体类
 * Created by Lynch 29/04/2016.
 */ 
public class Section implements Serializable {
	/**
	 * id
	 */
	private Integer id;

	/**
	 * name
	 */
	private String name;

	/**
	 * chapterId
	 */
	private Integer chapterId;

	/**
	 * duration
	 */
	private Integer duration;

	/**
	 * type
	 */
	private Byte type;

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

	public void setChapterId(Integer chapterId){
	this.chapterId=chapterId;
	}

	public Integer getChapterId(){
		return chapterId;
	}

	public void setDuration(Integer duration){
	this.duration=duration;
	}

	public Integer getDuration(){
		return duration;
	}

	public void setType(Byte type){
	this.type=type;
	}

	public Byte getType(){
		return type;
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