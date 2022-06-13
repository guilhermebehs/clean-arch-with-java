package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.shared.domain.Cpf;

import java.time.LocalDateTime;

public class StudentHasBeenEnrolledEvent implements Event{

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

    public Cpf getCpf(){
        return studentCpf;
    }
}
