package service;

import base.BaseServiceImpel;
import model.Cart;
import repository.CartRepository;

import java.sql.SQLException;

public class CartServiceImpel extends BaseServiceImpel <Integer, Cart, CartRepository> implements  CartService {
    public CartServiceImpel(CartRepository repository) {
        super(repository);
    }

    @Override
    public void cartList() throws SQLException {
repository.cartList();
    }

    @Override
    public int cartPriceSum() throws SQLException {
        return repository.cartPriceSum();
    }

    @Override
    public void deleteAll() throws SQLException {
repository.deleteAll();
    }
}
