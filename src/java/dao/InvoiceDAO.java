/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Invoice;

/**
 *
 * @author ACERR
 */
public interface InvoiceDAO {

    public void themInvoice(Invoice hd) throws SQLException;

    public ArrayList<Invoice> getListInvoice();

    public ArrayList<Invoice> getListInvoiceByPage(ArrayList<Invoice> arr, int start, int end);

    public Invoice getInvoice(int ID_Invoice);

    public boolean updateInvoice(Invoice Invoice);

}
