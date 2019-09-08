package model;

public class StudentManagementSystem {

	public int numberOfStudents = 0;
	
	public static int maxNumberOfStudents = 100;
	
	public Student[] tempStudentArray = new Student[maxNumberOfStudents];
	
	public Student[] studentArray = new Student [numberOfStudents];

	public StudentManagementSystem() {



	}

	public String getDescription() {
		String result = "";

		if (this.numberOfStudents == 0) {
			result += "Student management system currenlty stores no students." + "\n";
		}
		else {

			for (int i = 0; i < this.numberOfStudents; i++) {
				result += tempStudentArray[i].getDescription();
			}
		}
		return result;
	}

	public Student[] getStudents() {
		return this.studentArray;
	}


	public void addStudent(String name) {
		Student s = new Student (name);
		
		this.tempStudentArray[numberOfStudents] = s;
		
		this.numberOfStudents ++;
		
		this.studentArray = new Student[numberOfStudents];
		
		for(int i = 0;i<studentArray.length;i++) {
			
			this.studentArray[i] = this.tempStudentArray[i];
			
		}

	}

	public void addStudent(Student student) {

		this.tempStudentArray[numberOfStudents] = student;

		this.numberOfStudents ++;

		this.studentArray = new Student[numberOfStudents];

		for(int i = 0;i<studentArray.length;i++) {

			this.studentArray[i] = this.tempStudentArray[i];
		}

	}

	public double getGPA(String name) {

		double gpa = 0.0;

		boolean check = false;

		for(int i = 0; i < this.numberOfStudents && !check; i++) {

			if (this.studentArray[i].getName().equals(name)) {

				check = true;

				gpa = this.studentArray[i].getGPA();
			}
		}
		return gpa;
	}

	public int getMarks(String name, String course) {
		int marks = -1;


		boolean check = false;
		for(int i = 0; i < this.numberOfStudents && !check; i++) {
			if (this.studentArray[i].getName().equals(name)) {


				check = true;


				marks = this.studentArray[i].getMarks(course);
			}
		}
		return marks;
	}

	public void setMarks(String name, String course, int mark) {
		boolean verify = false;
		for(int i = 0; i < this.numberOfStudents && !verify; i++) {
			if (this.studentArray[i].getName().equals(name)) {
				verify = true;
				
				
				this.studentArray[i].setMarks(course, mark);
			}
		}

	}

	public void addCourse(String name, CourseRecord course) {
		boolean verify = false;
		
		
		
		
		
		for(int i = 0; i < this.numberOfStudents && !verify; i++) {
			if (this.studentArray[i].getName().equals(name)) {
				verify = true;
				
				
				this.studentArray[i].addCourse(course);

			}


		}


	}

}
