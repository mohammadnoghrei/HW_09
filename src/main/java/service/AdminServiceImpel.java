package service;

import base.BaseRepositoryImpel;
import base.BaseServiceImpel;
import model.Admin;
import repository.AdminRepository;

import java.sql.SQLException;

public class AdminServiceImpel extends BaseServiceImpel<Integer, Admin, AdminRepository> implements AdminService {
    public AdminServiceImpel(AdminRepository repository) {
        super(repository);
    }

    @Override
    public Admin find(String username, String password) throws SQLException {
        return repository.find(username,password);
    }
}
