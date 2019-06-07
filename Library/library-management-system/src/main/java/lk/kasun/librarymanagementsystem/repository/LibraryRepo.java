package lk.kasun.librarymanagementsystem.repository;

import lk.kasun.librarymanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Student,Integer> {


}
