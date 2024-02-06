package service;

import base.BaseRepository;
import base.BaseServiceImpel;
import model.Admin;
import model.Product;
import repository.ProductRepository;

public class ProductServiceImpel extends BaseServiceImpel<Integer, Product, ProductRepository> implements ProductService{

    public ProductServiceImpel(ProductRepository repository) {
        super(repository);
    }
}
