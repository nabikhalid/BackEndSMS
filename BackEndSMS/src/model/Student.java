package model;

public class Student {

	public String name;
	public final int maxNumberOfCourses = 5;
	// each element (e.g., courses[0], courses [1], ..., [courses.length -1]) in the array stores
	// the address of some CourseRecord object.
	public CourseRecord[] courses;
	// 1. value of noc represents the number of CourseRecord objects stored in the courses array.
	// 2. value of noc denotes where in the array 'courses' is the next CourseRecord object to be stored.
	public int numberOfCourses;
	
	public Student(String name) {
		this.name = name;
		this.courses = new CourseRecord[maxNumberOfCourses];
		this.numberOfCourses = 0; // so far zero courses registered; the next course is to be stored at index 0
	}
	
	// Version 1: Given a CourseRecord to be stores directly into the courses array.
	public void addCourse(CourseRecord c) {
		this.courses[this.numberOfCourses] = c;
		this.numberOfCourses ++;
	}
	
	// Version 2: Given a CourseRecord to be stores directly into the courses array.
	public void addCourse(String title) {
		CourseRecord c = new CourseRecord(title);
		this.addCourse(c);
//		this.courses[this.noc] = c;
//		this.noc ++;
	}
	
	/*
	 * Given the title of course, return the marks of that course.
	 * If the course does not exist, return -1
	 */
	public int getMarks(String title) {
		int marks = 0;
		
		int index = this.indexOf(title);
		if(index >= 0) {
//			CourseRecord c = this.courses[index];
//			marks = c.getMarks();
			marks = this.courses[index].getMarks();
			}
		
		return marks;		
	}
	
	/*
	 * Given the title of course, set the marks of that course. 
	 * If the course does not exist, do nothing. 
	 */
	public void setMarks(String title, int marks) {
		int index = this.indexOf(title);
		if(index >= 0) {
//			CourseRecord c = this.courses[index];
//			marks = c.getMarks();
			this.courses[index].setMarks(marks);			
		}
	}
	
	// Helper method reused by getMarks and setMarks
	// Given the title of course, return the index of the corresponding course
	// If the title does not exist, return -1.
	int indexOf(String title) {
		int index = -1;
		
		boolean found = false;
		for(int i = 0; i < this.numberOfCourses && !found; i++) {
			if(this.courses[i].getTitle().equals(title)) {
				found = true;
				index = i;
			}
		}
		return index;
	}
	
	double getGPA() {
		double gpa = 0.0;
		double gp = 0.0;
		for(int i = 0; i < this.numberOfCourses; i++) {

			String lg = this.courses[i].getLetterGrade();
			if(lg.equals("A+")) {
				gp += 9;
			}
			else if(lg.equals("A")) {
				gp += 8;
			}
			else if(lg.equals("B")) {
				gp += 7;
			}
			else if(lg.equals("C")) {
				gp += 6;
			}
			else if(lg.equals("D")) {
				gp += 5;
			}
			else { // F
				gp += 0;
			}
		}
		
		gpa = gp / this.numberOfCourses;
		
		if(this.numberOfCourses == 0) {
			gpa = 0.0;
		}
		
		return gpa;
	}
	
	public String getDescription() {
		String result = "";
		
		// Version 1: print out the addresses of courses array elements (which might be null)
		
//		result += "Student " + this.name + " has registered " + this.noc + " courses:\n";
//		for(int i = 0; i < this.courses.length; i++) {
//			result += this.courses[i] + "\n";
//		}
		
		// Version 2: print out the description of courses array elements (by calling getDescription from CourseRecord) 
		// This version may cause NullPointerException,
		
//		result += "Student " + this.name + " has registered " + this.noc + " courses:\n";
//		for(int i = 0; i < this.courses.length; i++) {
//			result += this.courses[i].getDescription() + "\n";
//		}
		
		// Version 3
		result += "Student " + this.name + " has registered " + this.numberOfCourses + " courses (with GPA " + this.getGPA() + "):" + "\n";
		for(int i = 0; i < this.numberOfCourses; i++) {
		result += this.courses[i].getDescription() + "\n";
		}
		
		return result;
	}
	public String getName() {
		return this.name; 
	}
	
}
