package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean checkUser() {
        Connection connection = Database.getConnection();
        boolean connectionState = false;

        String query = "SELECT * FROM `user` WHERE email = ? AND password = ? AND verified = 1 LIMIT 1";

        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, this.email);
            statement.setString(2, this.password);
            rs = statement.executeQuery();

            connectionState = rs.isBeforeFirst();

            if (rs.next()) {
                this.id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connectionState;
    }

    public Integer getId() {
        return this.id;
    }

    static public void registerUser(String username, String email, String password, String verifID) {
        Connection connection = Database.getConnection();

        String query = "INSERT INTO `user` (username, email, password, verified, verif_id, type_id) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setInt(4, 0);
            statement.setString(5, verifID);
            statement.setString(6, null);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static public User getUser(int id) {
        Connection connection = Database.getConnection();

        String query = "SELECT * FROM `user` WHERE id = ?";

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (!rs.isBeforeFirst()) {
                return new User();
            }

            rs.next();

            User user = new User();
            user.id = rs.getInt("id");
            user.username = rs.getString("username");
            user.email = rs.getString("email");
            user.password = rs.getString("password");

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new User();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
