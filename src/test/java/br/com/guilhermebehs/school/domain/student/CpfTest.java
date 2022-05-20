package br.com.guilhermebehs.school.domain.student;

import br.com.guilhermebehs.school.domain.student.Cpf;
import br.com.guilhermebehs.school.domain.student.Email;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cpf")
class CpfTest {

    @Test
    @DisplayName("should succeed when cpf is created with valid number")
    public void shouldSucceedWhenCpfIsCreatedWithValidNumber(){
        assertDoesNotThrow(()-> new Cpf("02853279090"));
    }

    @Test
    @DisplayName("should throw when cpf is created with null number")
    public void shouldThrowWhenCpfIsCreatedWithNullNumber(){
        assertThrows(IllegalArgumentException.class, ()-> new Cpf(null));
    }

    @Test
    @DisplayName("should throw when cpf is created with invalid number")
    public void shouldThrowWhenCpfIsCreatedWithInvalidNumber(){
        assertThrows(IllegalArgumentException.class, ()-> new Email("028"));
    }


}