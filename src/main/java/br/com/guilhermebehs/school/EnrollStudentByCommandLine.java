package br.com.guilhermebehs.school;

import br.com.guilhermebehs.school.gamification.application.GenerateTrophyToNewStudent;
import br.com.guilhermebehs.school.gamification.infra.trophy.InMemoryTrophyRepository;
import br.com.guilhermebehs.school.shared.domain.event.EventPublisher;
import br.com.guilhermebehs.school.academic.application.student.enroll.EnrollStudent;
import br.com.guilhermebehs.school.academic.application.student.enroll.EnrollStudentDto;
import br.com.guilhermebehs.school.academic.domain.student.StudentHasBeenEnrolled;
import br.com.guilhermebehs.school.academic.infra.student.InMemoryStudentRepository;

public class EnrollStudentByCommandLine {

    public static void main(String[] args) {

        var cpf = "73718334062";
        var email = "fulano@gmail.com";
        var name = "Fulano de tal";
        var enrollStudentDto = new EnrollStudentDto(cpf, name, email);
        enrollStudentDto.addPhone("51", "999999999");

        EventPublisher eventPublisher = new EventPublisher();
        eventPublisher.add(new StudentHasBeenEnrolled());
        eventPublisher.add(new GenerateTrophyToNewStudent(new InMemoryTrophyRepository()));

        EnrollStudent enrollStudent = new EnrollStudent(new InMemoryStudentRepository(), eventPublisher);
        enrollStudent.execute(enrollStudentDto);

    }
}
