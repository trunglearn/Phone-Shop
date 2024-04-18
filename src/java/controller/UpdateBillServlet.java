/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.InvoiceDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Invoice;

/**
 *
 * @author ACERR
 */
public class UpdateBillServlet extends HttpServlet {

    InvoiceDAOImpl hdDao = new InvoiceDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("command").equals("update")) {
            String ID_Invoice = request.getParameter("ID_Invoice");
            hdDao.getInvoice(Integer.parseInt(ID_Invoice));
            Invoice hd = new Invoice();
            hd.setID_Invoice(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getID_Invoice());
            hd.setID_Account(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getID_Account());
            hd.setTotal_amount(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getTotal_amount());
            hd.setDelivery_address(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getDelivery_address());
            hd.setPayment_method(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getPayment_method());
            hd.setPurchase_date(hdDao.getInvoice(Integer.parseInt(ID_Invoice)).getPurchase_date());
            hd.setOrder_status(1);
            hdDao.updateInvoice(hd);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/admin/update_Bill.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
