/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACERR
 */
public class Product implements Comparable<Product> {

    private int ID_Product;
    private String Name_Product;
    private int ID_Category;
    private String image;
    private int quantity;
    private double unit_price;
    private double discount;
    private String display;
    private String rear_camera;
    private String front_camera;
    private String operating_system;
    private String cpu;
    private String memory;
    private String ram;
    private String connectivity;
    private String battery;
//    private String bao_hanh;
    private String description;
    private int totalQuantitySold;

    public int getTotalQuantitySold() {
        return totalQuantitySold;
    }

    public void setTotalQuantitySold(int totalQuantitySold) {
        this.totalQuantitySold = totalQuantitySold;
    }

    public Product() {
    }

//    public Product(String Name_Product, int ID_Category, String image, int quantity, double unit_price, double discount, String display, String rear_camera, String front_camera, String operating_system, String cpu, String memory, String ram, String connectivity, String battery, String bao_hanh, String description) {
//        this.Name_Product = Name_Product;
//        this.ID_Category = ID_Category;
//        this.image = image;
//        this.quantity = quantity;
//        this.unit_price = unit_price;
//        this.discount = discount;
//        this.display = display;
//        this.rear_camera = rear_camera;
//        this.front_camera = front_camera;
//        this.operating_system = operating_system;
//        this.cpu = cpu;
//        this.memory = memory;
//        this.ram = ram;
//        this.connectivity = connectivity;
//        this.battery = battery;
//        this.bao_hanh = bao_hanh;
//        this.description = description;
//    }
    public Product(int ID_Product, String Name_Product, int ID_Category, String image, int quantity,
            double unit_price, double discount, String display, String rear_camera, String front_camera,
            String operating_system, String cpu, String memory, String ram, String connectivity, String battery,
            String description) {
        this.ID_Product = ID_Product;
        this.Name_Product = Name_Product;
        this.ID_Category = ID_Category;
        this.image = image;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.discount = discount;
        this.display = display;
        this.rear_camera = rear_camera;
        this.front_camera = front_camera;
        this.operating_system = operating_system;
        this.cpu = cpu;
        this.memory = memory;
        this.ram = ram;
        this.connectivity = connectivity;
        this.battery = battery;
        this.description = description;
    }

    public Product(String Name_Product, int ID_Category, String image, int quantity, double unit_price, double discount, String display, String rear_camera, String front_camera, String operating_system, String cpu, String memory, String ram, String connectivity, String battery, String description) {
        this.Name_Product = Name_Product;
        this.ID_Category = ID_Category;
        this.image = image;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.discount = discount;
        this.display = display;
        this.rear_camera = rear_camera;
        this.front_camera = front_camera;
        this.operating_system = operating_system;
        this.cpu = cpu;
        this.memory = memory;
        this.ram = ram;
        this.connectivity = connectivity;
        this.battery = battery;
        this.description = description;
    }

    public int getID_Product() {
        return ID_Product;
    }

    public void setID_Product(int ID_Product) {
        this.ID_Product = ID_Product;
    }

//    public String getBao_hanh() {
//        return bao_hanh;
//    }
//
//    public void setBao_hanh(String bao_hanh) {
//        this.bao_hanh = bao_hanh;
//    }
    public String getName_Product() {
        return Name_Product;
    }

    public void setName_Product(String Name_Product) {
        this.Name_Product = Name_Product;
    }

    public int getID_Category() {
        return ID_Category;
    }

    public void setID_Category(int ID_Category) {
        this.ID_Category = ID_Category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getRear_camera() {
        return rear_camera;
    }

    public void setRear_camera(String rear_camera) {
        this.rear_camera = rear_camera;
    }

    public String getFront_camera() {
        return front_camera;
    }

    public void setFront_camera(String front_camera) {
        this.front_camera = front_camera;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Product o) {
        return this.ID_Product - o.ID_Product;
    }

}
