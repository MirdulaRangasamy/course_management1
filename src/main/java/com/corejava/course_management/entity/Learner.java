package com.corejava.course_management.entity;

public class Learner {
	private String enrollmentNo;
	private String learnerName;
	private String learnerMobile;
	private String learnerEMail;
	private String learnerAddress;
	private String courseName;
	
	private float completedCourseDuration;
	private boolean certified;
	public Learner(String learnerName, String learnerAddress,String learnerMobile, String learnerEMail) {
		super();
		this.learnerName = learnerName;
		this.learnerAddress = learnerAddress;
		this.learnerMobile = learnerMobile;
		this.learnerEMail = learnerEMail;
	}
	public String getEnrollmentNo() {
		return enrollmentNo;
	}
	
	public String getLearnerName() {
		return learnerName;
	}
	public void setLearnerName(String learnerName) {
		this.learnerName = learnerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getLearnerAddress() {
		return learnerAddress;
	}
	public void setLearnerAddress(String learnerAddress) {
		this.learnerAddress = learnerAddress;
	}
	
	public float getCompletedCourseDuration() {
		return completedCourseDuration;
	}
	public void setCompletedCourseDuration(float durationSpent) {
		this.completedCourseDuration = completedCourseDuration + durationSpent;
	}
	
	public String getLearnerMobile() {
		return learnerMobile;
	}
	public void setLearnerMobile(String learnerMobile) {
		this.learnerMobile = learnerMobile;
	}
	public String getLearnerEMail() {
		return learnerEMail;
	}
	public void setLearnerEMail(String learnerEMail) {
		this.learnerEMail = learnerEMail;
	}
	public void markCertified()
	{
		certified = true;
	}
	public boolean isCertified() {
		return certified;
	}
	
	public void displayCourseDetails()
	{
		System.out.println("Enrolled Course"+courseName);
		System.out.println("Enrollment Number: "+enrollmentNo);
		System.out.println("Completed Hours: "+completedCourseDuration);
		if(certified)
			System.out.println("Got Certified");
	}
	
	public void enroll(Course c)
	{
		c.setNoOfLearners(c.getNoOfLearners()+1);
		this.courseName = c.getCourseName();
		this.enrollmentNo = c.generateEnrollmentNumber();
		
	}
	public void displayPersonalDetails()
	{
		System.out.println("Learner Name: "+learnerName);
		System.out.println("Learner Address: "+learnerAddress);
		System.out.println("Learner Mobile: "+learnerMobile);
		System.out.println("Learner E-Mail: "+learnerEMail);
	}
	@Override
	public String toString() {
		return "Learner [enrollmentNo=" + enrollmentNo + ", learnerName=" + learnerName + ", learnerMobile="
				+ learnerMobile + ", learnerEMail=" + learnerEMail + ", learnerAddress=" + learnerAddress
				+ ", courseName=" + courseName + ", completedCourseDuration="
				+ completedCourseDuration + ", certified=" + certified + "]";
	}
	
}
