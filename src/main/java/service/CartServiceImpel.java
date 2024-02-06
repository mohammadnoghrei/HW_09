package service;

import base.BaseServiceImpel;
import model.Cart;
import repository.CartRepository;

public class CartServiceImpel extends BaseServiceImpel <Integer, Cart, CartRepository> implements  CartService {
    public CartServiceImpel(CartRepository repository) {
        super(repository);
    }
}
