package com.suime.context.model;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * course 实体类
 * Created by Lynch 29/04/2016.
 */ 
public class Course implements Serializable {
	/**
	 * id
	 */
	private Integer id;

	/**
	 * name
	 */
	private String name;

	/**
	 * teacherId
	 */
	private Integer teacherId;

	/**
	 * chapterCount
	 */
	private Byte chapterCount;

	/**
	 * sectionCount
	 */
	private Byte sectionCount;

	/**
	 * createTime
	 */
	private Timestamp createTime;

	/**
	 * updateTime
	 */
	private Timestamp updateTime;

	/**
	 * image
	 */
	private Integer image;

	/**
	 * path
	 */
	private Integer path;

	/**
	 * duration
	 */
	private Integer duration;

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

	public void setTeacherId(Integer teacherId){
	this.teacherId=teacherId;
	}

	public Integer getTeacherId(){
		return teacherId;
	}

	public void setChapterCount(Byte chapterCount){
	this.chapterCount=chapterCount;
	}

	public Byte getChapterCount(){
		return chapterCount;
	}

	public void setSectionCount(Byte sectionCount){
	this.sectionCount=sectionCount;
	}

	public Byte getSectionCount(){
		return sectionCount;
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

	public void setImage(Integer image){
	this.image=image;
	}

	public Integer getImage(){
		return image;
	}

	public void setPath(Integer path){
	this.path=path;
	}

	public Integer getPath(){
		return path;
	}

	public void setDuration(Integer duration){
	this.duration=duration;
	}

	public Integer getDuration(){
		return duration;
	}

	public void setStatus(Byte status){
	this.status=status;
	}

	public Byte getStatus(){
		return status;
	}

}