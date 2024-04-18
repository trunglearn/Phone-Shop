/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoice;

/**
 *
 * @author ACERR
 */
public class InvoiceDAOImpl implements InvoiceDAO {
    
    @Override
    public void themInvoice(Invoice hd) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Invoice VALUES(?,?,?,?,?,?,?) ";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, hd.getID_Invoice());
        ps.setInt(2, hd.getID_Account());
        ps.setFloat(3, hd.getTotal_amount());
        ps.setString(4, hd.getDelivery_address());
        //ps.setString(5, hd.getPhone());
        ps.setString(5, hd.getPayment_method());
        ps.setString(6, hd.getPurchase_date());
        ps.setInt(7, hd.getOrder_status());
        
        ps.executeUpdate();
        
    }
    
    @Override
    public ArrayList<Invoice> getListInvoice() {
        Connection connection = DBConnection.getConnection();
        String sql = "Select * from Invoice";
        ArrayList<Invoice> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Invoice hd = new Invoice();
                hd.setID_Invoice(rs.getInt("ID_Invoice"));
                hd.setID_Account(rs.getInt("ID_Account"));
                hd.setTotal_amount(rs.getFloat("Total_amount"));
                hd.setDelivery_address(rs.getString("Delivery_address"));
//                hd.setPhone(rs.getString("Phone"));
                hd.setPayment_method(rs.getString("Payment_method"));
                hd.setPurchase_date(rs.getString("Purchase_date"));
                hd.setOrder_status(rs.getInt("Order_status"));
                
                list.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public ArrayList<Invoice> getListInvoiceByPage(ArrayList<Invoice> arr, int start, int end) {
        ArrayList<Invoice> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }
    
    @Override
    public Invoice getInvoice(int ID_Invoice) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from Invoice where ID_Invoice='" + ID_Invoice + "'";
        Invoice hd = new Invoice();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hd.setID_Invoice(rs.getInt("ID_Invoice"));
                hd.setID_Account(rs.getInt("ID_Account"));
                hd.setTotal_amount(rs.getFloat("Total_amount"));
                hd.setDelivery_address(rs.getString("Delivery_address"));
//                hd.setPhone(rs.getString("Phone"));
                hd.setPayment_method(rs.getString("Payment_method"));
                hd.setPurchase_date(rs.getString("Purchase_date"));
                hd.setOrder_status(rs.getInt("Order_status"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hd;
    }
    
//    public static void main(String[] args) throws SQLException {
//        InvoiceDAOImpl hd = new InvoiceDAOImpl();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//        String date = dateFormat.format(new Date());
////           hd.themInvoice(new Invoice(1,1, 1000, "date", "date",date,0));
////        System.out.println("Them hoa don thanh cong");
////        
//        System.out.println(hd.getInvoice(469172643).getID_Invoice() + "-" + hd.getInvoice(469172643).getTotal_amount());
//    }
    
//  public static void main(String[] args) {
//    InvoiceDAOImpl invoiceDAO = new InvoiceDAOImpl();
//    ArrayList<Invoice> invoiceList = invoiceDAO.getListInvoice();
//    
//    // Hiển thị thông tin của từng hóa đơn trong danh sách
//    for (Invoice invoice : invoiceList) {
//        System.out.println("ID Invoice: " + invoice.getID_Invoice());
//        System.out.println("ID Account: " + invoice.getID_Account());
//        System.out.println("Total amount: " + invoice.getTotal_amount());
//        System.out.println("Delivery address: " + invoice.getDelivery_address());
//        System.out.println("Payment method: " + invoice.getPayment_method());
//        System.out.println("Purchase date: " + invoice.getPurchase_date());
//        System.out.println("Order status: " + invoice.getOrder_status());
//        System.out.println("---------------------------------------------");
//    }
//}

public static void main(String[] args) {
    InvoiceDAOImpl hd = new InvoiceDAOImpl();
    try {
        // Tạo một đối tượng Invoice mới để thêm vào cơ sở dữ liệu
        Invoice newInvoice = new Invoice();
        newInvoice.setID_Invoice(1); // ID hóa đơn
        newInvoice.setID_Account(1); // ID tài khoản
        newInvoice.setTotal_amount(1000); // Tổng số tiền
        newInvoice.setDelivery_address("Địa chỉ giao hàng"); // Địa chỉ giao hàng
        newInvoice.setPayment_method("Thanh toán khi nhận hàng"); // Phương thức thanh toán
        newInvoice.setPurchase_date("2024-02-19"); // Ngày mua
        newInvoice.setOrder_status(0); // Tình trạng đơn hàng
        
        // Gọi phương thức để thêm hóa đơn vào cơ sở dữ liệu
        hd.themInvoice(newInvoice);
        System.out.println("Thêm hóa đơn thành công!");
    } catch (SQLException ex) {
        System.out.println("Lỗi khi thêm hóa đơn: " + ex.getMessage());
    }
}

    
    @Override
    public boolean updateInvoice(Invoice Invoice) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Invoice set ID_Account=?,Total_amount=?,Delivery_address=?,Phone=?,Payment_method=?,"
                + "Purchase_date=?,Order_status=? where ID_Invoice=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, Invoice.getID_Account());
            ps.setFloat(2, Invoice.getTotal_amount());
            ps.setString(3, Invoice.getDelivery_address());
            ps.setString(4, Invoice.getPayment_method());
            ps.setString(5, Invoice.getPurchase_date());
            ps.setInt(6, Invoice.getOrder_status());
            ps.setInt(7, Invoice.getID_Invoice());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
