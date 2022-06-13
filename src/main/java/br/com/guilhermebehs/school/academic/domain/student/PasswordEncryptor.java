package br.com.guilhermebehs.school.academic.domain.student;

public interface PasswordEncryptor {

    String encryptPassword(String password);
    boolean validateEncryptedPassword(String encryptedPassword, String password);
}
