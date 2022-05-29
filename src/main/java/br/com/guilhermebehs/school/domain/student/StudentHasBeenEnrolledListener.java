package br.com.guilhermebehs.school.domain.student;

import java.time.format.DateTimeFormatter;

public class StudentHasBeenEnrolledListener {

    public void reactTo(StudentHasBeenEnrolledEvent event){
        String formattedMoment = event.moment().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(String.format(
                             "Aluno com CPF %s foi matriculado em %s",
                             event.getCpf().getNumber(),
                             formattedMoment));
    }
}
