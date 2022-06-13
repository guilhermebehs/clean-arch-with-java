package br.com.guilhermebehs.school.gamification.domain.trophy;

import br.com.guilhermebehs.school.shared.domain.Cpf;

public class Trophy {

    private Cpf studentCpf;
    private String name;

    public Trophy(Cpf studentCpf, String name) {
        this.studentCpf = studentCpf;
        this.name = name;
    }

    public Cpf getStudentCpf() {
        return studentCpf;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trophy{" +
                "studentCpf=" + studentCpf +
                ", name='" + name + '\'' +
                '}';
    }
}
