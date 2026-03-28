package org.springpractice.springboothibernatejpa.DAO;

import org.springpractice.springboothibernatejpa.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    void update(Student student);

    void delete(Integer id);

}
