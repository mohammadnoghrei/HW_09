package utility;

import connection.JdbcConnection;
import repository.CategoryRepository;
import repository.CategoryRepositoryImpel;
import service.CategoryService;
import service.CategoryServiceImpel;

import java.sql.Connection;

public class ApplicationContext {
    public static final Connection CONNECTION;
    public static final CategoryRepository CATEGORY_REPOSITORY;

    public static final CategoryService CATEGORY_SERVICE;

    static {
        CONNECTION = JdbcConnection.getConnection();

        CATEGORY_REPOSITORY = new CategoryRepositoryImpel(CONNECTION);

        CATEGORY_SERVICE = new CategoryServiceImpel(CATEGORY_REPOSITORY);
    }
    public static CategoryService getCategoryService(){return CATEGORY_SERVICE;}
}
