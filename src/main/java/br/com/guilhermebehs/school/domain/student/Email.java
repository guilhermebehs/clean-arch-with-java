package br.com.guilhermebehs.school.domain.student;

public class Email {

    private String address;

    public Email(String address){
        if(address == null || !address.matches("(.+)@(.+)$"))
            throw new IllegalArgumentException("Invalid email address");
        this.address = address;
    }
}
