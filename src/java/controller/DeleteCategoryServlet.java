/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ACERR
 */
public class DeleteCategoryServlet extends HttpServlet {

    CategoryDAOImpl CategoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msgDelete = "";
        int ID_Category = Integer.parseInt(request.getParameter("ID_Category"));
        if (CategoryDAO.deleteCategory(ID_Category)) {
            msgDelete = "Xoa thanh cong!";
            request.setAttribute("msgDelete", msgDelete);

        } else {
            msgDelete = "Ban can xoa het san pham thuoc danh muc nay!";
            request.setAttribute("msgDelete", msgDelete);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_category.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
