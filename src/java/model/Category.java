/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACERR
 */
public class Category {
    private int ID_Category;
    private String Name_Category;

    public Category() {
    }

    public Category(String Name_Category) {
        this.Name_Category = Name_Category;

    }

    
    public Category(int ID_Category, String Name_Category) {
        this.ID_Category = ID_Category;
        this.Name_Category = Name_Category;
    }

    public int getID_Category() {
        return ID_Category;
    }

    public void setID_Category(int ID_Category) {
        this.ID_Category = ID_Category;
    }

    public String getName_Category() {
        return Name_Category;
    }

    public void setName_Category(String Name_Category) {
        this.Name_Category = Name_Category;
    }
    
    
}
