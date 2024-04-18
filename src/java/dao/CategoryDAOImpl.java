/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Category;
import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACERR
 */
public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public ArrayList<Category> getListCategory() {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from Category";
        ArrayList<Category> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category dm = new Category();
                dm.setID_Category(rs.getInt("ID_Category"));
                dm.setName_Category(rs.getString("Name_Category"));
                arr.add(dm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public Category getCategory(int ID_Category) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM Category WHERE ID_Category=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Category);

            ResultSet rs = ps.executeQuery();

            Category dm = new Category();
            while (rs.next()) {
                dm.setName_Category(rs.getString("Name_Category"));

            }
            return dm;

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insertCategory(Category category) {

        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Category VALUES(?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, category.getName_Category());

            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Category SET Name_Category=? where ID_Category=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, category.getName_Category());

            ps.setInt(2, category.getID_Category());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int ID_Category) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "delete from Category where ID_Category=?";

            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Category);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Category> getListCategoryByPage(ArrayList<Category> arr, int start, int end) {
        ArrayList<Category> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

}
