package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.shared.domain.event.Event;
import br.com.guilhermebehs.school.shared.domain.event.EventListener;

import java.time.format.DateTimeFormatter;

import static br.com.guilhermebehs.school.shared.domain.event.EventType.STUDENT_HAS_BEEN_ENROLLED;

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
        return event.type().equals(STUDENT_HAS_BEEN_ENROLLED);
    }
}
