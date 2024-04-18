/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import utils.UploadFileUtils;

/**
 *
 * @author ACERR
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class UpdateProductServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
       String MaProduct=request.getParameter("ID_Product");
        String Name_Product = request.getParameter("Name_Product");
      
        int ID_Category = Integer.parseInt(request.getParameter("ID_Category"));
          
         String image = UploadFileUtils.UploadFile(request);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int unit_price = Integer.parseInt(request.getParameter("unit_price")); 
        int discount =Integer.parseInt(request.getParameter("discount"));
        String display=request.getParameter("display");
        String rear_camera=request.getParameter("rear_camera");
        String front_camera=request.getParameter("front_camera");
        String operating_system=request.getParameter("operating_system");
        String cpu=request.getParameter("cpu");
        String memory=request.getParameter("memory");
        String ram=request.getParameter("ram");
        String connectivity=request.getParameter("connectivity");
        String battery=request.getParameter("battery");
       // String BaoHanh=request.getParameter("BaoHanh");
        String description=request.getParameter("description");
        ProductDAOImpl ProductDAO= new ProductDAOImpl();
       // ProductDAO.updateProduct(new Product(Integer.parseInt(MaProduct), Name_Product,ID_Category,image, quantity, unit_price, discount, display, rear_camera, front_camera, operating_system, cpu, memory, ram, connectivity, battery,BaoHanh, description));
        ProductDAO.updateProduct(new Product(Integer.parseInt(MaProduct), Name_Product,ID_Category,image, quantity, unit_price, discount, display, rear_camera, front_camera, operating_system, cpu, memory, ram, connectivity, battery,description));
          request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response);
       
    }

   

}
