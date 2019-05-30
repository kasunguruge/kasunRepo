package lk.pasindu.sms;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lk.pasindu.sms.modal.Student;
import lk.pasindu.sms.service.StudentService;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService service = (StudentService) context.getBean("studentService");
		List<Student> students = service.fetchAllStudents();

		for (Student student : students) {
			System.out.println(student.getId() + " " + student.getName());
		}
	}

}
