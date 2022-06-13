package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.shared.domain.Cpf;

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

    public Student addPhone(Phone phone){
        if(phones.size() == 2)
            throw new MaxNumberOfPhonesExceededException();
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

    public String getPassword() {
        return password;
    }

    public Student setPassword(String password) {
        this.password = password;
        return this;
    }
}
