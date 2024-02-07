package repository;

import base.BaseRepository;
import model.User;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<Integer, User> {
    public User find (String username , String password) throws SQLException;

}
