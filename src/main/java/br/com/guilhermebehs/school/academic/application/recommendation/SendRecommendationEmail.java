package br.com.guilhermebehs.school.academic.application.recommendation;

import br.com.guilhermebehs.school.academic.domain.student.Student;

public interface SendRecommendationEmail {

    void sendTo(Student recommendedStudent);
}
