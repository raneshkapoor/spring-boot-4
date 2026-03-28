package org.springpractice.springboothibernatejpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springpractice.springboothibernatejpa.DAO.StudentDAO;
import org.springpractice.springboothibernatejpa.entity.Student;

@SpringBootApplication
public class SpringBootHibernateJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO  studentDAO) {
        return runner -> {
            deleteStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("####### Creating student ...");

        Student student = new Student("John", "Doe", "johndoe@email.com");

        System.out.println("####### Saving student ...");

        studentDAO.save(student);

        System.out.println("####### Saved student ... ID : "  + student.getId());

    }

    private void createStudents(StudentDAO studentDAO) {

        System.out.println("####### Creating students ...");

        Student student1 = new Student("John", "Doe", "johndoe1@email.com");
        Student student2 = new Student("John", "Doe", "johndoe2@email.com");
        Student student3 = new Student("John", "Doe", "johndoe3@email.com");

        System.out.println("####### Saving students ...");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("####### Saved students ... ID : "  + student1.getId());
        System.out.println("####### Saved students ... ID : "  + student2.getId());
        System.out.println("####### Saved students ... ID : "  + student3.getId());

    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("####### Reading student ...");

        Student student = studentDAO.findById(2);

        System.out.println("####### Read student ... : "  + student);
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("####### Reading student ...");

        Student student = studentDAO.findById(2);

        System.out.println("####### Read student ... : "  + student);

        student.setLastName("Does");

        System.out.println("####### Update student ...");

        studentDAO.update(student);

        System.out.println("####### Update student ... : "  + student);
    }

    private  void deleteStudent(StudentDAO studentDAO) {
        System.out.println("####### Deleting student ...");

        studentDAO.delete(2);
    }

}
