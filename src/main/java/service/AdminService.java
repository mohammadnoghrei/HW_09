package service;

import base.BaseService;
import model.Admin;

import java.sql.SQLException;

public interface AdminService extends BaseService<Integer, Admin> {
    public Admin find (String username, String password) throws SQLException;
}
