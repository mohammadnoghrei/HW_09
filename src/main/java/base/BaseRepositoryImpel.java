package base;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseRepositoryImpel<ID extends Serializable, TYPE extends Model<ID>>
        implements BaseRepository<ID,TYPE>{
    Connection connection;

    public BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }


    @Override
    public int save(TYPE type) throws SQLException {
        String sql="INSERT INTO "+getTableName()+" "+getCulumnsname()+" VALUES "+getCountOfQuestionMarks();
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            fillParamForStatement(preparedStatement, type, false);
            preparedStatement.executeUpdate();
        }
        return 0;
    }
    @Override
    public TYPE findBYId(ID id) throws SQLException {
        String sql="select * from "+getTableName()+" where "+getColumnId()+" = ?";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,(Integer) id);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next())
                return mapResultSet(resultSet);
        }
        return null;
    }

    @Override
    public TYPE findBYName(String name) throws SQLException {
        String sql="select * from "+getTableName()+" where "+getColumnModelName()+" =?";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setString(1,name);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next())
                return mapResultSet(resultSet);
        }
        return null;
    }

    @Override
    public boolean delete(ID id) throws SQLException {
        String sql = "DELETE FROM " + getTableName() + " WHERE "+getColumnId()+ "= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, (Integer) id);
            if (preparedStatement.executeUpdate()==1)
                return true;
        }
        return false;
    }

    @Override
    public int update(TYPE type) throws SQLException {
        String sql = "UPDATE " + getTableName() + " SET " + getUpdateQueryParams() + " WHERE "+getColumnId()+" = "+type.getId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            fillParamForStatement(preparedStatement, type, true);
            if (preparedStatement.executeUpdate()==1)
                return 1;
        }
        return 0;
    }



    public abstract String getTableName();
    public abstract String getColumnId();
    public abstract String getColumnModelName();

    public abstract TYPE mapResultSet(ResultSet resultSet) throws SQLException;
    public abstract String getCountOfQuestionMarks();
    public abstract void fillParamForStatement(PreparedStatement preparedStatement,TYPE type,boolean isCountOnly) throws SQLException;
    public abstract String getUpdateQueryParams();
    public abstract String getCulumnsname();
}
