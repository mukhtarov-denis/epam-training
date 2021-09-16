package by.epam.training.course.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.training.course.dao.AbstractDao;
import by.epam.training.course.dao.TeacherDao;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.DaoException;

public class TeacherDaoImpl extends AbstractDao implements TeacherDao {
    private final String SQL = "SELECT `id`, `surname`, `name`, `patronymic`, `bdate`, `post` FROM `teacher`";
    
    public Teacher read(Integer id) throws DaoException {
        Teacher entity = null;
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
            throw new DaoException("Error: readTeacherById()", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("TeacherDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("TeacherDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    public Integer insert(Teacher entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int update(Teacher entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int delete(Teacher entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
    
    private Teacher createEntity(ResultSet resultSet) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(resultSet.getInt("id"));
        teacher.setSurname(resultSet.getString("surname"));
        teacher.setName(resultSet.getString("name"));
        teacher.setPatronymic(resultSet.getString("patronymic"));
        teacher.setBornDate(resultSet.getDate("bdate"));
        teacher.setPost(resultSet.getString("post"));
        return teacher;
    }
}