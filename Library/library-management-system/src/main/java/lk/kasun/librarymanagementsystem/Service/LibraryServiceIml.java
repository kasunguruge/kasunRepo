package lk.kasun.librarymanagementsystem.Service;

import lk.kasun.librarymanagementsystem.model.Student;
import lk.kasun.librarymanagementsystem.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceIml implements LibraryService {

    @Autowired
    LibraryRepo libraryRepo;

    @Override
    public List<Student> getReserveDetails(){
        return libraryRepo.findAll();
    }

    @Override
    public Student saveReservations(Student students) {
        return libraryRepo.save(students);
    }

    @Override
    public Student updateStudentDetails( String studentname, Integer id){
        Student student=new Student();
        if(student.getId()!=null){
            if(student.getId()==id){
                student.setName(studentname);
            }
        }
        else return null;

        return libraryRepo.save(student);
    }
    @Override
    public void deleteItem(Integer id){

               libraryRepo.deleteById(id);

       

    }
}
