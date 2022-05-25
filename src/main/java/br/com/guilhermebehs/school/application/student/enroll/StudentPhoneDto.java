package br.com.guilhermebehs.school.application.student.enroll;

public class StudentPhoneDto {

    private String ddd;
    private String number;

    public StudentPhoneDto(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}
