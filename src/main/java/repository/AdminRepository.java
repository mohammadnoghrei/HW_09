package repository;

import base.BaseRepository;
import model.Admin;

import java.sql.SQLException;

public interface AdminRepository extends BaseRepository<Integer, Admin> {
    public Admin find(String username ,String password) throws SQLException;
}
