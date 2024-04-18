/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DetailsOfInvoiceItems;
/**
 *
 * @author ACERR
 */
public interface DetailsOfInvoiceItemsDAO {

    public void insertDetailsOfInvoiceItems(DetailsOfInvoiceItems cthd) throws SQLException;

    public ArrayList<DetailsOfInvoiceItems> getListDetailsOfInvoiceItemsByIDInvoice(int IDInvoice);

}
