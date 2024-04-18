/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author ACERR
 */
public class UpdateCategoryServlet extends HttpServlet {
    CategoryDAOImpl CategoryDAO= new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ten_danh_muc = request.getParameter("Name_Category");
        String ID_Category = request.getParameter("ID_Category");
        String url="",erro="";
         if(ten_danh_muc.equals(""))
         {
             erro="Ban phai nhap ten danh muc";
         }
         //CategoryDAO.updateCategory(new Category(Integer.parseInt(ID_Category),ten_danh_muc));
         CategoryDAO.updateCategory(new Category(Integer.parseInt(ID_Category),ten_danh_muc));
         url="/admin/manager_category.jsp";
         RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
         rd.forward(request, response);
          
    }

}
