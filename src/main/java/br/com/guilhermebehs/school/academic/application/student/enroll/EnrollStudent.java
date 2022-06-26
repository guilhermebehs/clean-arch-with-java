package br.com.guilhermebehs.school.academic.application.student.enroll;

import br.com.guilhermebehs.school.shared.domain.event.EventPublisher;
import br.com.guilhermebehs.school.academic.domain.student.StudentHasBeenEnrolledEvent;
import br.com.guilhermebehs.school.academic.domain.student.StudentRepository;

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
