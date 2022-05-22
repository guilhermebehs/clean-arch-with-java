package br.com.guilhermebehs.school.domain.student;

public interface PasswordEncryptor {

    String encryptPassword(String password);
    boolean validateEncryptedPassword(String encryptedPassword, String password);
}
