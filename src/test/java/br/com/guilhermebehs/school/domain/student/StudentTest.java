package br.com.guilhermebehs.school.domain.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Student")
class StudentTest {

    Student student;

    @BeforeEach
    public void setUp(){
        student = new Student(
                    new Cpf("02853279031"),
                    "Guilherme",
                    new Email("gui@hotmail.com"));
    }

    @Test
    @DisplayName("should throw when max number of phones are reached")
    void shouldThrowWhenMaxNumberOfPhonesAreReached() {

        assertDoesNotThrow(()-> student.addPhone(new Phone("51", "996692891")));
        assertDoesNotThrow(()-> student.addPhone(new Phone("51", "996692891")));
        var exception = assertThrows(MaxNumberOfPhonesExceededException.class,
                ()-> student.addPhone(new Phone("51", "996692891")));

        assertEquals(exception.getMessage(), "Student reached max number of registered phones");
    }
}