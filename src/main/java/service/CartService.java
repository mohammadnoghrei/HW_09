package service;

import base.BaseService;
import model.Cart;

import java.sql.SQLException;

public interface CartService extends BaseService<Integer, Cart> {
    public void cartList() throws SQLException;
    public int cartPriceSum() throws SQLException;
    public void deleteAll () throws SQLException;
}
