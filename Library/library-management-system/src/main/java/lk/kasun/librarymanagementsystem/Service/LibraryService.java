package lk.kasun.librarymanagementsystem.Service;

import lk.kasun.librarymanagementsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    List<Student> getReserveDetails();
    Student saveReservations(Student students);
    Student updateStudentDetails( String studentname, Integer id);
    void deleteItem(Integer id);
}
