/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import model.TypesOfNews;
/**
 *
 * @author ACERR
 */
public interface TypesOfNewsDAO {

    public ArrayList<TypesOfNews> getListTypesOfNews();

    public TypesOfNews getTypesOfNews(int ID_Types_of_news);

    boolean insertTypesOfNews(TypesOfNews typeNew);

    boolean updateTypesOfNews(TypesOfNews typeNew);

    boolean deleteTypesOfNews(int ID_Types_of_news);

    public ArrayList<TypesOfNews> getListTypesOfNewsByPage(ArrayList<TypesOfNews> arr, int start, int end);
}
