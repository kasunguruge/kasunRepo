package lk.pasindu.sms.repository;

import java.util.List;

import lk.pasindu.sms.modal.Student;

public interface StudentRepository {

	List<Student> fetchAllStudents();

}