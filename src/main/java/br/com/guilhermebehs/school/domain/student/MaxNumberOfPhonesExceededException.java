package br.com.guilhermebehs.school.domain.student;

public class MaxNumberOfPhonesExceededException extends RuntimeException{

    public MaxNumberOfPhonesExceededException(){
        super("Student reached max number of registered phones");
    }
}
