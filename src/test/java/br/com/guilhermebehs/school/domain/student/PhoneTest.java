package br.com.guilhermebehs.school.domain.student;

import br.com.guilhermebehs.school.domain.student.Phone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Phone")
class PhoneTest {

    @Test
    @DisplayName("should succeed when ddd and number are valid")
    public void shouldSucceedWhenDddAndNumberAreValid(){
        assertDoesNotThrow(()-> new Phone("51", "996692798"));
    }

    @Test
    @DisplayName("should throw when ddd is null")
    public void shouldThrowWhenDddIsNull(){
        assertThrows(IllegalArgumentException.class,()-> new Phone(null, "996692798"));
    }

    @Test
    @DisplayName("should throw when number is null")
    public void shouldThrowWhenNumberIsNull(){
        assertThrows(IllegalArgumentException.class,()-> new Phone("51", null));
    }

    @Test
    @DisplayName("should throw when ddd is invalid")
    public void shouldThrowWhenDddIsInvalid(){
        assertThrows(IllegalArgumentException.class,()-> new Phone("511", "996692798"));
    }

    @Test
    @DisplayName("should throw when number is invalid")
    public void shouldThrowWhenNumberIsInvalid(){
        assertThrows(IllegalArgumentException.class,()-> new Phone("51", "9966927982"));
    }


}