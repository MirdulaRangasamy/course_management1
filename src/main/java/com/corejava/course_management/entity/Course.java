package com.corejava.course_management.entity;

public class Course {
	private int courseId;
	private String courseName;
	private float courseCredit;
	private float courseDuration;
	private float courseCost;
	private int noOfLearners ;
	
	
	public Course(int courseId, String courseName, float courseCredit, float courseDuration, float courseCost) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseDuration = courseDuration;
		this.courseCost = courseCost;
		noOfLearners = 0;
		
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public float getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(float courseCredit) {
		this.courseCredit = courseCredit;
	}
	public float getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(float courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	public float getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(float courseCost) {
		this.courseCost = courseCost;
	}
	
	public int getNoOfLearners() {
		return noOfLearners;
	}
	public void setNoOfLearners(int noOfLearners) {
		this.noOfLearners = noOfLearners;
	}
	public void provideCertificate(Learner l)
	{
		l.markCertified();
	}
	public String generateEnrollmentNumber()
	{
		return courseId + "" + noOfLearners;
	}
	public String toString()
	{
		return courseId+" "+courseName+" "+courseCredit+" "+courseDuration+" "+courseCost+" "+noOfLearners;
	}
}
