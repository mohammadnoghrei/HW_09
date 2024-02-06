package service;

import base.BaseServiceImpel;
import model.User;
import repository.UserRepository;

public class UserServiceImpel extends BaseServiceImpel<Integer, User, UserRepository> implements UserService {
    public UserServiceImpel(UserRepository repository) {
        super(repository);
    }
}
