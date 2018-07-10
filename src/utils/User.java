package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean checkUser() {
        Connection connection = Database.getConnection();
        boolean connectionState = false;

        String query = "SELECT * FROM `user` WHERE email = ? AND password = ? LIMIT 1";

        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, this.email);
            statement.setString(2, this.password);
            rs = statement.executeQuery();

            connectionState = rs.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connectionState;
    }

    static public void registerUser(String username, String email, String password) {
        Connection connection = Database.getConnection();

        String query = "INSERT INTO `user` (username, email, password, verified, type_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setInt(4, 0);
            statement.setString(5, null);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
