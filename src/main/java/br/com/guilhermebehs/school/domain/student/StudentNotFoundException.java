package br.com.guilhermebehs.school.domain.student;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Cpf cpf){
        super("Student with cpf "+cpf+" not found");
    }
}
