package lk.pasindu.sms.repository;

import java.util.ArrayList;
import java.util.List;

import lk.pasindu.sms.modal.Student;

public class HibernateStudentRepository implements StudentRepository {
	
	
	@Override
	public List<Student> fetchAllStudents(){
		List<Student> students = new ArrayList<>();
		 Student student = new Student();
		 student.setId(1);
		 student.setName("pasindu");
		 students.add(student);
		 return students;
	}

}
