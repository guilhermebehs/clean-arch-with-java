package br.com.guilhermebehs.school.application.recommendation;

import br.com.guilhermebehs.school.domain.student.Student;

public interface SendRecommendationEmail {

    void sendTo(Student recommendedStudent);
}
