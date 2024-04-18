/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACERR
 */
public class DetailsOfInvoiceItems {

    private int ID_Details_of_invoice_items;
    private int ID_Invoice;
    private int ID_Product;
    private int quantity;
    private double unit_price;
    private double discount;
    private double total_amount;

    public DetailsOfInvoiceItems() {
    }

    public DetailsOfInvoiceItems(int ID_Invoice, int ID_Product, int quantity, double unit_price, double discount, double total_amount) {
        this.ID_Invoice = ID_Invoice;
        this.ID_Product = ID_Product;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.discount = discount;
        this.total_amount = total_amount;
    }

    public int getID_Details_of_invoice_items() {
        return ID_Details_of_invoice_items;
    }

    public void setID_Details_of_invoice_items(int ID_Details_of_invoice_items) {
        this.ID_Details_of_invoice_items = ID_Details_of_invoice_items;
    }

    public int getID_Invoice() {
        return ID_Invoice;
    }

    public void setID_Invoice(int ID_Invoice) {
        this.ID_Invoice = ID_Invoice;
    }

    public int getID_Product() {
        return ID_Product;
    }

    public void setID_Product(int ID_Product) {
        this.ID_Product = ID_Product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
    
    
}
