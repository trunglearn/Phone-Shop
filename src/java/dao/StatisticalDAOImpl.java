package dao;

import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.Product;
import model.Value;

public class StatisticalDAOImpl implements StatisticalDAO {

    @Override
    public ArrayList<Value> getAll() {
        ProductDAOImpl spDao = new ProductDAOImpl();
        ArrayList<Value> list = new ArrayList<>();
        for (Product sp : spDao.getListProductSellHigh()) {
            list.add(new Value(sp.getName_Product(), sp.getTotalQuantitySold()));
        }
        return list;
    }

    public List<Value> searchProductsByCriteria(String searchTerm, List<String> categoryIds, Date startDate, Date endDate) {
        List<Value> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT p.Name_Product, SUM(d.quantity) as totalQuantitySold ")
                .append("FROM Product p ")
                .append("JOIN Details_of_invoice_items d ON p.ID_Product = d.ID_Product ")
                .append("JOIN Invoice i ON d.ID_Invoice = i.ID_Invoice ")
                .append("JOIN Category c ON p.ID_Category = c.ID_Category ")
                .append("WHERE p.Name_Product LIKE ? ");

        if (categoryIds != null && !categoryIds.isEmpty()) {
            sqlBuilder.append("AND c.ID_Category IN (").append(String.join(",", Collections.nCopies(categoryIds.size(), "?"))).append(") ");
        }

        if (startDate != null) {
            sqlBuilder.append("AND i.purchase_date >= ? ");
        }

        if (endDate != null) {
            sqlBuilder.append("AND i.purchase_date <= ? ");
        }

        sqlBuilder.append("GROUP BY p.ID_Product, p.Name_Product ")
                .append("ORDER BY totalQuantitySold DESC");

        String sql = sqlBuilder.toString();

        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + searchTerm + "%");

            int parameterIndex = 2;

            if (categoryIds != null && !categoryIds.isEmpty()) {
                for (String categoryId : categoryIds) {
                    ps.setString(parameterIndex++, categoryId);
                }
            }

            // Adjustments for Date parameters
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (startDate != null) {
                ps.setString(parameterIndex++, dateFormat.format(startDate));
            }
            if (endDate != null) {
                ps.setString(parameterIndex++, dateFormat.format(endDate));
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                String nameProduct = rs.getString("Name_Product");
                int totalQuantitySold = rs.getInt("totalQuantitySold");
                list.add(new Value(nameProduct, totalQuantitySold));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException on closing: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return list;
    }

}
