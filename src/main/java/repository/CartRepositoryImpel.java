package repository;

import base.BaseRepositoryImpel;
import connection.JdbcConnection;
import model.Cart;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRepositoryImpel extends BaseRepositoryImpel<Integer, Cart> implements CartRepository{
    public CartRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " cart ";
    }

    @Override
    public String getColumnId() {
        return " cart_id ";
    }

    @Override
    public String getColumnModelName() {
        return null;
    }

    @Override
    public Cart mapResultSet(ResultSet resultSet) throws SQLException {
        Cart cart = new Cart();
        cart.setId(resultSet.getInt("cart_id"));
        cart.setProductIdFk(resultSet.getInt("product_id_fk"));
        cart.setCount(resultSet.getInt("count"));
        cart.setTotalPrice(resultSet.getInt("total_price"));
        return (Cart) cart;
    }

    @Override
    public String getCountOfQuestionMarks() {
        return " (?, ?, ?) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Cart cart, boolean isCountOnly) throws SQLException {
        preparedStatement.setInt(1, cart.getProductIdFk());
        preparedStatement.setInt(2, cart.getCount());
        preparedStatement.setInt(3, cart.getTotalPrice());
    }

    @Override
    public String getUpdateQueryParams() {
        return " product_id_fk = ?, count = ?, total_price = ?";
    }

    @Override
    public String getCulumnsname() {
        return "( product_id_fk,count,total_price )";
    }

    @Override
    public void cartList() throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String sql="select * from cart order by cart_id ";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int productId = resultSet.getInt(2);
                int count= resultSet.getInt(3);
                int totalPrice =resultSet.getInt(4);
                System.out.println("cart "+id+"->  product Id"+productId+"  count:"+count+"  total price:"+totalPrice);
            }
    }


    @Override
    public int cartPriceSum() throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String sql="select sum(total_price)from cart";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int total =resultSet.getInt(1);
        return total;
    }

    @Override
    public void deleteAll() throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String sql = "DELETE FROM " + getTableName() + " WHERE  cart_id > ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 0);
            preparedStatement.executeUpdate();

        }
    }
}
