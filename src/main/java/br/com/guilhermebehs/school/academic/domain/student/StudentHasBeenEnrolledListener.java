package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.academic.domain.EventListener;

import java.time.format.DateTimeFormatter;

public class StudentHasBeenEnrolledListener extends EventListener {

    @Override
    protected void reactTo(Event event) {
        String formattedMoment = event.moment().format( DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println(String.format(
                "Aluno com CPF %s foi matriculado em %s",
                ((StudentHasBeenEnrolledEvent)event).getCpf().getNumber(),
                formattedMoment));
    }

    @Override
    protected boolean shouldProcess(Event event) {
        return event instanceof StudentHasBeenEnrolledEvent;
    }
}
