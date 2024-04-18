/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.News;
import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TypesOfNews;
import java.sql.SQLException;

/**
 *
 * @author ACERR
 */
public class NewsDAOImpl implements NewsDAO {

    @Override
    public ArrayList<News> getListNews() {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from News";
        ArrayList<News> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setID_News(rs.getInt("ID_News"));
                news.setID_Types_of_news(rs.getInt("ID_Types_of_news"));
                news.setName_News(rs.getString("Name_News"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setImage(rs.getString("image"));
                news.setPublish_date(rs.getString("publish_date"));
                list.add(news);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public ArrayList<News> getListNewsByType(int ID_Types_of_news) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from News where ID_Types_of_news='" + ID_Types_of_news + "'";
        ArrayList<News> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News News = new News();

                News.setID_News(rs.getInt("ID_News"));
                News.setName_News(rs.getString("Name_News"));
                News.setID_Types_of_news(rs.getInt("ID_Types_of_news"));
                News.setTitle(rs.getString("title"));
                News.setContent(rs.getString("content"));
                News.setImage(rs.getString("image"));
                News.setPublish_date(rs.getString("publish_date"));
                arr.add(News);
            }
            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return arr;
    }

    @Override
    public News getListNewsByID(int ID_News) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from News where ID_News= '" + ID_News + "'";
        News tt = new News();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tt.setID_News(rs.getInt("ID_News"));
                tt.setID_Types_of_news(rs.getInt("ID_Types_of_news"));
                tt.setName_News(rs.getString("Name_News"));
                tt.setTitle(rs.getString("title"));
                tt.setContent(rs.getString("content"));
                tt.setImage(rs.getString("image"));
                tt.setPublish_date(rs.getString("publish_date"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tt;
    }

    @Override
    public ArrayList<News> getListNewsNew() {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT TOP 8 * FROM News ORDER BY ID_News DESC;";
        ArrayList<News> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News News = new News();

                News.setID_News(rs.getInt("ID_News"));
                News.setID_Types_of_news(rs.getInt("ID_Types_of_news"));
                News.setName_News(rs.getString("Name_News"));
                News.setTitle(rs.getString("title"));
                News.setContent(rs.getString("content"));
                News.setImage(rs.getString("image"));
                News.setPublish_date(rs.getString("publish_date"));
                arr.add(News);
            }
            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return arr;
    }

    @Override
    public boolean insertNews(News newInsert) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO News (ID_Types_of_news, Name_News, title, content, image, publish_date) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, newInsert.getID_Types_of_news());
            ps.setString(2, newInsert.getName_News());
            ps.setString(3, newInsert.getTitle());
            ps.setString(4, newInsert.getContent());
            ps.setString(5, newInsert.getImage());
            ps.setString(6, newInsert.getPublish_date());

            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

//    @Override
//    public boolean insertNews(News newInsert) {
//        Connection connection = DBConnection.getConnection();
//        String sql = """
//                     INSERT INTO News ([Name_Product]
//                                ,[ID_Category]
//                                ,[image]
//                                ,[quantity]
//                                ,[unit_price]
//                                ,[discount]
//                                ,[display]
//                                ,[rear_camera]
//                                ,[front_camera]
//                                ,[operating_system]
//                                ,[cpu]
//                                ,[memory]
//                                ,[ram]
//                                ,[connectivity]
//                                ,[battery]
//                                ,[description]) VALUES(?,?,?,?,?,?)""";
//        try {
//            PreparedStatement ps = connection.prepareCall(sql);
//
//            ps.setInt(1, newInsert.getID_Types_of_news());
//            ps.setString(2, newInsert.getName_News());
//            ps.setString(3, newInsert.getTitle());
//            ps.setString(4, newInsert.getContent());
//            ps.setString(5, newInsert.getImage());
//            ps.setString(6, newInsert.getPublish_date());
//            System.out.println(ps);
//            return ps.executeUpdate() == 1;
//        } catch (SQLException ex) {
//            Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
    @Override
    public boolean updateNews(News newChange) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE News SET ID_Types_of_news=?,Name_News=?,"
                + "title=?,content=?,image=?,publish_date=? where ID_News=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, newChange.getID_Types_of_news());
            ps.setString(2, newChange.getName_News());
            ps.setString(3, newChange.getTitle());
            ps.setString(4, newChange.getContent());
            ps.setString(5, newChange.getImage());
            ps.setString(6, newChange.getPublish_date());
            ps.setInt(7, newChange.getID_News());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        // Tạo một đối tượng News để sử dụng trong phương thức updateNews()
        News newsToUpdate = new News(1, "News Name", "News Title", "News Content", "news_image.jpg", "2024-02-26");
        newsToUpdate.setID_News(10); // Đặt ID của tin tức cần cập nhật

        // Tạo một đối tượng NewsDAOImpl để thực hiện cập nhật
        NewsDAOImpl newsDAO = new NewsDAOImpl();

        // Gọi phương thức updateNews() để cập nhật tin tức
        boolean result = newsDAO.updateNews(newsToUpdate);

        // Kiểm tra kết quả của phương thức updateNews()
        if (result) {
            System.out.println("Cập nhật tin tức thành công!");
        } else {
            System.out.println("Cập nhật tin tức thất bại!");
        }
    }

    @Override
    public boolean deleteNews(int ID_News) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "delete from News where ID_News=?";

            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_News);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<News> getListNewsByPage(ArrayList<News> arr, int start, int end) {
        ArrayList<News> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

    @Override
    public boolean deleteNewsByIdOfTypesOfNews(int ID_Types_of_news) {
        Connection connection = DBConnection.getConnection();
        String sql = "delete from News Where ID_Types_of_news=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Types_of_news);
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
