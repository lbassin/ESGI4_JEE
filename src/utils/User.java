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
}
