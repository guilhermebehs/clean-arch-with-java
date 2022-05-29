package br.com.guilhermebehs.school.domain.student;

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
