package by.epam.training.course.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.training.course.dao.AbstractDao;
import by.epam.training.course.dao.StudentDao;
import by.epam.training.course.entity.Student;
import by.epam.training.course.exception.DaoException;

public class StudentDaoImpl extends AbstractDao implements StudentDao {
    private final String SQL = "SELECT `id`, `surname`, `name`, `patronymic`, `bdate`, `student_number`, `group_number` FROM `student`";
    
    public Student read(Integer id) throws DaoException {
        Student entity = null;
        String sql = SQL + " WHERE `id` = ?";
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sql);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                entity = createEntity(resultSet);
            }
            return entity;
        } catch (SQLException e) {
            throw new DaoException("Error: readStudentById()", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("StudentDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("StudentDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    public Integer insert(Student entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int update(Student entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int delete(Student entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
    
    private Student createEntity(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setSurname(resultSet.getString("surname"));
        student.setName(resultSet.getString("name"));
        student.setPatronymic(resultSet.getString("patronymic"));
        student.setBornDate(resultSet.getDate("bdate"));
        student.setStudentNumber(resultSet.getInt("student_number"));
        student.setGroupNumber(resultSet.getInt("group_number"));
        return student;
    }
}