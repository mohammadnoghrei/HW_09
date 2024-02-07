package service;

import base.BaseService;
import model.Admin;
import model.Product;

import java.sql.SQLException;

public interface ProductService extends BaseService<Integer, Product> {
    public int updateProductCount(int id,int count ) throws SQLException;
}
