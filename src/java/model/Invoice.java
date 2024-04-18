/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACERR
 */
public class Invoice {

    private int ID_Invoice;
    private int ID_Account;
    private float total_amount;
    private String delivery_address;
    private String payment_method;
    private String purchase_date;
    private int order_status;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Invoice() {
    }

    public Invoice(int ID_Account, float total_amount, String delivery_address, String payment_method, String purchase_date, int order_status) {

        this.ID_Account = ID_Account;
        this.total_amount = total_amount;
        this.delivery_address = delivery_address;
        this.payment_method = payment_method;
        this.purchase_date = purchase_date;
        this.order_status = order_status;
    }

    public Invoice(int ID_Invoice, int ID_Account, float total_amount, String delivery_address, String payment_method, String purchase_date, int order_status) {
        this.ID_Invoice = ID_Invoice;
        this.ID_Account = ID_Account;
        this.total_amount = total_amount;
        this.delivery_address = delivery_address;
        this.payment_method = payment_method;
        this.purchase_date = purchase_date;
        this.order_status = order_status;
    }
    
    

    public int getID_Invoice() {
        return ID_Invoice;
    }

    public void setID_Invoice(int ID_Invoice) {
        this.ID_Invoice = ID_Invoice;
    }

    public int getID_Account() {
        return ID_Account;
    }

    public void setID_Account(int ID_Account) {
        this.ID_Account = ID_Account;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
    
    

}
