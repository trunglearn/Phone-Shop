/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TypesOfNewsDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TypesOfNews;

/**
 *
 * @author ACERR
 */
public class UpLoadTypeNewServlet extends HttpServlet {
    TypesOfNewsDAOImpl TypesOfNewsDAO= new TypesOfNewsDAOImpl();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("/admin/insert_typenews.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Name_Types_of_news=request.getParameter("TenTypesOfNews");
        TypesOfNewsDAO.insertTypesOfNews(new TypesOfNews(Name_Types_of_news));
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/admin/manager_typenew.jsp");
        rd.forward(request, response);
        
        
    }

   }
