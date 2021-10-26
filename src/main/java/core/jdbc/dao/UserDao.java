package core.jdbc.dao;

import core.jdbc.model.User;
import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, Integer age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
