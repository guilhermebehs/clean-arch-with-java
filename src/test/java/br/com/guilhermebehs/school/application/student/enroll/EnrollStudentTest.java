package br.com.guilhermebehs.school.application.student.enroll;

import br.com.guilhermebehs.school.domain.student.Cpf;
import br.com.guilhermebehs.school.domain.student.StudentBuilder;
import br.com.guilhermebehs.school.infra.student.InMemoryStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EnrollStudent")
class EnrollStudentTest {

    @Test
    @DisplayName("Should persist student")
    public void shouldPersistStudent(){
        var inMemoryRepo = new InMemoryStudentRepository();
        var enrollStudent = new EnrollStudent(inMemoryRepo);
        var student = new EnrollStudentDto("02953279090","guilherme", "guilherme@gmail.com");

        enrollStudent.execute(student);
        var persistedStudent = inMemoryRepo.findByCpf(new Cpf("02953279090"));

        assertEquals(persistedStudent.getCpf().getNumber(), "02953279090");
        assertEquals(persistedStudent.getName(), "guilherme");
        assertEquals(persistedStudent.getEmail().getAddress(), "guilherme@gmail.com");


    }

}