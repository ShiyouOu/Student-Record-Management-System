package Package1;

import java.io.Serializable;

public class Course implements Serializable{
    public String courseName;
    public String courseNumber;
	public String courseGrade;
	public String courseLocation;
	public String courseTime;
	
	public Course(String name, String number, String location, String time) {
	    courseName = name;
	    courseNumber = number;
	    courseLocation = location;
	    courseTime = time;
    }
    
    public Course(String name, String number, String grade, String location, String time) {
	    courseName = name;
	    courseNumber = number;
	    courseGrade = grade;
	    courseLocation = location;
	    courseTime = time;
    }
}
