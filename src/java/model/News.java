/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACERR
 */
public class News {

    private int ID_News;
    private int ID_Types_of_news;
    private String Name_News;
    private String title;
    private String content;
    private String image;
    private String publish_date;

    public News() {
    }

    public News(int ID_Types_of_news, String Name_News, String title, String content, String image, String publish_date) {

        this.ID_Types_of_news = ID_Types_of_news;
        this.Name_News = Name_News;
        this.title = title;
        this.content = content;
        this.image = image;
        this.publish_date = publish_date;
    }

    public News(int ID_News, int ID_Types_of_news, String Name_News, String title, String content, String image, String publish_date) {
        this.ID_News = ID_News;
        this.ID_Types_of_news = ID_Types_of_news;
        this.Name_News = Name_News;
        this.title = title;
        this.content = content;
        this.image = image;
        this.publish_date = publish_date;
    }

    public News(String news_Name, String news_Title, String news_Content, String news_imagejpg, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getID_News() {
        return ID_News;
    }

    public void setID_News(int ID_News) {
        this.ID_News = ID_News;
    }

    public int getID_Types_of_news() {
        return ID_Types_of_news;
    }

    public void setID_Types_of_news(int ID_Types_of_news) {
        this.ID_Types_of_news = ID_Types_of_news;
    }

    public String getName_News() {
        return Name_News;
    }

    public void setName_News(String Name_News) {
        this.Name_News = Name_News;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

}
