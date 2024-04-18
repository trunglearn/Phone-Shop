/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import model.Category;
import model.Product;
import utils.UploadFileUtils;

/**
 *
 * @author ACERR
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class UpLoadProduct extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String Name_Product = request.getParameter("Name_Product");
        System.out.println(Name_Product);
        int ID_Category = Integer.parseInt(request.getParameter("ID_Category"));
        
        String image = UploadFileUtils.UploadFile(request);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int unit_price = Integer.parseInt(request.getParameter("unit_price"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        String display = request.getParameter("display");
        String rear_camera = request.getParameter("rear_camera");
        String front_camera = request.getParameter("front_camera");
        String operating_system = request.getParameter("operating_system");
        String cpu = request.getParameter("cpu");
        String memory = request.getParameter("memory");
        String ram = request.getParameter("ram");
        String connectivity = request.getParameter("connectivity");
        String battery = request.getParameter("battery");
        String description = request.getParameter("description");
        
        //Product san_pham = new Product(discount, Name_Product, ID_Category, image, quantity, unit_price, discount, display, rear_camera, front_camera, operating_system, cpu, memory, ram, connectivity, battery, description);
        Product san_pham = new Product(Name_Product, ID_Category, image, quantity,
                unit_price, discount, display, rear_camera, front_camera, operating_system, 
                cpu, memory, ram, connectivity, battery, description);
         ProductDAOImpl sanPhamDAO= new ProductDAOImpl();
        boolean returnCode = sanPhamDAO.insertProduct(san_pham);
        if (returnCode) {
            request.setAttribute("msgInsert", "Thêm sảm phẩm thành công!");
        } else {
            request.setAttribute("msgInsert", "Thêm sảm phẩm thất bại");
        }
        request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response);
    }
//     public static void main(String[] args) {
//        try {
//            URL url = new URL("http://localhost:9999/PRJ301/UpLoadProduct"); // Thay đổi URL theo nơi triển khai của ứng dụng của bạn
//            
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            conn.setDoOutput(true);
//            
//            String data = URLEncoder.encode("Name_Product", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("Tên sản phẩm", StandardCharsets.UTF_8)
//                        + "&" + URLEncoder.encode("ID_Category", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8) // Thay đổi ID_Category theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("quantity", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("10", StandardCharsets.UTF_8) // Thay đổi quantity theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("unit_price", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1000", StandardCharsets.UTF_8) // Thay đổi unit_price theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("discount", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0", StandardCharsets.UTF_8) // Thay đổi discount theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("display", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("LCD", StandardCharsets.UTF_8) // Thay đổi display theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("rear_camera", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("12 MP", StandardCharsets.UTF_8) // Thay đổi rear_camera theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("front_camera", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("8 MP", StandardCharsets.UTF_8) // Thay đổi front_camera theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("operating_system", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("Android", StandardCharsets.UTF_8) // Thay đổi operating_system theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("cpu", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("Snapdragon 865", StandardCharsets.UTF_8) // Thay đổi cpu theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("memory", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("256 GB", StandardCharsets.UTF_8) // Thay đổi memory theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("ram", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("8 GB", StandardCharsets.UTF_8) // Thay đổi ram theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("connectivity", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("4G", StandardCharsets.UTF_8) // Thay đổi connectivity theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("battery", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("5000 mAh", StandardCharsets.UTF_8) // Thay đổi battery theo yêu cầu của bạn
//                        + "&" + URLEncoder.encode("description", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("Mô tả sản phẩm", StandardCharsets.UTF_8); // Thay đổi description theo yêu cầu của bạn
//            
//            byte[] postData = data.getBytes(StandardCharsets.UTF_8);
//            conn.setRequestProperty("Content-Length", String.valueOf(postData.length));
//            
//            try (OutputStream os = conn.getOutputStream()) {
//                os.write(postData);
//            }
//            
//            int responseCode = conn.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//            
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
//                    String inputLine;
//                    StringBuilder response = new StringBuilder();
//                    while ((inputLine = in.readLine()) != null) {
//                        response.append(inputLine);
//                    }
//                    System.out.println(response.toString());
//                }
//            }
//            
//            conn.disconnect();
//            
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
