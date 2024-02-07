package service;

import base.BaseServiceImpel;
import model.User;
import repository.UserRepository;

import java.sql.SQLException;

public class UserServiceImpel extends BaseServiceImpel<Integer, User, UserRepository> implements UserService {
    public UserServiceImpel(UserRepository repository) {
        super(repository);
    }

    @Override
    public User find(String username, String password) throws SQLException {
        return repository.find(username, password);
    }
}
