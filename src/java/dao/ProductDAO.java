/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import model.Product;
/**
 *
 * @author ACERR
 */
    public interface ProductDAO {
    //load san pham By ID_Category;
    public ArrayList<Product> getListProductCategory(int ID_Category);
    //hiển thị chi tiết sản phẩm
    public Product getInforProduct(int ID_Product);
    // lay thong tin san pham By ten san pham
    public ArrayList<Product> getListProduct(String Name_Product);
    // lay danh sach san pham moi nhat
    public ArrayList<Product> getListNewProduct();
    // Lay danh sach san pham By gia
    public ArrayList<Product> getListProductPrice(double a, double b);
    // Lay tât ca danh sach san pham
    public ArrayList<Product> getListProduct();
    //PHAN TRANG
    public ArrayList<Product> getListProductByPage(ArrayList<Product> arr, int start, int end);
    boolean insertProduct(Product product);
    boolean deleteProduct(int ID_Product);
    boolean updateProduct(Product product);
    boolean deleteProductByID_Category(int ID_Category);
    //thong ke san pham ban chay
    public ArrayList<Product> getListProductSellHigh();
    
    // Lấy thông tin sản phẩm theo ID
    public Product getProductById(int ID_Product);
}
