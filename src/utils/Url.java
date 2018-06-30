package utils;

import java.sql.*;
import java.util.ArrayList;

public class Url {
    private int id;
    private String urlLong;
    private String urlShort;
    private int userId;
    private String createdAt;
    private String availableAt;
    private String expiredAt;

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
        String query = "SELECT * FROM url WHERE url_short = ?";

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
            url = Url.resultToObject(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static Url getById(int id) {
        Connection db = Database.getConnection();
        String query = "SELECT * FROM `url` WHERE `id` = ?";

        Url url = new Url();

        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            statement = db.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if (!results.isBeforeFirst()) {
                return url;
            }

            results.next();
            url = Url.resultToObject(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return url;
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

    public String getFullUrlShort() {
        return "http://127.0.0.1:8082/lk/" + this.urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(String availableAt) {
        this.availableAt = availableAt;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
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

    static public ArrayList<Url> getAllByUser(int userId) {
        Connection db = Database.getConnection();
        String query = "SELECT * FROM `url` WHERE `user_id` = ?";

        ArrayList<Url> urls = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setInt(1, userId);

            ResultSet results = statement.executeQuery();
            if (!results.isBeforeFirst()) {
                return urls;
            }

            while (results.next()) {
                urls.add(Url.resultToObject(results));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return urls;
    }

    static private Url resultToObject(ResultSet result) throws SQLException {
        Url url = new Url();

        url.setId(result.getInt("id"));
        url.setUrlShort(result.getString("url_short"));
        url.setUrlLong(result.getString("url_long"));
        url.setCreatedAt(result.getDate("created_at").toString());

        return url;
    }
}
