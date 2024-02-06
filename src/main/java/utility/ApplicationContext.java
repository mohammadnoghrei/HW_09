package utility;

import connection.JdbcConnection;
import repository.*;
import service.*;

import java.sql.Connection;

public class ApplicationContext {
    public static final Connection CONNECTION;
    public static final AdminRepository ADMIN_REPOSITORY;
    public static final UserRepository USER_REPOSITORY;
    public static final CategoryRepository CATEGORY_REPOSITORY;
    public static final CartRepository CART_REPOSITORY;
    public static final ProductRepository PRODUCT_REPOSITORY;


    public static final AdminService ADMIN_SERVICE;
    public static final UserService USER_SERVICE;
    public static final CategoryService CATEGORY_SERVICE;
    public static final CartService CART_SERVICE;
    public static final ProductService PRODUCT_SERVICE;

    static {
        CONNECTION = JdbcConnection.getConnection();

        ADMIN_REPOSITORY = new AdminRepositoryImpel(CONNECTION);
        USER_REPOSITORY = new UserRepositoryImpel(CONNECTION);
        CATEGORY_REPOSITORY = new CategoryRepositoryImpel(CONNECTION);
        CART_REPOSITORY = new CartRepositoryImpel(CONNECTION);
        PRODUCT_REPOSITORY = new ProductRepositoryImpel(CONNECTION);

        ADMIN_SERVICE = new AdminServiceImpel(ADMIN_REPOSITORY);
        USER_SERVICE = new UserServiceImpel(USER_REPOSITORY);
        CATEGORY_SERVICE = new CategoryServiceImpel(CATEGORY_REPOSITORY);
        CART_SERVICE=new CartServiceImpel(CART_REPOSITORY);
        PRODUCT_SERVICE= new ProductServiceImpel(PRODUCT_REPOSITORY);
    }
    public static AdminService getAdminService(){return ADMIN_SERVICE;}
    public static UserService getUserService(){return USER_SERVICE;}
    public static CategoryService getCategoryService(){return CATEGORY_SERVICE;}
    public static CartService getCartService(){return CART_SERVICE;}
    public static ProductService getProductService(){return PRODUCT_SERVICE;}
}
