package com.ajas.jasper.model;

public class Subject {
	private String subjectName;
	private long marksObtained;
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public long getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(long marksObtained) {
		this.marksObtained = marksObtained;
	}
	public Subject(String subjectName, long marksObtained) {
		super();
		this.subjectName = subjectName;
		this.marksObtained = marksObtained;
	}
	public Subject() {
		super();
	}
	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", marksObtained=" + marksObtained + "]";
	}
	
	

}
