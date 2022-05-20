package br.com.guilhermebehs.school.domain.student;

public class Cpf {

    private final String CPF_REGEX = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
    private String number;


    public Cpf(String number){
        if(number == null || !number.matches(CPF_REGEX))
            throw new IllegalArgumentException("Invalid CPF number");
        this.number = number;
    }
}
