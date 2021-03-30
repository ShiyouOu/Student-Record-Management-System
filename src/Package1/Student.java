package Package1;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	public String studentNumber;
	public String studentName;
	public String major;
	public String address;
	public String phoneNumber;
	public String dob;
	public ArrayList<Course> courses = new ArrayList<Course>();
    
    public Student(String name, String id, String add, String date, String phone, String maj) {
   	 studentNumber = id;
   	 studentName = name;
   	 address = add;
   	 dob = date;
   	 phoneNumber = phone;
   	 major = maj;
    }
    
    public float calculateAverage() {
   	 float avg;
   	 float total = 0;
   	 for (int i = 0; i < courses.size(); i++) {
   		 total = total + Integer.parseInt(courses.get(i).courseGrade);
   	 }
   	 avg = total / courses.size();
   	 return avg;
    }
    
    public double calculateGPA() {
   	 double[] gpaScores = new double[courses.size()];
   	 double gpa = 0;
   	 for (int i=0; i < courses.size(); i++) {
   		 if (Integer.parseInt(courses.get(i).courseGrade) >= 93) {
   			 gpaScores[i] = 4;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 90) {
   			 gpaScores[i] = 3.7;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 87) {
   			 gpaScores[i] = 3.3;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 83) {
   			 gpaScores[i] = 3.0;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 80) {
   			 gpaScores[i] = 2.7;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 77) {
   			 gpaScores[i] = 2.3;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 73) {
   			 gpaScores[i] = 2.0;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 70) {
   			 gpaScores[i] = 1.7;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 67) {
   			 gpaScores[i] = 1.3;
   		 }else if (Integer.parseInt(courses.get(i).courseGrade) >= 65) {
   			 gpaScores[i] = 1.0;
   		 }else {
   			 gpaScores[i] = 0;
   		 }
   		 gpa = gpa + gpaScores[i];
   	 }
   	 gpa = gpa/courses.size();
   	 return gpa;
    }
    
    public void addCourse(String name, String number, String grade, String location, String time) {
    	courses.add(new Course(name, number, grade, location, time));
    }

    public String toString() {
   	 return "\nName: " + studentName + "\nStudent ID: " + studentNumber + "\nAddress: " + address + "\nDOB: " + dob + "\nPhone Number: " + phoneNumber + "\nMajor: " + major + "\n";
    }
}
