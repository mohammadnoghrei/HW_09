package repository;

import base.BaseRepository;
import model.Cart;

import java.sql.SQLException;

public interface CartRepository extends BaseRepository<Integer, Cart> {
public void cartList() throws SQLException;
public int cartPriceSum() throws SQLException;
public void deleteAll () throws SQLException;
}
