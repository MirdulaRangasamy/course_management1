package com.corejava.course_management.service;

import java.util.ArrayList;

import com.corejava.course_management.entity.Course;
import com.corejava.course_management.entity.Learner;

public class CourseService {
	private static ArrayList<Course> courseList = new ArrayList<Course>();

	public static ArrayList<Course> getAllCourses() {
		return courseList;
	}

	public String addCourse(int cid, String cname, float credits, float cduration, float cost) {
		courseList.add(new Course(cid, cname, credits, cduration, cost));
		return "Course added successfully...";
	}

	public Course getCourse(int cid) {
		for (Course c : courseList) {
			if (c.getCourseId() == cid) {
				return c;
			}
		}
		return null;
	}

	public String updateCourse(int cid, String cname, float credits, float cduration, float cost) {
		Course c = getCourse(cid);
		c.setCourseName(cname);
		c.setCourseCredit(credits);
		c.setCourseCost(cost);
		c.setCourseDuration(cduration);
		return "Course Updated Successfully";
	}

	public String deleteCourse(int cid) {
		courseList.remove(getCourse(cid));
		return "Course Deleted Successfully";
	}

	public String certifyLearner(String enrollmentno, int cid) {
		Course c = getCourse(cid);
		for (Learner l : LearnerService.getAllLearners()) {
			if (l.getEnrollmentNo().equalsIgnoreCase(enrollmentno)) {
				if (c.getCourseDuration() >= l.getCompletedCourseDuration()) {
					l.markCertified();
					break;
				}
			}
		}
		return "Certified Successfully";
	}
}
