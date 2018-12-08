package Jaxp.parse;

public class Student {

	
	
	private String id,examid,name, location;
	
	private double grade;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String toString() {
		
		return "Student name: " + name + "\nStudent id: "+id+"\nStudent exam id: "+examid+
				"\nlocation: "+location+"\nGrade: "+grade;
	}
}
