/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAOImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Invoice;
import model.Account;

/**
 *
 * @author ACERR
 */
public class ChangeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command != null && command.equals("change")) {
//            HttpSession session = request.getSession();
//            String username = (String) session.getAttribute("username");

            request.getRequestDispatcher("/changeInfor.jsp").forward(request, response);
        }
    }

//         if (request.getParameter("command").equals("change")) {
//            String ID_Invoice = request.getParameter("ID_Account");
//            hdDao.get(Integer.parseInt(ID_Invoice));
//            Invoice hd = new Invoice();
//            
//            hd.setID_Invoice(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getID_Invoice());
//            hd.setID_Account(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getID_Account());
//            hd.setTotal_amount(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getTotal_amount());
//            hd.setDelivery_address(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getDelivery_address());
//            hd.setPayment_method(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getPayment_method());
//            hd.setPurchase_date(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getPurchase_date());
//            hd.setOrder_status(1);
//            hdDao.updateInvoice(hd);
//            RequestDispatcher rd= getServletContext().getRequestDispatcher("/admin/manager_bill.jsp");
//            rd.forward(request, response);
//        }
//}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    AccountDAOImpl AccountDAO = new AccountDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int ID_Account = Integer.parseInt(request.getParameter("ID_Account"));
        String TenAccount = request.getParameter("Name_Account");
        String TenDangNhap = request.getParameter("Login_Name");
        int Status = Integer.parseInt(request.getParameter("Status"));

        Account currentAccount = AccountDAO.getAccountByIDAccount(ID_Account);
        if (!TenAccount.equals(currentAccount.getName_Account())) {
            currentAccount.setName_Account(TenAccount);
        }
        if (!TenDangNhap.equals(currentAccount.getLogin_Name())) {
            currentAccount.setLogin_Name(TenDangNhap);
        }
        if (Status != currentAccount.getStatus()) {
            currentAccount.setStatus(Status);
        }

        AccountDAO.updateInfoAccount(currentAccount);

        HttpSession session = request.getSession();
        session.setAttribute("Name_Account", currentAccount.getName_Account());
        session.setAttribute("Login_Name", currentAccount.getLogin_Name());
        session.setAttribute("Status", currentAccount.getStatus());

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/infor.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
