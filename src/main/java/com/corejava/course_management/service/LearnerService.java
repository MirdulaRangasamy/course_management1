package com.corejava.course_management.service;

import java.util.ArrayList;

import com.corejava.course_management.entity.Course;
import com.corejava.course_management.entity.Learner;

public class LearnerService {
	private static ArrayList<Learner> learnerList = new ArrayList<Learner>();

	public String addLearner(String lname, String laddr, String lmobile, String lemail) {
		Learner l = new Learner(lname, laddr, lmobile, lemail);
		learnerList.add(l);
		return "Learner Added Successfully";
	}

	public String enrollLearner(String mobile, int courseId) {
		ArrayList<Course> courseList = CourseService.getAllCourses();
		Learner l = getLearner(mobile);
		for (Course c : courseList) {
			if (c.getCourseId() == courseId) {
				l.enroll(c);
			}
		}
		return "Learner got enrolled successfully..";
	}

	public Learner getLearner(String mobile) {
		for (Learner l : learnerList) {
			if (l.getLearnerMobile().equals(mobile)) {
				return l;
			}
		}
		return null;
	}

	public static ArrayList<Learner> getAllLearners() {
		return learnerList;
	}

	public String updateLearner(String mobile, String name, String addr, String email) {
		Learner l1 = getLearner(mobile);
		l1.setLearnerAddress(addr);
		l1.setLearnerEMail(email);
		l1.setLearnerName(name);
		return "Learner details got updated successfully...";
	}

	public String deleteLearner(String mobile) {
		Learner l = getLearner(mobile);
		for(Course c:CourseService.getAllCourses())
		{
			if(c.getCourseName().equalsIgnoreCase(l.getCourseName()))
			{
				c.setNoOfLearners(c.getNoOfLearners()-1);
			}
		}
		learnerList.remove(l);
		return "Learner data removed successfully...";
	}
	
	public String updateLearningHours(float hrs, String enrollmentNo)
	{
		for(Learner l:getAllLearners())
		{
			if(l.getEnrollmentNo().equalsIgnoreCase(enrollmentNo))
			{
				l.setCompletedCourseDuration(l.getCompletedCourseDuration()+hrs);
				break;
			}
		}
		return "Hours updated successfully...";
	}
}
