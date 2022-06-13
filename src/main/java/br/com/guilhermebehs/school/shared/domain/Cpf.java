package br.com.guilhermebehs.school.shared.domain;

import java.util.Objects;

public class Cpf {

    private final String CPF_REGEX = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
    private String number;


    public Cpf(String number){
        if(number == null || !number.matches(CPF_REGEX))
            throw new IllegalArgumentException("Invalid CPF number");
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(number, cpf.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
