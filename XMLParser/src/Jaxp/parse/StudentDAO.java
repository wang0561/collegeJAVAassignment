package Jaxp.parse;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentDAO {

	static String path = "exam.xml";

	public void add(Student student) {
		try {
			Document document = XMLUtils.getDocument(path);
			// create student tag
			Element student_tag = document.createElement("student");

			// add attributes for student tag
			student_tag.setAttribute("idcard", student.getId());
			student_tag.setAttribute("examid", student.getExamid());

			// create sub-tags of student
			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");

			// set content for sub-tags
			name.setTextContent(student.getName());
			location.setTextContent(student.getLocation());
			grade.setTextContent(student.getGrade() + "");

			// append sub-tags to student tag
			student_tag.appendChild(name);
			student_tag.appendChild(location);
			student_tag.appendChild(grade);

			// append student tag to exam tag
			document.getElementsByTagName("exam").item(0).appendChild(student_tag);

			XMLUtils.writeToXML(document, path);
			System.out.println(student.getName()+" was added successful.");

		} catch (SAXException | IOException | ParserConfigurationException | TransformerFactoryConfigurationError
				| TransformerException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	public Student find(String examid) {

		try {
			Document document = XMLUtils.getDocument(path);
			NodeList list = document.getElementsByTagName("student");
			for (int i = 0; i < list.getLength(); i++) {

				Element student_tag = (Element) list.item(i);
				if (student_tag.getAttribute("examid").equals(examid)) {
					Student student = new Student();
					student.setExamid(examid);
					student.setId(student_tag.getAttribute("idcard"));
					student.setName(student_tag.getElementsByTagName("name").item(0).getTextContent());
					student.setLocation(student_tag.getElementsByTagName("location").item(0).getTextContent());
					student.setGrade(
							Double.parseDouble(student_tag.getElementsByTagName("grade").item(0).getTextContent()));
					//System.out.println("Result:\n"+student);
					return student;
				}
			}
			
			throw new StudentNotExistException("student with the examid "+examid+" not exist!!");

		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);

		} catch (StudentNotExistException e) {
			// TODO Auto-generated catch block
			
		}

		return null;
	}

	public void delete(String name) {

		try {
			
			Document document = XMLUtils.getDocument(path);
			NodeList list = document.getElementsByTagName("name");
			
			for (int i = 0; i < list.getLength(); i++) {
				if(list.item(i).getTextContent().equals(name)) {
					//from name tag get the exam tag to delete the student tag.
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					XMLUtils.writeToXML(document, path);
					System.out.println(name+" was deleted successful.");
					return ;
				}
			}
			throw new StudentNotExistException("Student "+name +" not exists!");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
