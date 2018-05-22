package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Password {
    private int id;
    private int urlId;
    private String password;

    public static Password addPasswordToUrl(Url url, String secretString) {
        Password password = new Password();
        password.urlId = url.getId();
        password.password = secretString;
        password.save();

        return password;
    }

    public void save() {
        Connection db = Database.getConnection();
        String query = "INSERT INTO `password` (url_id, password) VALUES (?, ?)";

        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setInt(1, this.urlId);
            statement.setString(2, this.password);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
