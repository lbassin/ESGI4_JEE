package utils;

import java.sql.*;
import java.util.ArrayList;

public class Url {
    private int id;
    private String urlLong;
    private String urlShort;
    private int userId;
    private int availableAt;
    private int expiredAt;

    static public Url createShortUrl(String longUrl, String password) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Url url = new Url();
        url.urlLong = longUrl;
        url.urlShort = String.valueOf(timestamp.getTime());

        url.save();

        if (password.length() > 0) {
            Password.addPasswordToUrl(url, password);
        }

        return url;
    }

    public static Url getByShortUrl(String shortUrl) {
        Connection db = Database.getConnection();
        String query = "SELECT id, url_long, expired_at FROM url WHERE url_short = ?";

        Url url = new Url();

        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            statement = db.prepareStatement(query);
            statement.setString(1, shortUrl);

            results = statement.executeQuery();
            if (!results.isBeforeFirst()) {
                return url;
            }

            results.next();
            url.setId(results.getInt("id"));
            url.setUrlLong(results.getString("url_long"));
            url.setExpiredAt(results.getInt("expired_at"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public ArrayList<String> getPasswords() {
        String query = "SELECT password WHERE url_id = ?";
        Connection db = Database.getConnection();

        PreparedStatement statement = null;


        return null;
    }

    public void setExpiredAt(int expiredAt) {
        this.expiredAt = expiredAt;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getUrlShort() {
        return this.urlShort;
    }

    private void save() {
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

    public String getUrlLong() {
        return this.urlLong;
    }

    public boolean isProtected() {
        Connection db = Database.getConnection();
        String query = "SELECT COUNT(*) FROM `password` WHERE `url_id` = ?";

        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setInt(1, this.id);

            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst()) {
                return false;
            }
            rs.next();

            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean checkPassword(String password) {
        Connection db = Database.getConnection();
        String query = "SELECT COUNT(*) FROM `password` WHERE `url_id` = ? and `password` = ?";

        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setInt(1, this.id);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst()) {
                return false;
            }
            rs.next();

            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
