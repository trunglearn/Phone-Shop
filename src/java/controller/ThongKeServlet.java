package controller;

import dao.StatisticalDAOImpl;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.Value;

public class ThongKeServlet extends HttpServlet {

    StatisticalDAOImpl tkDAO = new StatisticalDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Value> lisItem = tkDAO.getAll();
        if (lisItem == null || lisItem.isEmpty()) {
            request.setAttribute("errorMessage", "Không có dữ liệu thống kê.");
        } else {
            request.setAttribute("lisItem", lisItem); // Use consistent attribute name
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_chart.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");
        String[] categoryIds = request.getParameterValues("category");
        String startDateString = request.getParameter("startDate");
        String endDateString = request.getParameter("endDate");

        Date startDate = null;
        Date endDate = null;

        // Convert string to Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = dateFormat.parse(startDateString);
            endDate = dateFormat.parse(endDateString);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parse exception
        }

        // Convert array to List
        List<String> categoryIdList = categoryIds != null ? Arrays.asList(categoryIds) : new ArrayList<>();

        List<Value> lisItem = tkDAO.searchProductsByCriteria(searchTerm, categoryIdList, startDate, endDate);

        request.setAttribute("lisItem1", lisItem); // Correct attribute name
        RequestDispatcher rd = request.getRequestDispatcher("/admin/manager_chart.jsp"); // Corrected JSP path
        rd.forward(request, response);
    }
}
