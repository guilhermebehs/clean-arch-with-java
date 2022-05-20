package br.com.guilhermebehs.school.domain.student;

import java.util.List;

public interface StudentRepository {

    void enroll(Student student);
    Student findByCpf(Cpf cpf);
    List<Student> listAllEnrolledStudents();
}
