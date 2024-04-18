/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.TypesOfNews;
import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TypesOfNews;

/**
 *
 * @author ACERR
 */
public class TypesOfNewsDAOImpl implements TypesOfNewsDAO {

    @Override
    public ArrayList<TypesOfNews> getListTypesOfNews() {
        Connection connection = DBConnection.getConnection();
        String sql = "Select * from Types_of_news";
        ArrayList<TypesOfNews> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TypesOfNews typesOfNews = new TypesOfNews();
                typesOfNews.setID_Types_of_news(rs.getInt("ID_Types_of_news"));
                typesOfNews.setName_Types_of_news(rs.getString("Name_Types_of_news"));
                list.add(typesOfNews);

            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(TypesOfNewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public TypesOfNews getTypesOfNews(int ID_Types_of_news) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM Types_of_news WHERE ID_Types_of_news=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Types_of_news);

            ResultSet rs = ps.executeQuery();

            TypesOfNews TypesOfNews = new TypesOfNews();
            while (rs.next()) {
                TypesOfNews.setName_Types_of_news(rs.getString("Name_Types_of_news"));

            }
            return TypesOfNews;

        } catch (SQLException ex) {
            Logger.getLogger(TypesOfNewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insertTypesOfNews(TypesOfNews typeNew) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Types_of_news VALUES(?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1,  typeNew.getName_Types_of_news());

            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(TypesOfNewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateTypesOfNews(TypesOfNews typeNew) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Types_of_news SET Name_Types_of_news=? where ID_Types_of_news=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, typeNew.getName_Types_of_news());

            ps.setInt(2, typeNew.getID_Types_of_news());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(TypesOfNewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteTypesOfNews(int ID_Types_of_news) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "delete from Types_of_news where ID_Types_of_news=?";

            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Types_of_news);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(TypesOfNewsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<TypesOfNews> getListTypesOfNewsByPage(ArrayList<TypesOfNews> arr, int start, int end) {
        ArrayList<TypesOfNews> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

}
