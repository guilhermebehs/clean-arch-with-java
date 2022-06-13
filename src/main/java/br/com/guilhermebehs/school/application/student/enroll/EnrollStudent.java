package br.com.guilhermebehs.school.application.student.enroll;

import br.com.guilhermebehs.school.domain.EventListener;
import br.com.guilhermebehs.school.domain.EventPublisher;
import br.com.guilhermebehs.school.domain.student.StudentHasBeenEnrolledEvent;
import br.com.guilhermebehs.school.domain.student.StudentRepository;

public class EnrollStudent {

    private final StudentRepository studentRepository;
    private final EventPublisher eventPublisher;

    public EnrollStudent(StudentRepository studentRepository, EventPublisher eventPublisher) {
        this.studentRepository = studentRepository;
        this.eventPublisher = eventPublisher;
    }

    public void execute(EnrollStudentDto enrollStudentDto){
        var newStudent = enrollStudentDto.toStudent();
        studentRepository.enroll(newStudent);
        eventPublisher.publish(new StudentHasBeenEnrolledEvent(newStudent.getCpf()));
    }
}
