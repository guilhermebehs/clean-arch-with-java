package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.shared.domain.Cpf;
import br.com.guilhermebehs.school.shared.domain.event.Event;
import br.com.guilhermebehs.school.shared.domain.event.EventType;

import java.time.LocalDateTime;
import java.util.Map;

import static br.com.guilhermebehs.school.shared.domain.event.EventType.STUDENT_HAS_BEEN_ENROLLED;

public class StudentHasBeenEnrolledEvent implements Event {

    private final Cpf studentCpf;
    private LocalDateTime moment;

    public StudentHasBeenEnrolledEvent(Cpf studentCpf) {
        this.studentCpf = studentCpf;
        this.moment = LocalDateTime.now();
    }

    @Override
    public LocalDateTime moment() {
        return moment;
    }

    @Override
    public EventType type() {
        return STUDENT_HAS_BEEN_ENROLLED;
    }

    @Override
    public Map<String, Object> info() {
        return Map.of("cpf", studentCpf);
    }

    public Cpf getCpf(){
        return studentCpf;
    }
}
