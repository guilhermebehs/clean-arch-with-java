package br.com.guilhermebehs.school.academic.application.student.enroll;

import br.com.guilhermebehs.school.academic.domain.student.Phone;
import br.com.guilhermebehs.school.academic.domain.student.StudentBuilder;
import br.com.guilhermebehs.school.academic.domain.student.Student;

import java.util.ArrayList;
import java.util.List;

public class EnrollStudentDto {

    private String cpf;
    private String name;
    private String email;
    private List<StudentPhoneDto> phones = new ArrayList<>();

    public EnrollStudentDto(String cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String ddd, String number){
        phones.add(new StudentPhoneDto(ddd, number));
    }

    public Student toStudent(){
        var student =  new StudentBuilder()
                .setCpf(this.cpf)
                .setEmail(this.email)
                .setName(this.name)
                .build();

        phones.forEach(phone -> student.addPhone(new Phone(phone.getDdd(), phone.getNumber())));

        return student;
    }
}
