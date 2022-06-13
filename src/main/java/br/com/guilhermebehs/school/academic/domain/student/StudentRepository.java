package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.shared.domain.Cpf;

import java.util.List;

public interface StudentRepository {

    void enroll(Student student);
    Student findByCpf(Cpf cpf);
    List<Student> listAllEnrolledStudents();
}
