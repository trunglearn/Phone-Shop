/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author ACERR
 */
public class SearchServlet extends HttpServlet {

    private ProductDAOImpl productDAO = new ProductDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("Name_Product");
        String[] categoryIds = request.getParameterValues("category");
        String priceSort = request.getParameter("sortPrice");

        List<Integer> categories = new ArrayList<>();
        if (categoryIds != null) {
            for (String id : categoryIds) {
                categories.add(Integer.valueOf(id));
            }
        }

        List<Product> productList = productDAO.getProductsByNameAndCategories(name, categories, priceSort);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("Name_Product");
        String[] categoryIds = request.getParameterValues("category");
        String priceSort = request.getParameter("sortPrice");

        List<Integer> categories = new ArrayList<>();
        if (categoryIds != null) {
            for (String id : categoryIds) {
                categories.add(Integer.valueOf(id));
            }
        }

        List<Product> productList = productDAO.getProductsByNameAndCategories(name, categories, priceSort);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchView.jsp");
        dispatcher.forward(request, response);
    }

}
