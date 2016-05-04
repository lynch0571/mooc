package com.suime.context.model;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * course 实体类
 * Created by Lynch 05/05/2016.
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
	private Integer sectionCount;

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
	private String image;

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

	/**
	 * studentCount
	 */
	private Integer studentCount;

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

	public void setSectionCount(Integer sectionCount){
	this.sectionCount=sectionCount;
	}

	public Integer getSectionCount(){
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

	public void setImage(String image){
	this.image=image;
	}

	public String getImage(){
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

	public void setStudentCount(Integer studentCount){
	this.studentCount=studentCount;
	}

	public Integer getStudentCount(){
		return studentCount;
	}

}