package lk.pasindu.sms.service;

import java.util.List;

import lk.pasindu.sms.modal.Student;
import lk.pasindu.sms.repository.HibernateStudentRepository;
import lk.pasindu.sms.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {
	
	StudentRepository repository;
	
	

//	public StudentServiceImpl(StudentRepository repository) {
//		super();
//		this.repository = repository;
//	}



	public StudentRepository getRepository() {
		return repository;
	}



	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}



	@Override
	public List<Student> fetchAllStudents() {
		return repository.fetchAllStudents();
	}
}
