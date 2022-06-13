package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.shared.domain.Cpf;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Cpf cpf){
        super("Student with cpf "+cpf+" not found");
    }
}
