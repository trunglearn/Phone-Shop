package connect;

import dao.ProductDAOImpl;
import dao.AccountDAO;
import dao.AccountDAOImpl;
import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Account;
import model.Category;

public class DBConnection {

    public static Connection getConnection() {
        Connection connection = null;
        String url = DBConnection.URL;
        String user = DBConnection.USER;
        String pass = DBConnection.PASS;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connect success!!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=mydata1";
    private static final String USER = "sa";
    private static final String PASS = "123";

//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASS);
//    }
    public List<Product> getData() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM Product";

        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product product = createProductFromResultSet(rs);
                productList.add(product);
            }

        } catch (SQLException e) {
            // Handle the exception appropriately (log or rethrow)
            e.printStackTrace();
        }

        return productList;
    }

    private Product createProductFromResultSet(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("ID_Product"),
                rs.getString("Name_Product"),
                rs.getInt("ID_Categories"),
                rs.getString("image"),
                rs.getInt("quantity"),
                rs.getLong("unit_price"),
                rs.getInt("discount"),
                rs.getString("display"),
                rs.getString("rear_camera"),
                rs.getString("front_camera"),
                rs.getString("operating_system"),
                rs.getString("cpu"),
                rs.getString("memory"),
                rs.getString("ram"),
                rs.getString("connectivity"),
                rs.getString("battery"),
                rs.getString("description"));
    }

//    public static void main(String[] args) {
//        DBConnection dbConnection = new DBConnection();
//
//        // Create a Account object with sample data
//        Account Account = new Account();
//        Account.setUser_account("Trung");
//        Account.setLogin_Name("trung12082003@gmail.com");
//        Account.setPassword("password123");
//        Account.setAccess_rights(0);
//
//        // Create an instance of AccountDAOImpl
//        AccountDAOImpl AccountDAO = new AccountDAOImpl();
//
//        // Call the insertAccount method with the Account object
//        AccountDAO.insertAccount(Account);
//    }
//}
//Test:getAccount
//        List<Product> productList = dbConnection.getData();
//        AccountDAOImpl AccountDAO = new AccountDAOImpl();
//
//        Account result = AccountDAO.getAccount("anhduoc2705@gmail.com");
//
//        System.out.println(result.getID_Account());       
//Test:checkLogin
//        List<Product> productList = dbConnection.getData();
//        AccountDAOImpl AccountDAO = new AccountDAOImpl();
//
//        boolean result = AccountDAO.checkLogin("anhduoc2705@gmail.com","abc123");
//
//        System.out.println(result);
//Test:checkAccount
//        List<Product> productList = dbConnection.getData();
//        AccountDAOImpl AccountDAO = new AccountDAOImpl();
//
//        boolean result = AccountDAO.checkAccount("anhduoc2705@gmail.com");
//
//        System.out.println(result);
//Test:getInforProduct
//        ProductDAOImpl productDAO = new ProductDAOImpl();
//
//        Product product = productDAO.getInforProduct(3);
//
//        System.out.println("ID: " + product.getID_Product());
//        System.out.println("Name: " + product.getUnit_price());
//Test:getListProductCategories 
//   ProductDAOImpl p = new ProductDAOImpl();
////        System.out.println(p.getListProductCategories(2));
//        if (!productList.isEmpty()) {
//            Product firstProduct = productList.get(0);
//            System.out.println("First Product: " + firstProduct.getName_Product());
//        } else {
//            System.out.println("Product list is empty.");
//        }
//        ArrayList<Product> categoryProductList = p.getListProductCategories(2);
//
//        // Print details of each product in the categoryProductList
//        for (Product product : categoryProductList) {
//            System.out.println("Product ID: " + product.getID_Product());
//            System.out.println("Product Name: " + product.getName_Product());
//            System.out.println("Category ID: " + product.getID_Categories());
//            // Add more print statements for other attributes as needed
//            System.out.println("------------------------");
//        }
//    }
//
//}
    public static void main(String[] args) {
        // Create an instance of CategoryDAOImpl
        CategoryDAO categoryDAO = new CategoryDAOImpl();

        // Call the getListCategory method
        ArrayList<Category> categoryList = categoryDAO.getListCategory();

        // Print the results
        if (!categoryList.isEmpty()) {
            System.out.println("List of Categories:");
            for (Category category : categoryList) {
                System.out.println("Category ID: " + category.getID_Category());
                System.out.println("Category Name: " + category.getName_Category());
                System.out.println("------------------------");
            }
        } else {
            System.out.println("Category list is empty.");
        }
    }

    // Rest of your DBConnection class code...
}
