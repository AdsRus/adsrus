package com.codeup.adsrus.dao;

import com.codeup.adsrus.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


    @Override
    public List<Ad> all_ua(long user_id) {
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, user_id);
            ResultSet rs = stmt.executeQuery();


            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user ads.", e);
        }
    }

    @Override
    public List<Ad> all_searchads(String ad) {
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE title LIKE ?");
            String pid = ad + "%";
            stmt.setString(1,pid);
            ResultSet rs = stmt.executeQuery();

            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
    //add code to extract only a specific ad
    public List<Ad> findById(long id) {
        String idS = String.valueOf(id).toString();
        PreparedStatement stmt = null;
        String myPassedSql = "SELECT * FROM ads WHERE id =" +idS;
        try {
            stmt = connection.prepareStatement(myPassedSql);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


//    public Ad findById(long id) {
//        try {
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM ads WHERE id=2";    //" + id;
//            ResultSet rs = statement.executeQuery(query);
//            rs.next();
//            return extractAd(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving an Ad.", e);
//        }
//    }
    //add code to extract only a specific ad
//    public List<Ad> adSpecific() {
//        List<Ad> specificAd = new ArrayList<>();
//
//        PreparedStatement stmt = null;
//        String sqlSt = "SELECT u.username, a.title, a.description FROM ads AS a join users AS u on a.user_id = u.id LIMIT 1;";
//        try {
//            stmt = connection.prepareStatement(sqlSt);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()){
//               specificAd.add(extractSpecAd(rs));
//                //System.out.println(specificAd.add(extractSpecAd(rs)));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    return specificAd;
//    }
//    private Ad extractSpecAd(ResultSet rs) throws SQLException {
//        return new Ad(
//                rs.getString("username"),
//                rs.getString("title"),
//                rs.getString("description")
//        );
//    }
//

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
