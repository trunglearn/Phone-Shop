/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.DBConnection;
import helpers.EncodePass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author ACERR
 */
public class AccountDAOImpl implements AccountDAO {

    @Override
    public ArrayList<Account> getListAccount() {
        Connection connection = DBConnection.getConnection();
        String sql = "Select * from Account";
        ArrayList<Account> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account tk = new Account();
                tk.setID_Account(rs.getInt("ID_Account"));
                tk.setName_Account(rs.getString("Name_Account"));
                tk.setLogin_Name(rs.getString("Login_Name"));
                tk.setPassword(rs.getString("Password"));
                tk.setAccess_rights(rs.getInt("Access_rights"));

                arr.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;

    }

    @Override
//    public boolean checkAccount(String login) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        Connection connection = DBConnection.getConnection();
//        String sql = "select [Name_Account] from [Account] where Login_Name='" + login + "'";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return true;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//
//    }

    public boolean checkAccount(String login) {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT Login_Name FROM Account WHERE Login_Name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Trả về true nếu có kết quả
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void insertAccount(Account tk) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO [Account] (Name_Account, Login_Name, password, access_rights) VALUES(?,?,?,?)";

        try {
//          PreparedStatement ps = connection.prepareCall(sql);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tk.getName_Account());
            ps.setString(2, tk.getLogin_Name());
            ps.setString(3, tk.getPassword());
            ps.setInt(4, tk.getAccess_rights());

            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean checkLogin(String login, String password) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from [Account] where Login_Name='" + login + "'and password='" + password + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Account getAccount(String login) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from [Account] where Login_Name='" + login + "'";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account tk = new Account();
                tk.setID_Account(rs.getInt("ID_Account"));
                tk.setAccess_rights(rs.getInt("access_rights"));
                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Account getAccountByIDAccount(int ID_Account) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from [Account] where ID_Account='" + ID_Account + "'";
        Account tk = new Account();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk.setID_Account(rs.getInt("ID_Account"));
                tk.setName_Account(rs.getString("Name_Account"));
                tk.setLogin_Name(rs.getString("Login_Name"));
                tk.setPassword(rs.getString("password"));
                tk.setAccess_rights(rs.getInt("access_rights"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tk;
    }

    @Override
    public boolean deleteAccount(int ID_Account) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "delete from Account where ID_Account=?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Account);
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateAccount(Account tk) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Account SET Name_Account=?,"
                + "Login_Name=?,Password=?,Access_rights=? where ID_Account=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, tk.getName_Account());
            ps.setString(2, tk.getLogin_Name());
            //ps.setString(3, EncodePass.toSHA1(tk.getPassword()));
            ps.setString(3, tk.getPassword());
            ps.setInt(4, tk.getAccess_rights());
            ps.setInt(5, tk.getID_Account());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Account> getListAccountByPage(ArrayList<Account> arr, int start, int end) {
        ArrayList<Account> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

    @Override
    public Account getInfoAccount(String login) {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Account WHERE Login_Name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account tk = new Account();
                tk.setID_Account(rs.getInt("ID_Account"));
                tk.setName_Account(rs.getString("Name_Account"));
                tk.setLogin_Name(rs.getString("Login_Name"));
                tk.setPassword(rs.getString("password"));
                tk.setAccess_rights(rs.getInt("access_rights"));
                tk.setStatus(rs.getInt("status")); // Assuming status is an int
                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean updateInfoAccount(Account tk) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Account SET Name_Account=?,"
                + "Login_Name=?,status=? where ID_Account=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, tk.getName_Account());
            ps.setString(2, tk.getLogin_Name());
            ps.setInt(3, tk.getStatus());
            ps.setInt(4, tk.getID_Account());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
