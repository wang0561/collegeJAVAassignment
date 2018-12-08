package Jaxp.parse;

import java.util.Scanner;
import static java.lang.System.*;

public class StudentCRUD {

	static String[] options = { "1.add a new student.", "2.find a student.", "3.delete a student.", "4.Exit" };
	static String welcome = "Welcome to Student exam management system.";
	static String bye = "Thank you, see you!";
	static Scanner input = new Scanner(System.in);
	private Student student;
	static StudentDAO dao = new StudentDAO();
	static int choice;

	public void prompt() {

		out.println(welcome);
		do {
			for (String option : options)
				out.println(option);
			choice = getOption();

			switch (choice) {

			case 1:
				addStudent();
				break;
			case 2:
				findStudent();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				break;
			}
		} while (choice != 4);
		out.println(bye);
	}

	private void deleteStudent() {
		// TODO Auto-generated method stub
		dao.delete(getStudentName());

	}

	private String getStudentName() {
		// TODO Auto-generated method stub
		out.println("Enter the name of the student you want to delete: ");
		return input.next();
	}

	private void findStudent() {
		// TODO Auto-generated method stub
		student = dao.find(getExamID());
		out.println("Found Result: " + student);
	}

	private String getExamID() {
		// TODO Auto-generated method stub
		out.println("Enter the exam id of the student you want to find: ");
		return input.next();
	}

	private void addStudent() {
		// TODO Auto-generated method stub
		student = getNewStudent();
		dao.add(student);

	}

	private Student getNewStudent() {
		// TODO Auto-generated method stub
		out.println("Enter the information for the new student");
		Student student = new Student();
		out.println("name: ");
		student.setName(input.next());
		out.println("id: ");
		student.setId(input.next());
		out.println("exam id: ");
		student.setExamid(input.next());
		out.println("location: ");
		student.setLocation(input.next());
		out.println("grade");
		student.setGrade(getGradecheck());
		return student;
	}

	private double getGradecheck() {
		// TODO Auto-generated method stub
		double grade = 0 ; 
		while (true) {
			try {
				grade = input.nextDouble();
				break;
			}catch(Exception e) {
				continue;
			}
		}
		return grade;
	}

	private int getOption() {
		int op = 0 ; 
		while (true) {
			try {
				op = input.nextInt();
				break;
			}catch(Exception e) {
				continue;
			}
		}
		return op;
	}
}
