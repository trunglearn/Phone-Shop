/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.DBConnection;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import model.DetailsOfInvoiceItems;

/**
 *
 * @author ACERR
 */
public class DetailsOfInvoiceItemsDAOImpl implements DetailsOfInvoiceItemsDAO {

    @Override
    public void insertDetailsOfInvoiceItems(DetailsOfInvoiceItems cthd) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Details_of_invoice_items (ID_Invoice, ID_Product, Quantity, Unit_Price, Discount, Total_Amount) values(?,?,?,?,?,?)";

        //String sql = "INSERT INTO DetailsOfInvoiceItems (ID_Invoice, ID_Product, Quantity, Unit_Price, Discount, Total_Amount) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        // ps.setInt(1,db.getBilldetail_id());

        ps.setInt(1, cthd.getID_Invoice());
        ps.setInt(2, cthd.getID_Product());
        ps.setFloat(3, cthd.getQuantity());
        ps.setDouble(4, cthd.getUnit_price());
        ps.setDouble(5, cthd.getDiscount());
        ps.setDouble(6, cthd.getTotal_amount());
        ps.executeUpdate();
    }

    @Override
    public ArrayList<DetailsOfInvoiceItems> getListDetailsOfInvoiceItemsByIDInvoice(int IDInvoice) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from Details_of_invoice_items where ID_Invoice='" + IDInvoice + "'";
        ArrayList<DetailsOfInvoiceItems> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetailsOfInvoiceItems cthd = new DetailsOfInvoiceItems();
                cthd.setID_Details_of_invoice_items(rs.getInt("ID_Details_of_invoice_items"));
                cthd.setID_Invoice(rs.getInt("ID_Invoice"));
                cthd.setID_Product(rs.getInt("ID_Product"));
                cthd.setQuantity(rs.getInt("quantity"));
                cthd.setUnit_price(rs.getLong("unit_price"));
                cthd.setDiscount(rs.getInt("discount"));
                cthd.setTotal_amount(rs.getInt("total_amount"));
                arr.add(cthd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetailsOfInvoiceItemsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public static void main(String[] args) {
        // Creating an instance of DetailsOfInvoiceItems
        DetailsOfInvoiceItems cthd = new DetailsOfInvoiceItems();

        // Setting sample data
        cthd.setID_Invoice(1);
        cthd.setID_Product(1001);
        cthd.setQuantity(5);
        cthd.setUnit_price(10.50);
        cthd.setDiscount(2.50);
        cthd.setTotal_amount(45.0); // Assuming total amount is calculated correctly

        // Creating an instance of DetailsOfInvoiceItemsDAOImpl
        DetailsOfInvoiceItemsDAOImpl dao = new DetailsOfInvoiceItemsDAOImpl();

        try {
            // Inserting the DetailsOfInvoiceItems
            dao.insertDetailsOfInvoiceItems(cthd);
            System.out.println("Details of Invoice Items inserted successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
