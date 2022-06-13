package br.com.guilhermebehs.school.academic.domain.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Email")
class EmailTest {

    @Test
    @DisplayName("should succeed when email is created with valid address")
    public void shouldSucceedWhenEmailIsCreatedWithValidAddress(){
        assertDoesNotThrow(()-> new Email("guilhermebehs@gmail.com"));
    }

    @Test
    @DisplayName("should throw when email is created with null address")
    public void shouldThrowWhenEmailIsCreatedWithNullAddress(){
        assertThrows(IllegalArgumentException.class, ()-> new Email(null));
    }

    @Test
    @DisplayName("shiuld throw when email is created with invalid address")
    public void shouldThrowWhenEmailIsCreatedWithInvalidAddress(){
        assertThrows(IllegalArgumentException.class, ()-> new Email("guilherme"));
    }



}