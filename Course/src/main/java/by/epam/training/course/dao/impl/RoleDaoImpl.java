package by.epam.training.course.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.epam.training.course.dao.AbstractDao;
import by.epam.training.course.dao.RoleDao;
import by.epam.training.course.entity.Role;
import by.epam.training.course.exception.DaoException;

public class RoleDaoImpl extends AbstractDao implements RoleDao {
    private final String SQL = "SELECT `ur`.`id_user`, `ur`.`id_role`, `r`.`role` "
                             + "FROM `user_role` AS `ur` JOIN `role` AS `r` "
                             + "WHERE `ur`.`id_role` = `r`.`id` ";
    
    public Role read(Integer id) throws DaoException {
        String sql = SQL + " AND `ur`.`id_role` = ?";
        Role role = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sql);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                role = createEntity(resultSet);
            }
            return role;
        } catch (SQLException e) {
            throw new DaoException("roleDao, error read by idUser", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("roleDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("roleDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }
    
    @Override
    public Set<Role> readUserRole(Integer idUser) throws DaoException {
        String sql = SQL + " AND `ur`.`id_user` = ?";
        Set<Role> roles = new HashSet<>();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(sql);
            pStatement.setInt(1, idUser);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Role role = createEntity(resultSet);
                roles.add(role);
            }
            return roles;
        } catch (SQLException e) {
            throw new DaoException("roleDao, error read by idUser", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("roleDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("roleDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    @Override
    public List<Role> readAll() throws DaoException {
        List<Role> roles = new ArrayList<>();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            pStatement = getConnection().prepareStatement(SQL);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Role role = createEntity(resultSet);
                roles.add(role);
            }
            return roles;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DaoException("Error read all roles", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoException("roleDao, Error close resultSet", e);
                }
                pStatement = null;
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                    throw new DaoException("roleDao, Error close statement", e);
                }
                pStatement = null;
            }
        }
    }

    public Integer insert(Role entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int update(Role entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public int delete(Role entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
    
    private Role createEntity(ResultSet resultSet) throws SQLException {
        Role entity = new Role();
        entity.setId(resultSet.getInt("id_role"));
        entity.setName(resultSet.getString("role"));
        return entity;
    }
}