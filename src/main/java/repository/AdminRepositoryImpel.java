package repository;

import base.BaseRepositoryImpel;
import model.Admin;
import model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpel extends BaseRepositoryImpel<Integer, Admin> implements AdminRepository {
    public AdminRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " admin ";
    }

    @Override
    public String getColumnId() {
        return " admin_id ";
    }

    @Override
    public String getColumnModelName() {
        return null;
    }

    @Override
    public Admin mapResultSet(ResultSet resultSet) throws SQLException {
        Admin admin = new Admin();
        admin.setId(resultSet.getInt("admin_id"));
        admin.setUsername(resultSet.getString("username"));
        admin.setPassword(resultSet.getString("password"));

        return (Admin) admin;
    }

    @Override
    public String getCountOfQuestionMarks() {
        return " (?, ?) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Admin admin, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1, admin.getUsername());
        preparedStatement.setString(2, admin.getPassword());
    }

    @Override
    public String getUpdateQueryParams() {
        return " username = ?, password = ? ";
    }

    @Override
    public String getCulumnsname() {
        return "( username, password )";
    }
}
