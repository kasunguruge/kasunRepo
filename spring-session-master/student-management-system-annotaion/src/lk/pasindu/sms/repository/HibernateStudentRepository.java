package lk.pasindu.sms.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lk.pasindu.sms.modal.Student;

@Repository
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
