package br.com.guilhermebehs.school.academic.domain.student;

import br.com.guilhermebehs.school.shared.domain.Cpf;

import java.util.ArrayList;
import java.util.List;

public class StudentBuilder {

    private String name;
    private Cpf cpf;
    private Email email;
    private List<Phone> phones = new ArrayList<Phone>();


    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public StudentBuilder setCpf(String cpf){
        this.cpf = new Cpf(cpf);
        return this;
    }

    public StudentBuilder setEmail(String email){
        this.email = new Email(email);
        return this;
    }

    public StudentBuilder addPhone(String ddd, String number){
        phones.add(new Phone(ddd, number));
        return this;
    }

    public Student build(){
       var student = new Student(cpf,name, email);
       phones.forEach(phone -> student.addPhone(phone));
       return student;
    }

}
