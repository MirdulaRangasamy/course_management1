package com.corejava.course_management;

import com.corejava.course_management.service.*;
import java.util.Scanner;
import com.corejava.course_management.entity.*;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Welcome to Course Management System");
		System.out.println();
		System.out.println("What you are looking for?");
		System.out.println("1. Course Management\n2. Learner Management");
		System.out.println();
		System.out.println("Give your choice:");
		int choice = ip.nextInt();
		char ch;
		while(choice == 1 || choice == 2)
		{
		switch (choice) {
		case 1:
			ch = 'C';
			while (ch == 'C') {
				System.out.println("\nCourse Management");
				System.out.println("*****************");
				System.out.println();
				System.out.println("1.Add a Course\n2.View a Course\n3.View All Course");
				System.out.println("4.Update a Course\n5.Delete a Course\n6.Certify Learner\n7.Exit");

				System.out.println("\nEnter your option: ");
				int option = ip.nextInt();

				CourseService cservice = new CourseService();
				int cid;
				String cname;
				float credits, cduration, cost;
				switch (option) {
				case 1:
					System.out.println("Add a Course:");
					System.out.println();
					System.out.println("Enter the Course Id: ");
					cid = ip.nextInt();
					System.out.println("Enter the Course Name: ");
					cname = ip.next();
					System.out.println("Enter the Course Credit points: ");
					credits = ip.nextFloat();
					System.out.println("Enter the Course Duration: ");
					cduration = ip.nextFloat();
					System.out.println("Enter the Course Cost: ");
					cost = ip.nextFloat();
					System.out.println(cservice.addCourse(cid, cname, credits, cduration, cost));
					System.out.println();
					break;
				case 2:
					System.out.println("View a Course\n");
					System.out.println("Enter the Course Id: ");
					cid = ip.nextInt();
					System.out.println(cservice.getCourse(cid));
					break;
				case 3:
					System.out.println("View all Course\n");
					for (Course c : cservice.getAllCourses()) {
						System.out.println(c);
					}

					break;
				case 4:
					System.out.println("Update a Course:");
					System.out.println();
					System.out.println("Enter the Course Id: ");
					cid = ip.nextInt();
					System.out.println("Enter the Course Name: ");
					cname = ip.next();
					System.out.println("Enter the Course Credit points: ");
					credits = ip.nextFloat();
					System.out.println("Enter the Course Duration: ");
					cduration = ip.nextFloat();
					System.out.println("Enter the Course Cost: ");
					cost = ip.nextFloat();
					System.out.println(cservice.updateCourse(cid, cname, credits, cduration, cost));
					System.out.println();
					break;
				case 5:
					System.out.println(" Delete a Course\n");
					System.out.println("Enter the Course Id: ");
					cid = ip.nextInt();
					System.out.println(cservice.deleteCourse(cid));
					break;
				case 6:
					System.out.println("Certify a Learner\n");
					System.out.println("Enter the Enrollment Number of a Learner: ");
					String enrollmentNo = ip.next();
					System.out.println("Enter the Course Id: ");
					cid = ip.nextInt();
					cservice.certifyLearner(enrollmentNo, cid);
					break;
				default:
					break;
				}
				System.out.println("\nWant to continue in Course Management Press C");
				ch = ip.next().charAt(0);
			}
			break;

		case 2:
			ch = 'L';
			while (ch == 'L') {
				System.out.println("\nLearner Management");
				System.out.println("*****************");
				System.out.println();
				System.out.println("1.Add a Learner\n2.View a Learner\n3.View All Learners");
				System.out.println("4.Update a Learner\n5.Delete a Learner\n6.Enroll a Learner");
				System.out.println("7.Update Hours\n8.Exit");
				System.out.println("\nEnter your option: ");
				int option = ip.nextInt();

				LearnerService lService = new LearnerService();
				String lName, lAddr, lMobile, lEmail;
				switch (option) {
				case 1:
					System.out.println("Add a Learner:");
					System.out.println("Enter the Learner Name: ");
					lName = ip.next();
					System.out.println("Enter the Learner Address: ");
					lAddr = ip.next();
					System.out.println("Enter the Learner Mobile (ID value):");
					lMobile = ip.next();
					System.out.println("Enter the Learner E-Mail:");
					lEmail = ip.next();
					System.out.println(lService.addLearner(lName, lAddr, lMobile, lEmail));
					break;
				case 2:
					System.out.println("view a learner");
					System.out.println("Enter the Learner Mobile (ID value):");
					lMobile = ip.next();
					System.out.println(lService.getLearner(lMobile));
					break;
				case 3:
					System.out.println("view all learners");
					for (Learner l : lService.getAllLearners()) {
						l.displayPersonalDetails();
						l.displayCourseDetails();
					}
					break;
				case 4:
					System.out.println("Update a Learner:");
					System.out.println("Enter the Learner Mobile (ID value):");
					lMobile = ip.next();
					System.out.println("Enter the Learner Name: ");
					lName = ip.next();
					System.out.println("Enter the Learner Address: ");
					lAddr = ip.next();

					System.out.println("Enter the Learner E-Mail:");
					lEmail = ip.next();
					System.out.println(lService.updateLearner(lMobile, lName, lAddr, lEmail));
					break;
				case 5:
					System.out.println("Delete a Learner");
					System.out.println("Enter the Learner Mobile (ID value):");
					lMobile = ip.next();
					System.out.println(lService.deleteLearner(lMobile));
					break;
				case 6:
					System.out.println("Enroll in a  course");
					System.out.println("Enter your mobile number");
					lMobile = ip.next();
					System.out.println("Enter your courseId");
					int cid = ip.nextInt();
					System.out.println(lService.enrollLearner(lMobile, cid));
					break;
				case 7:
					System.out.println("Update Learning Hours");
					System.out.println("Enter your enrollment number: ");
					String enrollmentNo = ip.next();
					System.out.println("Enter the numbe rof hours spent:");
					float hr = ip.nextFloat();
					System.out.println(lService.updateLearningHours(hr, enrollmentNo));
					break;
				default:
					break;
				}
				System.out.println("\nWant to continue in Learner Management Press L");
				ch = ip.next().charAt(0);
			}
			break;
		default:
			break;
		}
		System.out.println("1. Course Management\n2. Learner Management");
		System.out.println();
		System.out.println("Give your choice:");
		choice = ip.nextInt();
		}
	}
}
