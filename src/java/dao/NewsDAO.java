/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.News;

/**
 *
 * @author ACERR
 */
public interface NewsDAO {

    public ArrayList<News> getListNews();

    public ArrayList<News> getListNewsByType(int ID_Types_of_news);

    public News getListNewsByID(int ID_News);

    public ArrayList<News> getListNewsNew();

    public boolean insertNews(News newInsert);

    public boolean updateNews(News newChange);

    public boolean deleteNews(int ID_News);

    public ArrayList<News> getListNewsByPage(ArrayList<News> arr, int start, int end);

    public boolean deleteNewsByIdOfTypesOfNews(int ID_Types_of_news);
}
