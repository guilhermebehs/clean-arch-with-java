package br.com.guilhermebehs.school.domain.student;

public class Phone {

    private String ddd;
    private String number;

    public Phone(String ddd, String number){
        if(ddd == null || !ddd.matches("\\d{2}") )
            throw new IllegalArgumentException("Invalid phone DDD");
        if(number == null || !number.matches("\\d{8}|\\d{9}"))
            throw new IllegalArgumentException("Invalid phone number");

        this.ddd = ddd;
        this.number = number;
    }
}
