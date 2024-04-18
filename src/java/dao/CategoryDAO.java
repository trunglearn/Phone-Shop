/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Category;

/**
 *
 * @author ACERR
 */
public interface CategoryDAO {

    // load tat ca cac danh muc
    ArrayList<Category> getListCategory();

    // load dnah muc dua vao ma dnah muc
    Category getCategory(int ID_Category);

    // insert danh muc
    boolean insertCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(int ID_Category);

    public ArrayList<Category> getListCategoryByPage(ArrayList<Category> arr, int start, int end);
}
