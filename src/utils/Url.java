package utils;

import java.sql.*;

public class Url {
    private int id;
    private String urlLong;
    private String urlShort;
    private int userId;
    private int availableAt;
    private int expiredAt;

    static public Url createShortUrl(String longUrl, String password) {
        Url url = new Url();
        url.urlLong = longUrl;
        url.urlShort = longUrl;

        url.save();
        Password.addPasswordToUrl(url, password);

        return url;
    }

    public int getId() {
        return this.id;
    }

    public String getUrlShort() {
        return this.urlShort;
    }

    public void save() {
        Connection db = Database.getConnection();
        String query = "INSERT INTO `url` (url_long, url_short) VALUES (?, ?)";

        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.urlLong);
            statement.setString(2, this.urlShort);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                this.id = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
