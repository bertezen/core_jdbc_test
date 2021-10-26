package core.jdbc.dao;

import core.jdbc.model.User;
import core.jdbc.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS users(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80), lastName VARCHAR(100), age INTEGER);";
    private final String DROP_TABLE = "DROP TABLE IF EXISTS users";
    private final String SAVE_USER = "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?);";
    private final String REMOVE_USER = "DELETE FROM users WHERE id = ?";

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement(CREATE_TABLE);
            pr.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement(DROP_TABLE);
            pr.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, Integer age) {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement(SAVE_USER);
            pr.setString(1, name);
            pr.setString(2, lastName);
            pr.setInt(3, age);
            pr.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement(REMOVE_USER);
            pr.setLong(1, id);
            pr.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Connection connection = Util.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                list.add(new User(name, lastName, age));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        dropUsersTable();
        createUsersTable();
    }
}
