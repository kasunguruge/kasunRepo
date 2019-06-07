package lk.kasun.librarymanagementsystem.controller;


import lk.kasun.librarymanagementsystem.Service.LibraryService;
import lk.kasun.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/library")
@CrossOrigin
public class LibrarySystemController {


        @Autowired
    LibraryService libraryService;

        @RequestMapping(value = "/getReservations" ,method = RequestMethod.GET)
        public List<Student> getReservations(){
            return libraryService.getReserveDetails();
        }

        @RequestMapping(value = "/saveReservations" ,method = RequestMethod.POST)
         public Student  saveReservations(@RequestBody  Student students){
             return libraryService.saveReservations(students);
         }

        @RequestMapping(value = "/getStudentDetails/{id}/{studentname}" ,method = RequestMethod.PUT)
         public Student updateStudentDetails( @PathVariable  Integer id, @PathVariable  String studentname){
              return libraryService.updateStudentDetails(studentname,id);
        }

        @RequestMapping(value = "/deleteStudentDetails/{id}" ,method = RequestMethod.DELETE)
        public  void deleteItem(@PathVariable Integer id){
            libraryService.deleteItem(id);
        }
}
