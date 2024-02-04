package base;

import java.io.Serializable;
import java.sql.SQLException;

public interface BaseService<ID extends Serializable, Type extends Model<ID>> {

    void save(Type entity) throws SQLException;

    Type findById(ID id) throws SQLException;
    Type findByName(String name) throws SQLException;

    void update(Type entity) throws SQLException;

    boolean delete(ID id) throws SQLException;
}
