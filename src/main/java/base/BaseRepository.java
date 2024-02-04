package base;

import java.io.Serializable;
import java.sql.SQLException;

public interface BaseRepository <ID extends Serializable ,TYPE extends Model<ID>>{
    int save(TYPE type) throws SQLException;
    TYPE findBYId(ID id) throws SQLException;
    TYPE findBYName(String name) throws SQLException;
    int update(TYPE type) throws SQLException;
    boolean delete (ID id) throws SQLException;

}