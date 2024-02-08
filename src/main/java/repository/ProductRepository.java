package repository;

import base.BaseRepository;
import model.Product;

import java.sql.SQLException;

public interface ProductRepository extends BaseRepository<Integer, Product> {
    public int updateProductCount(int id,int count ) throws SQLException;
    public void productList() throws SQLException;
}
