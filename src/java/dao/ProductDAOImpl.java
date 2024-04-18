/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.DetailsOfInvoiceItems;
import model.Category;
import model.Product;

/**
 *
 * @author ACERR
 */
public class ProductDAOImpl implements ProductDAO {

    @Override
    public ArrayList<Product> getListProductCategory(int ID_Category) {
        Connection connection = DBConnection.getConnection();
//        String sql = "SELECT * FROM Product WHERE ID_Category=?";
        String sql = "select * from Product where ID_Category='" + ID_Category + "'";
        ArrayList<Product> arr = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, ID_Category);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getInt("unit_price"));
                product.setDiscount(rs.getInt("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));

                arr.add(product);
            }
            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return arr;
    }

    @Override
    public Product getInforProduct(int ID_Product) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from Product where ID_Product='" + ID_Product + "'";
        Product product = new Product();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getInt("unit_price"));
                product.setDiscount(rs.getInt("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    @Override
    public ArrayList<Product> getListProduct(String Name_Product) {
        Connection connection = DBConnection.getConnection();
        String sql = "Select * from Product where Name_Product like '%" + Name_Product + "%'";
        ArrayList<Product> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getInt("unit_price"));
                product.setDiscount(rs.getInt("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));
                arr.add(product);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;

    }

    public static void main(String[] args) {
        ProductDAOImpl s = new ProductDAOImpl();
//        ArrayList<Product> p = s.getListProduct("Lumia");
//        System.out.println(p.get(0).getName_Product());

//        Product product = new Product();
//        product.setName_Product("Smartphone XYZ");
//        product.setID_Category(1);
//        product.setImage("xyz_image.jpg");
//        product.setQuantity(100);
//        product.setUnit_price(500.00);
//        product.setDiscount(10.00);
//        product.setDisplay("6.5 inch IPS LCD");
//        product.setRear_camera("Dual 48MP + 5MP");
//        product.setFront_camera("25MP");
//        product.setOperating_system("Android 11");
//        product.setCpu("Snapdragon 888");
//        product.setMemory("256GB");
//        product.setRam("8GB");
//        product.setConnectivity("4G LTE, Wi-Fi 6, Bluetooth 5.2");
//        product.setBattery("5000mAh");
//        product.setDescription("High-performance smartphone with top-notch camera and long-lasting battery.");
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        boolean isSuccess = s.insertProduct(product);
//        if (isSuccess) {
//            System.out.println("Sản phẩm đã được thêm vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Có lỗi xảy ra khi thêm sản phẩm vào cơ sở dữ liệu.");
//        }
//        ProductDAOImpl productDAO = new ProductDAOImpl();
//
//        // Lấy danh sách sản phẩm mới
//        ArrayList<Product> newProducts = productDAO.getListNewProduct();
//
//        // Hiển thị thông tin của các sản phẩm mới
//        System.out.println("List of New Products:");
//        for (Product product : newProducts) {
//            System.out.println("Product ID: " + product.getID_Product());
//            System.out.println("Name: " + product.getName_Product());
//            System.out.println("Category ID: " + product.getID_Category());
//            System.out.println("Image: " + product.getImage());
//            System.out.println("Quantity: " + product.getQuantity());
//            System.out.println("Unit Price: " + product.getUnit_price());
//            System.out.println("Discount: " + product.getDiscount());
//            System.out.println("Display: " + product.getDisplay());
//            System.out.println("Rear Camera: " + product.getRear_camera());
//            System.out.println("Front Camera: " + product.getFront_camera());
//            System.out.println("Operating System: " + product.getOperating_system());
//            System.out.println("CPU: " + product.getCpu());
//            System.out.println("Memory: " + product.getMemory());
//            System.out.println("RAM: " + product.getRam());
//            System.out.println("Connectivity: " + product.getConnectivity());
//            System.out.println("Battery: " + product.getBattery());
//            System.out.println("Description: " + product.getDescription());
//            System.out.println("--------------------------------------");
//        }
        ProductDAOImpl productDAO = new ProductDAOImpl();
        ArrayList<Product> bestSellingProducts = productDAO.getListProductSellHigh();

        // Hiển thị thông tin của các sản phẩm bán chạy nhất
        System.out.println("Best Selling Products:");
        for (Product product : bestSellingProducts) {
            System.out.println("Product ID: " + product.getID_Product());
            System.out.println("Name: " + product.getName_Product());
            System.out.println("Unit Price: " + product.getUnit_price());
            System.out.println("--------------------------------------");
        }

    }

    @Override
    public ArrayList<Product> getListNewProduct() {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT TOP 8 * FROM Product ORDER BY ID_Product DESC;";
        ArrayList<Product> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getInt("unit_price"));
                product.setDiscount(rs.getInt("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));

                arr.add(product);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public ArrayList<Product> getListProductPrice(double a, double b) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from Product where unit_price>='" + a + "'and unit_price <'" + b + "'";
        ArrayList<Product> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getInt("unit_price"));
                product.setDiscount(rs.getInt("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));

                arr.add(product);
            }
            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return arr;
    }

    @Override
    public ArrayList<Product> getListProduct() {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * from Product ORDER BY ID_Product ASC";
        ArrayList<Product> arr = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getInt("unit_price"));
                product.setDiscount(rs.getInt("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));
                arr.add(product);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public ArrayList<Product> getListProductByPage(ArrayList<Product> arr, int start, int end) {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

    @Override
    public boolean insertProduct(Product product) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Product (Name_Product, ID_Category, image, quantity, unit_price, discount, display, rear_camera, front_camera, operating_system, cpu, memory, ram, connectivity, battery, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);

            pr.setString(1, product.getName_Product());
            pr.setInt(2, product.getID_Category());
            pr.setString(3, product.getImage());
            pr.setInt(4, product.getQuantity());
            pr.setDouble(5, product.getUnit_price());
            pr.setDouble(6, product.getDiscount());
            pr.setString(7, product.getDisplay());
            pr.setString(8, product.getRear_camera());
            pr.setString(9, product.getFront_camera());
            pr.setString(10, product.getOperating_system());
            pr.setString(11, product.getCpu());
            pr.setString(12, product.getMemory());
            pr.setString(13, product.getRam());
            pr.setString(14, product.getConnectivity());
            pr.setString(15, product.getBattery());
            pr.setString(16, product.getDescription());

            return pr.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Product SET Name_Product=?,ID_Category=?,image=?,quantity=?,"
                + " unit_price=?,discount=?,display=?,rear_camera=?,front_camera=?,operating_system=?,"
                + "cpu=?,memory=?,ram=?,connectivity=?,battery=?,description=? where ID_Product=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);

            ps.setString(1, product.getName_Product());
            ps.setInt(2, product.getID_Category());
            ps.setString(3, product.getImage());
            ps.setInt(4, product.getQuantity());
            ps.setDouble(5, product.getUnit_price());
            ps.setDouble(6, product.getDiscount());
            ps.setString(7, product.getDisplay());
            ps.setString(8, product.getRear_camera());
            ps.setString(9, product.getFront_camera());
            ps.setString(10, product.getOperating_system());
            ps.setString(11, product.getCpu());
            ps.setString(12, product.getMemory());
            ps.setString(13, product.getRam());
            ps.setString(14, product.getConnectivity());
            ps.setString(15, product.getBattery());
            //ps.setString(16, product.getBao_hanh());
            ps.setString(16, product.getDescription());
            ps.setInt(17, product.getID_Product());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteProductByID_Category(int ID_Category) {
        Connection connection = DBConnection.getConnection();
        String sql = "delete from Product Where ID_Product=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Category);
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Product> getListProductSellHigh() {
        ArrayList<Product> productList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();

        // SQL query to find products with the highest quantity sold
        String sql = "SELECT p.*, SUM(d.quantity) as total_quantity_sold "
                + "FROM Product p "
                + "JOIN Details_of_invoice_items d ON p.ID_Product = d.ID_Product "
                + "GROUP BY p.ID_Product, p.Name_Product, p.ID_Category, p.image, p.quantity, "
                + "p.unit_price, p.discount, p.display, p.rear_camera, p.front_camera, "
                + "p.operating_system, p.cpu, p.memory, p.ram, p.connectivity, p.battery, p.description "
                + "ORDER BY total_quantity_sold DESC";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getDouble("unit_price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));

                product.setTotalQuantitySold(rs.getInt("total_quantity_sold"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return productList;
    }

//    @Override
//    public ArrayList<Product> getListProductSellHigh() {
//        Connection connection = DBConnection.getConnection();
//        String sql = "SELECT TOP 5 sp.ID_Product, sp.Name_Product, sp.Unit_price FROM Product sp JOIN  Details_of_invoice_items cthd ON sp.ID_Product = cthd.ID_Product;";
//        ArrayList<Product> arr = new ArrayList<>();
//        try {
//
//            PreparedStatement ps = connection.prepareCall(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Product sp = new Product();
//                DetailsOfInvoiceItems cthd = new DetailsOfInvoiceItems();
//                sp.setID_Product(rs.getInt("ID_Product"));
//                sp.setName_Product(rs.getString("Name_Product"));
//                sp.setUnit_price(rs.getInt("Unit_price"));
//
//                arr.add(sp);
//            }
//            connection.close(); // Đóng kết nối sau khi hoàn thành
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return arr;
//    }
    @Override
    public boolean deleteProduct(int ID_Product) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "delete from Product where ID_Product=?";

            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, ID_Product);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAOImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product getProductById(int ID_Product) {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Product WHERE ID_Product = ?";
        Product product = new Product();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ID_Product);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getInt("unit_price"));
                product.setDiscount(rs.getInt("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));
            }

            connection.close();

        } catch (SQLException e) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return product;
    }

//    public ArrayList<Product> getProductsByNameAndCategories(String name, List<Integer> categories, String priceSort) {
//        ArrayList<Product> products = new ArrayList<>();
//        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM Product WHERE Name_Product LIKE ?");
//
//        if (categories != null && !categories.isEmpty()) {
//            String inSql = categories.stream().map(c -> "?").collect(Collectors.joining(", ", " AND ID_Category IN (", ")"));
//            sqlBuilder.append(inSql);
//        }
//
//        if ("asc".equalsIgnoreCase(priceSort) || "desc".equalsIgnoreCase(priceSort)) {
//            sqlBuilder.append(" ORDER BY unit_price ").append(priceSort);
//        } else {
//            sqlBuilder.append(" ORDER BY unit_price ASC"); // Mặc định sắp xếp tăng dần nếu tham số không hợp lệ
//        }
//
//        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sqlBuilder.toString())) {
//            int index = 1;
//            ps.setString(index++, "%" + name + "%");
//            for (Integer categoryId : categories) {
//                ps.setInt(index++, categoryId);
//            }
//
//            try (ResultSet rs = ps.executeQuery()) {
//                while (rs.next()) {
//                    Product product = new Product(); // Khởi tạo và thiết lập thuộc tính cho đối tượng product từ ResultSet
//                    product.setID_Product(rs.getInt("ID_Product"));
//                    product.setName_Product(rs.getString("Name_Product"));
//                    product.setID_Category(rs.getInt("ID_Category"));
//                    product.setImage(rs.getString("image"));
//                    product.setQuantity(rs.getInt("quantity"));
//                    product.setUnit_price(rs.getDouble("unit_price"));
//                    product.setDiscount(rs.getDouble("discount"));
//                    product.setDisplay(rs.getString("display"));
//                    product.setRear_camera(rs.getString("rear_camera"));
//                    product.setFront_camera(rs.getString("front_camera"));
//                    product.setOperating_system(rs.getString("operating_system"));
//                    product.setCpu(rs.getString("cpu"));
//                    product.setMemory(rs.getString("memory"));
//                    product.setRam(rs.getString("ram"));
//                    product.setConnectivity(rs.getString("connectivity"));
//                    product.setBattery(rs.getString("battery"));
//                    product.setDescription(rs.getString("description"));
//                    products.add(product);
//                }
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return products;
//    }

    // In ProductDAOImpl.java
    public List<Product> getProductsByNameAndCategories(String name, List<Integer> categories, String priceSort) {
        List<Product> products = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Product WHERE Name_Product LIKE ?");

        if (!categories.isEmpty()) {
            sql.append(" AND ID_Category IN (").append(String.join(",", Collections.nCopies(categories.size(), "?"))).append(")");
        }

        if ("asc".equalsIgnoreCase(priceSort) || "desc".equalsIgnoreCase(priceSort)) {
            sql.append(" ORDER BY unit_price ").append(priceSort);
        }

        try (Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            int index = 1;
            ps.setString(index++, "%" + name + "%");

            for (Integer categoryId : categories) {
                ps.setInt(index++, categoryId);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(); // Populate your product object here
                product.setID_Product(rs.getInt("ID_Product"));
                product.setName_Product(rs.getString("Name_Product"));
                product.setID_Category(rs.getInt("ID_Category"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setUnit_price(rs.getDouble("unit_price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setDisplay(rs.getString("display"));
                product.setRear_camera(rs.getString("rear_camera"));
                product.setFront_camera(rs.getString("front_camera"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setCpu(rs.getString("cpu"));
                product.setMemory(rs.getString("memory"));
                product.setRam(rs.getString("ram"));
                product.setConnectivity(rs.getString("connectivity"));
                product.setBattery(rs.getString("battery"));
                product.setDescription(rs.getString("description"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly
        }
        return products;
    }

    private Product extractProductFromResultSet(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setID_Product(rs.getInt("ID_Product"));
        product.setName_Product(rs.getString("Name_Product"));
        product.setID_Category(rs.getInt("ID_Category"));
        product.setImage(rs.getString("image"));
        product.setQuantity(rs.getInt("quantity"));
        product.setUnit_price(rs.getDouble("unit_price"));
        product.setDiscount(rs.getDouble("discount"));
        product.setDisplay(rs.getString("display"));
        product.setRear_camera(rs.getString("rear_camera"));
        product.setFront_camera(rs.getString("front_camera"));
        product.setOperating_system(rs.getString("operating_system"));
        product.setCpu(rs.getString("cpu"));
        product.setMemory(rs.getString("memory"));
        product.setRam(rs.getString("ram"));
        product.setConnectivity(rs.getString("connectivity"));
        product.setBattery(rs.getString("battery"));
        product.setDescription(rs.getString("description"));
        return product;
    }

}
