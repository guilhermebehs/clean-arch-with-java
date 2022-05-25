package br.com.guilhermebehs.school.application.student.enroll;

import br.com.guilhermebehs.school.domain.student.StudentRepository;

public class EnrollStudent {

    private final StudentRepository studentRepository;

    public EnrollStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(EnrollStudentDto enrollStudentDto){
        var newStudent = enrollStudentDto.toStudent();
        studentRepository.enroll(newStudent);
    }
}
