/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACERR
 */
public class TypesOfNews {
    private int ID_Types_of_news;
    private String Name_Types_of_news;

    public TypesOfNews() {
    }

    public TypesOfNews(int ID_Types_of_news, String Name_Types_of_news) {
        this.ID_Types_of_news = ID_Types_of_news;
        this.Name_Types_of_news = Name_Types_of_news;
    }

    public TypesOfNews(String Name_Types_of_news) {
        this.Name_Types_of_news = Name_Types_of_news;
    }



    public int getID_Types_of_news() {
        return ID_Types_of_news;
    }

    public void setID_Types_of_news(int ID_Types_of_news) {
        this.ID_Types_of_news = ID_Types_of_news;
    }

    public String getName_Types_of_news() {
        return Name_Types_of_news;
    }

    public void setName_Types_of_news(String Name_Types_of_news) {
        this.Name_Types_of_news = Name_Types_of_news;
    }
    
}
