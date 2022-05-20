package br.com.guilhermebehs.school.infra.student;

import br.com.guilhermebehs.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCStudentRepository implements StudentRepository {

    private final Connection connection;

    public JDBCStudentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        String sql = "INSERTO INTO student VALUES(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf().getNumber());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail().getAddress());
            ps.execute();

            sql = "INSERT INTO phone VALUES(?,?)";
            ps = connection.prepareStatement(sql);
            for(Phone phone: student.getPhones()){
                ps.setString(1, student.getCpf().getNumber());
                ps.setString(2, phone.getDdd());
                ps.setString(3, phone.getNumber());
                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Student findByCpf(Cpf cpf) {
        String sql = "SELECT * FROM student WHERE cpf = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,cpf.getNumber());
            ResultSet rs = ps.executeQuery();
            if(!rs.next())
                throw new StudentNotFoundException(cpf);

            var email = new Email(rs.getString("email"));
            var name = rs.getString("name");
            var student = new Student(cpf, name, email);
            sql = "SELECT * FROM phone WHERE cpf = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,cpf.getNumber());
            rs = ps.executeQuery();
            while(rs.next()){
                  var phone = new Phone(rs.getString("ddd"), rs.getString("number"));
                  student.addPhone(phone);
           }
           return student;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        String sql = "SELECT * FROM student";
        PreparedStatement ps = null;
        var students = new ArrayList<Student>();
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                var email = new Email(rs.getString("email"));
                var name = rs.getString("name");
                var cpf = new Cpf(rs.getString("cpf"));

                var student = new Student(cpf, name, email);
                sql = "SELECT * FROM phone WHERE cpf = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1,cpf.getNumber());
                rs = ps.executeQuery();
                while(rs.next()){
                    var phone = new Phone(rs.getString("ddd"), rs.getString("number"));
                    student.addPhone(phone);
                }
                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
