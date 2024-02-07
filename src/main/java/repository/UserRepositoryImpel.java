package repository;

import base.BaseRepositoryImpel;
import connection.JdbcConnection;
import model.Admin;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpel extends BaseRepositoryImpel<Integer, User> implements UserRepository {
    public UserRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " users ";
    }

    @Override
    public String getColumnId() {
        return " user_id ";
    }

    @Override
    public String getColumnModelName() {
        return null;
    }

    @Override
    public User mapResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));

        return (User) user;
    }

    @Override
    public String getCountOfQuestionMarks() {
        return " (?, ?) ";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, User user, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
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
    public User find(String username, String password) throws SQLException {
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
            User user = new User(id, fetchUsername, fetchpassword);
            return user;
        }
        else
            return null;
    }

}
