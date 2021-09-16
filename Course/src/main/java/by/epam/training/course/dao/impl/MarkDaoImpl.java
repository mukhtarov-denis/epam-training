package by.epam.training.course.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import by.epam.training.course.dao.AbstractDao;
import by.epam.training.course.dao.MarkDao;
import by.epam.training.course.entity.Mark;
import by.epam.training.course.entity.Course;
import by.epam.training.course.entity.Student;
import by.epam.training.course.exception.DaoException;

public class MarkDaoImpl extends AbstractDao implements MarkDao {
    private final String SQL = "SELECT `id_course`, `id_student`, `mark_value`, `review` FROM `mark`";
    
    public Mark read(Integer id) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Mark read(Integer idCourse, Integer idStudent) throws DaoException {
        String sqlQuery = SQL + " WHERE `id_course` = ? AND `id_student` = ?";
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        Mark mark = null;
        try {
            pStatement = getConnection().prepareStatement(sqlQuery);
            pStatement.setInt(1, idCourse);
            pStatement.setInt(2, idStudent);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                mark = createEntity(resultSet);
            }
            return mark;
        } catch (SQLException e) {
            throw new DaoException("Error: readMark(Integer idCourse, Integer idStudent)", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("MarkDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("MarkDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }
    
    public Integer insert(Mark entity) throws DaoException {
        String sqlQuery = "INSERT INTO `mark`(`id_course`, `id_student`, `mark_value`, `review`) "
                        + "VALUES (?, ?, ?, ?)";
        PreparedStatement pStatement = null;
        ResultSet keys = null;
        try {
            pStatement = getConnection().prepareStatement(sqlQuery);
            setParameters(pStatement, entity);
            return pStatement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Error: insert mark", e);
        } finally {
            if (keys != null) {
                try {
                    keys.close();
                } catch(Exception e) {
                    throw new DaoException("MarkDao insert, Error close keys", e);
                }
                keys = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch(Exception e) {
                    throw new DaoException("MarkDao insert, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    public int update(Mark entity) throws DaoException {
        String sqlQuery = "UPDATE `mark` "
                        + "SET `mark_value` = ?, `review` = ? "
                        + "WHERE `id_course` = ?  AND `id_student` = ?";
        PreparedStatement pStatement = null;
        try {
            pStatement = getConnection().prepareStatement(sqlQuery);
            if (entity.getValue() != null) {
                pStatement.setInt(1, entity.getValue());
            } else {
                pStatement.setNull(1, Types.INTEGER);
            }
            if (entity.getReview() != null) {
                pStatement.setString(2, entity.getReview());
            } else {
                pStatement.setNull(2, Types.VARCHAR);
            }
            pStatement.setInt(3, entity.getCourse().getId());
            pStatement.setInt(4, entity.getStudent().getId());
            return pStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error: update mark", e);
        } finally {
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch(Exception e) {
                    throw new DaoException("MarkDao update, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    public int delete(Mark entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public List<Mark> readByCourse(Course course) throws DaoException {
        String sqlQuery = SQL + " WHERE `id_course` = ?";
        List<Mark> entities = new ArrayList<>();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sqlQuery);
            pStatement.setInt(1, course.getId());
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Mark mark = createEntity(resultSet);
                entities.add(mark);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException("Error: readByCourse(), MarkDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("MarkDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("MarkDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    @Override
    public List<Mark> readByStudent(Student student) throws DaoException {
        String sqlQuery = SQL + " WHERE `id_student` = ?";
        List<Mark> entities = new ArrayList<>();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sqlQuery);
            pStatement.setInt(1, student.getId());
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Mark mark = createEntity(resultSet);
                entities.add(mark);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException("Error: readByStudent(), MarkDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("MarkDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("MarkDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }
    
    private Mark createEntity(ResultSet resultSet) throws SQLException {
        Mark mark = new Mark();
        Course course = new Course();
        course.setId(resultSet.getInt("id_course"));
        mark.setCourse(course);
        Student student = new Student();
        student.setId(resultSet.getInt("id_student"));
        mark.setStudent(student);
        mark.setValue(resultSet.getInt("mark_value") == 0 ? null : resultSet.getInt("mark_value"));
        mark.setReview(resultSet.getString("review"));
        return mark;
    }
    
    private void setParameters(PreparedStatement pStatement, Mark entity) throws SQLException {
        pStatement.setInt(1, entity.getCourse().getId());
        pStatement.setInt(2, entity.getStudent().getId());
        if (entity.getValue() != null) {
            pStatement.setInt(3, entity.getValue());
        } else {
            pStatement.setNull(3, Types.INTEGER);
        }
        if (entity.getReview() != null) {
            pStatement.setString(4, entity.getReview());
        } else {
            pStatement.setNull(4, Types.VARCHAR);
        }
    }
}