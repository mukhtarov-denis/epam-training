package by.epam.training.course.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.training.course.dao.AbstractDao;
import by.epam.training.course.dao.CourseDao;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Teacher;
import by.epam.training.course.exception.DaoException;

public class CourseDaoImpl extends AbstractDao implements CourseDao {
    private final String SQL = "SELECT `id`, `name`, `start_date`, `end_date`, `id_teacher` FROM `course`"; 

    public Course read(Integer id) throws DaoException {
        Course course = null;
        String sqlQuery = SQL + " WHERE `id` = ?";
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sqlQuery);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                course = createEntity(resultSet);
            }
            return course;
        } catch (SQLException e) {
            throw new DaoException("Error: read(id), courseDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("CourseDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("CourseDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    @Override
    public Course readByTeacher(Teacher teacher) throws DaoException {
        Course course = null;
        String sqlQuery = SQL + " WHERE `id_teacher` = ?";
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sqlQuery);
            pStatement.setInt(1, teacher.getId());
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                course = createEntity(resultSet);
            }
            return course;
        } catch (SQLException e) {
            throw new DaoException("Error: readByTeacher(), courseDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("CourseDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("CourseDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }
    
    @Override
    public List<Course> readAll() throws DaoException {
        List<Course> entities = new ArrayList<>();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;        
        try {
            pStatement = getConnection().prepareStatement(SQL);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Course course = createEntity(resultSet);
                entities.add(course);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException("Error: readAll(), courseDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("CourseDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("CourseDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }
    
    public Integer insert(Course entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int update(Course entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int delete(Course entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
    
    private Course createEntity(ResultSet rs) throws SQLException {
        Course entity = new Course();
        entity.setId(rs.getInt("id"));
        entity.setName(rs.getString("name"));
        entity.setStartDate(rs.getDate("start_date"));
        entity.setEndDate(rs.getDate("end_date"));
        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt("id_teacher"));
        entity.setTeacher(teacher);
        return entity;
    }
}