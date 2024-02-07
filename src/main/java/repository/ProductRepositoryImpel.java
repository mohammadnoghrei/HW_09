package repository;

import base.BaseRepositoryImpel;
import connection.JdbcConnection;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpel extends BaseRepositoryImpel<Integer, Product> implements ProductRepository {
    public ProductRepositoryImpel(Connection connection) {
        super(connection);
    }


    @Override
    public int updateProductCount(int id,int count ) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String edit = "UPDATE product set product_count=? WHERE product_id= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(1,count);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }


    @Override
    public String getTableName() {
        return " product ";
    }

    @Override
    public String getColumnId() {
        return " product_id ";
    }

    @Override
    public String getColumnModelName() {
        return " product_name ";
    }

    @Override
    public Product mapResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setCategoryIdFk(resultSet.getInt("category_id_fk"));
        product.setProductCount(resultSet.getInt("product_count"));
        product.setProductPrice(resultSet.getInt("product_price"));
        return (Product) product;
    }

    @Override
    public String getCountOfQuestionMarks() {
        return "(?, ?, ?, ?)";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Product product, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setInt(2, product.getCategoryIdFk());
        preparedStatement.setInt(3, product.getProductCount());
        preparedStatement.setInt(4, product.getProductPrice());
    }

    @Override
    public String getUpdateQueryParams() {
        return " product_name = ?, category_id_fk = ?, product_count =?, product_price = ?";
    }

    @Override
    public String getCulumnsname() {
        return "( product_name, category_id_fk, product_count, product_price )";
    }


}
