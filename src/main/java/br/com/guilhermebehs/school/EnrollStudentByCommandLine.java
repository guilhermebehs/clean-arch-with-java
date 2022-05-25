package br.com.guilhermebehs.school;

import br.com.guilhermebehs.school.application.student.enroll.EnrollStudent;
import br.com.guilhermebehs.school.application.student.enroll.EnrollStudentDto;
import br.com.guilhermebehs.school.infra.student.InMemoryStudentRepository;

public class EnrollStudentByCommandLine {

    public static void main(String[] args) {

        var cpf = "73718334062";
        var email = "fulano@gmail.com";
        var name = "Fulano de tal";
        var enrollStudentDto = new EnrollStudentDto(cpf, name, email);
        enrollStudentDto.addPhone("51", "999999999");

        EnrollStudent enrollStudent = new EnrollStudent(new InMemoryStudentRepository());
        enrollStudent.execute(enrollStudentDto);



    }
}
