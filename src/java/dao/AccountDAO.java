/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Account;

/**
 *
 * @author ACERR
 */
public interface AccountDAO {
    //lay danh sach tai khoan
    public ArrayList<Account> getListAccount();
    // kiem tra tai khoan xem da ton tai chua
    public boolean checkAccount(String login);
    // insert tai khoan moi
    public void insertAccount(Account tk);
    // update tai khoan moi
    public boolean updateInfoAccount(Account tk);
    //kiem tra dang nhap.
    public boolean checkLogin(String login, String password);
    // lay tai khoan
    public Account getAccount(String login);
    //Lay thong tin cho user
    public Account getInfoAccount(String login);
    // lay thong tin tai khan By ma
    public Account getAccountByIDAccount(int ID_Account);
    // delete tai khoan
    public boolean deleteAccount(int ID_Account);
    //update tai khoan
    public boolean updateAccount(Account Account);
    public ArrayList<Account> getListAccountByPage(ArrayList<Account> arr, int start, int end);
}
