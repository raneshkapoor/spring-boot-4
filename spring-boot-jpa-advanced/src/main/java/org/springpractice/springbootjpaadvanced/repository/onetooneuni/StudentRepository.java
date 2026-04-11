package org.springpractice.springbootjpaadvanced.repository.onetooneuni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springpractice.springbootjpaadvanced.entity.onetooneuni.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
