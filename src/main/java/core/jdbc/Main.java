package core.jdbc;

import core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        System.out.println(userDaoJDBC.getAllUsers());
        System.out.println("*****");
        userDaoJDBC.saveUser("user1", "last1",  11);
        System.out.println(userDaoJDBC.getAllUsers());
    }
}
