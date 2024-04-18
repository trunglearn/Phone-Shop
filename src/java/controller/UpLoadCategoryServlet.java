/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class UpLoadCategoryServlet extends HttpServlet {

    private CategoryDAOImpl CategoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String TenCategory = request.getParameter("Name_Category");

        String url = "/admin/manager_category.jsp";
        String erro = "";
        if (TenCategory.equals("")) {
            erro = "Bạn phải nhập tên danh mục";

        }
        if (erro.length() > 0) {
            request.setAttribute("erro", erro);
        }
        try {
            if (erro.length() == 0) {

                CategoryDAO.insertCategory(new Category(TenCategory));
                url = "/admin/manager_category.jsp";

            } else {
                url = "/admin/insert_category.jsp";

            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
        }

    }

}
