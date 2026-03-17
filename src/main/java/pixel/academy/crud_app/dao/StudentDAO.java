package pixel.academy.crud_app.dao;

import pixel.academy.crud_app.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findById(Integer id);
    List<Student> findAll ();
}

