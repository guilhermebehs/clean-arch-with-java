package br.com.guilhermebehs.school.academic.domain.student;

public class Email {

    private String address;

    public Email(String address){
        if(address == null || !address.matches("(.+)@(.+)$"))
            throw new IllegalArgumentException("Invalid email address");
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
