package br.com.guilhermebehs.school.domain.recommendation;

import br.com.guilhermebehs.school.domain.student.Student;

import java.time.LocalDateTime;

public class Recommendation {

    private Student recommendedStudent;
    private Student studentWhoRecommends;
    private LocalDateTime recommendationDate;

    public Recommendation(Student recommendedStudent, Student studentWhoRecommends){
        this.recommendedStudent = recommendedStudent;
        this.studentWhoRecommends = studentWhoRecommends;
        this.recommendationDate = LocalDateTime.now();
    }

    public Student getRecommendedStudent() {
        return recommendedStudent;
    }

    public Student getStudentWhoRecommends() {
        return studentWhoRecommends;
    }

    public LocalDateTime getRecommendationDate() {
        return recommendationDate;
    }
}
