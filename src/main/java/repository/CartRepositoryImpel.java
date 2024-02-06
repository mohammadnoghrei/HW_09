package repository;

import base.BaseRepositoryImpel;
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
}
