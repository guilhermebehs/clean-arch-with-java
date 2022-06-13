package br.com.guilhermebehs.school.academic.infra.student;

import br.com.guilhermebehs.school.shared.domain.Cpf;
import br.com.guilhermebehs.school.academic.domain.student.Student;
import br.com.guilhermebehs.school.academic.domain.student.StudentNotFoundException;
import br.com.guilhermebehs.school.academic.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentRepository implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        students.add(student);
    }

    @Override
    public Student findByCpf(Cpf cpf) {
        return students.stream()
                .filter(student -> student.getCpf().getNumber().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(()-> new StudentNotFoundException(cpf));
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return students;
    }
}
