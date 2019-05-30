package com.hcl.test.dao;

import java.util.Date;

public class EventDto {

	private String eventId;
	private String siteName;
	private String cameraName;
	private String cameraId;
	private String project;
	private Date eventTime;
	private String terminatedLevel;
	private String eventTag;
	private String action;
	private String eventDuration;
	public EventDto(String eventId, String siteName, String cameraName,String cameraId, String project, Date eventTime,
			String terminatedLevel, String eventTag, String action, String eventDuration) {
		super();
		this.eventId = eventId;
		this.siteName = siteName;
		this.cameraName = cameraName;
		this.cameraId=cameraId;
		this.project = project;
		this.eventTime = eventTime;
		this.terminatedLevel = terminatedLevel;
		this.eventTag = eventTag;
		this.action = action;
		this.eventDuration = eventDuration;
	}
	
	public EventDto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public String getTerminatedLevel() {
		return terminatedLevel;
	}
	public void setTerminatedLevel(String terminatedLevel) {
		this.terminatedLevel = terminatedLevel;
	}
	public String getEventTag() {
		return eventTag;
	}
	public void setEventTag(String eventTag) {
		this.eventTag = eventTag;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(String eventDuration) {
		this.eventDuration = eventDuration;
	}

	public String getCameraId() {
		return cameraId;
	}

	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}

}
