package service;

import base.BaseRepositoryImpel;
import base.BaseServiceImpel;
import model.Admin;
import repository.AdminRepository;

public class AdminServiceImpel extends BaseServiceImpel<Integer, Admin, AdminRepository> implements AdminService {
    public AdminServiceImpel(AdminRepository repository) {
        super(repository);
    }
}
