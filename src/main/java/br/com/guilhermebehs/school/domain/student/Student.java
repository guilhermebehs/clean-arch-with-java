package br.com.guilhermebehs.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private Cpf cpf;
    private String name;
    private String password;
    private Email email;
    private List<Phone> phones = new ArrayList<Phone>();

    public Student(Cpf cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public Student addPhone(String ddd, String number){
        phones.add(new Phone(ddd, number));
        return this;
    }

    public Student addPhone(Phone phone){
        phones.add(phone);
        return this;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
