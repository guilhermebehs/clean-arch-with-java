package br.com.guilhermebehs.school.academic.domain.student;

public class MaxNumberOfPhonesExceededException extends RuntimeException{

    public MaxNumberOfPhonesExceededException(){
        super("Student reached max number of registered phones");
    }
}
