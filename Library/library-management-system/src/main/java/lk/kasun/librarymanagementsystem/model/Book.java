package lk.kasun.librarymanagementsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {


    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToOne
    @JsonIgnore
    Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
