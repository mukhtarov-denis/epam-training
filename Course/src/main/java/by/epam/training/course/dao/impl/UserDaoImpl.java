package by.epam.training.course.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.training.course.dao.AbstractDao;
import by.epam.training.course.dao.UserDao;
import by.epam.training.course.entity.User;
import by.epam.training.course.exception.DaoException;

public class UserDaoImpl extends AbstractDao implements UserDao {
    private final String SQL = "SELECT `id`, `username`, `password`, `expire` FROM `user`";
    
    public User read(Integer id) throws DaoException {
        String sql = SQL + " WHERE `id` = ?";
        User user = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sql);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);                
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException("Error: read user by id, userDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("userDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("userDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    @Override
    public User readByUsername(String username) throws DaoException {
        String sql = SQL + " WHERE `username` like ?";
        User user = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sql);
            pStatement.setString(1, username);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);                
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException("Error: read user by username, userDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("userDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("userDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }
    
    @Override
    public List<User> readAll() throws DaoException {
        String sql = "SELECT `id`, `username`, `password`, `expire` FROM `user`";
        List<User> users = new ArrayList<>();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sql);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                User user = createEntity(resultSet);                
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException("Error: readAll(), userDao", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("userDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("userDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }
    
    public Integer insert(User entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int update(User entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int delete(User entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
    
    private User createEntity(ResultSet resultSet) throws SQLException {
        User entity = new User();
        entity.setId(resultSet.getInt("id"));
        entity.setUsername(resultSet.getString("username"));
        entity.setPassword(resultSet.getString("password"));
        entity.setExpireDate(resultSet.getDate("expire"));
        return entity;
    }
}