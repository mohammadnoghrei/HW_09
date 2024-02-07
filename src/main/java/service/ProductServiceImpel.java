package service;

import base.BaseRepository;
import base.BaseServiceImpel;
import model.Admin;
import model.Product;
import repository.ProductRepository;

import java.sql.SQLException;

public class ProductServiceImpel extends BaseServiceImpel<Integer, Product, ProductRepository> implements ProductService{

    public ProductServiceImpel(ProductRepository repository) {
        super(repository);
    }

    @Override
    public int updateProductCount(int id, int count) throws SQLException {
        return repository.updateProductCount(id,count);
    }
}
