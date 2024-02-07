package service;

import base.BaseService;
import model.User;

import java.sql.SQLException;

public interface UserService extends BaseService<Integer, User> {
    public User find (String username , String password) throws SQLException;
}
