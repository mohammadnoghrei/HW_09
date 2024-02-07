package repository;

import base.BaseRepositoryImpel;
import connection.JdbcConnection;
import model.Admin;
import model.Cart;
import model.User;

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

    @Override
    public Admin find(String username, String password) throws SQLException {

        Connection connection = JdbcConnection.getConnection();
            String findUser = "SELECT * FROM Admin WHERE username = ? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(findUser);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("admin_id");
                String fetchUsername = resultSet.getString("username");
                String fetchpassword = resultSet.getString("password");
                Admin admin = new Admin(id, fetchUsername, fetchpassword);
                return admin;
            }
            else
                return null;
        }

}
