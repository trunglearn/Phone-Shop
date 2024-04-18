/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACERR
 */
public class Account {

    private int ID_Account;
    private String Name_Account;
    private String Login_Name;
    private String password;
    private int access_rights;
    private int status;

    public Account() {
    }

    public Account(String Name_Account, String Login_Name, String password, int access_rights) {
        this.Name_Account = Name_Account;
        this.Login_Name = Login_Name;
        this.password = password;
        this.access_rights = access_rights;
    }

    public Account(int ID_Account, String Name_Account, String Login_Name, String password, int access_rights) {
        this.ID_Account = ID_Account;
        this.Name_Account = Name_Account;
        this.Login_Name = Login_Name;
        this.password = password;
        this.access_rights = access_rights;
    }

    public int getID_Account() {
        return ID_Account;
    }

    public void setID_Account(int ID_Account) {
        this.ID_Account = ID_Account;
    }

    public String getName_Account() {
        return Name_Account;
    }

    public void setName_Account(String Name_Account) {
        this.Name_Account = Name_Account;
    }

    public String getLogin_Name() {
        return Login_Name;
    }

    public void setLogin_Name(String Login_Name) {
        this.Login_Name = Login_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccess_rights() {
        return access_rights;
    }

    public void setAccess_rights(int access_rights) {
        this.access_rights = access_rights;
    }

}
