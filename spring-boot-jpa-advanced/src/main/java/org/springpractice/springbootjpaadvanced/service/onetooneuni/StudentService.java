package org.springpractice.springbootjpaadvanced.service.onetooneuni;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springpractice.springbootjpaadvanced.entity.onetooneuni.Laptop;
import org.springpractice.springbootjpaadvanced.entity.onetooneuni.Student;
import org.springpractice.springbootjpaadvanced.repository.onetooneuni.LaptopRepository;
import org.springpractice.springbootjpaadvanced.repository.onetooneuni.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final LaptopRepository laptopRepository;

    private final StudentRepository studentRepository;

    public StudentService(LaptopRepository laptopRepository, StudentRepository studentRepository) {
        this.laptopRepository = laptopRepository;
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void init() {

        System.out.println("One to One Uni Directional Mapping");

        System.out.println("Deleting all Data.");

        studentRepository.deleteAll();
        laptopRepository.deleteAll();

        System.out.println("Saving Data.");

        Laptop laptop1 = new Laptop(123, "ABC", "Dell");
        Laptop laptop2 = new Laptop(124, "ABD", "Dell");
        Laptop laptop3 = new Laptop(125, "ABE", "Dell");
        Laptop laptop4 = new Laptop(126, "ABF", "HP");

        Student student1 = new Student(101, "John", "Student", laptop1);
        Student student2 = new Student(102, "Mark", "Student", laptop4);

        laptopRepository.saveAll(List.of(laptop1, laptop2, laptop3, laptop4));
        studentRepository.saveAll(List.of(student1, student2));

        System.out.println("Saved Data.");
        System.out.println("Loading Data.");

        Optional<Student> student = studentRepository.findById(101);
        student.ifPresent(s -> System.out.println(s.getLaptop().getBrand()));

    }

}
