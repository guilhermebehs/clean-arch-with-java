package br.com.guilhermebehs.school.infra.student;

import br.com.guilhermebehs.school.domain.student.PasswordEncryptor;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordEncryptor implements PasswordEncryptor {


    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(),0,password.length());
            return new BigInteger(1,messageDigest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean validateEncryptedPassword(String encryptedPassword, String password) {
        return encryptedPassword.equals(encryptPassword(password));
    }
}
