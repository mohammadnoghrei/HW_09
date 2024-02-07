package menu;

import model.*;
import service.*;
import utility.ApplicationContext;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public final Scanner scanner = new Scanner(System.in);

    AdminService adminService = ApplicationContext.getAdminService();
    UserService userService = ApplicationContext.getUserService();
    ProductService productService = ApplicationContext.getProductService();
    CategoryService categoryService = ApplicationContext.getCategoryService();
    CartService cartService = ApplicationContext.getCartService();

    public int getIntFromUser() {
        int num = 0;
        try {
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.nextLine();
        }
        return num;
    }

    public String getStringFromUser() {
        String str = null;
        try {
            str = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    public void saveCategory() {
        System.out.println("enter category name");
        String name = getStringFromUser();
        Category category = new Category(name);
        try {
            categoryService.save(category);
            System.out.println("*** category saved ***");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser() {
        System.out.println("enter username");
        String username = getStringFromUser();
        System.out.println("enter password");
        String password = getStringFromUser();
        User user = new User(username,password);
        try {
            userService.save(user);
            System.out.println("*** user saved ***");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void saveAdmin() {
        System.out.println("enter username");
        String username = getStringFromUser();
        System.out.println("enter password");
        String password = getStringFromUser();
        Admin admin= new Admin(username,password);
        try {
            adminService.save(admin);
            System.out.println("*** admin saved ***");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void saveProduct() {
        System.out.println("enter product name");
        String name = getStringFromUser();
        System.out.println("enter category id");
        int categoryId = getIntFromUser();
        System.out.println("enter count of product");
        int count = getIntFromUser();
        System.out.println("enter product price");
        int price =getIntFromUser();
        Product product = new Product(name,categoryId,count,price);
        try {
            productService.save(product);
            System.out.println("*** product saved ***");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveCart() {
        System.out.println("enter product_id");
        int idProduct = getIntFromUser();
        System.out.println("enter count of product");
        int count = getIntFromUser();
        if (findProductCount(idProduct,count)==false) {
            System.out.println(" kheyliiiii ziyade nadarim");}
        else {

            int productPrice = 0;
            try {
                productPrice = productService.findById(idProduct).getProductPrice();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                ;
            }

            int totalPrice = count * productPrice;
            Cart cart = new Cart(idProduct, count, totalPrice);
            try {
                cartService.save(cart);
                System.out.println("*** cart saved ***");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }}

    public Category findByIdCategory() {
        System.out.println("please enter category id");
        int id = getIntFromUser();
        try {
            return categoryService.findById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Product findByIdProduct() {
        System.out.println("please enter product id");
        int id = getIntFromUser();
        try {
            return productService.findById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Cart findByIdCart() {
        System.out.println("please enter cart id");
        int id = getIntFromUser();
        try {
            return cartService.findById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Category findByNameCategory() {
        System.out.println("please enter category name");
        String name = getStringFromUser();
        try {
            return categoryService.findByName(name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateCategory() {
        Category category = findByIdCategory();
        if (category != null) {
            System.out.println("enter new category name");
            String name = getStringFromUser();
            category.setCategoryName(name);
            try {
                categoryService.update(category);
                System.out.println("category updated");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else System.out.println("this id not exist");
    }

    public void updateProduct() {
        Product product = findByIdProduct();
        if (product != null) {
            System.out.println("enter new product name");
            String name = getStringFromUser();
            product.setProductName(name);
            System.out.println("enter new product category id");
            int categoryId = getIntFromUser();
            product.setCategoryIdFk(categoryId);
            System.out.println("enter new product count");
            int count = getIntFromUser();
            product.setProductCount(count);
            System.out.println("enter new product price");
            int price = getIntFromUser();
            product.setProductPrice(price);
            try {
                productService.update(product);
                System.out.println("product updated");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else System.out.println("this id not exist");
    }

    public void updateCart() {
        Cart cart = findByIdCart();
        if (cart != null) {
            System.out.println("enter new product id");
            int productId = getIntFromUser();
            cart.setProductIdFk(productId);
            System.out.println("enter new count");
            int count = getIntFromUser();
            cart.setCount(count);
            int productPrice = 0;
            try {
                productPrice = productService.findById(productId).getProductPrice();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                ;
            }
            int totalPrice = count * productPrice;
            cart.setTotalPrice(totalPrice);

            try {
                cartService.update(cart);
                System.out.println("cart updated");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else System.out.println("this id not exist");
    }

    public void deleteCategory() {
        System.out.println("please enter id for delete Category");
        int id = getIntFromUser();
        boolean Delete = false;
        try {
            Delete = categoryService.delete(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (Delete) {
            System.out.println("category deleted");
        } else System.out.println("something is wrong");

    }
    public void deleteProduct() {
        System.out.println("please enter id for delete Product");
        int id = getIntFromUser();
        boolean Delete = false;
        try {
            Delete = productService.delete(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (Delete) {
            System.out.println("product deleted");
        } else System.out.println("something is wrong");

    }
    public void deleteCart() {
        System.out.println("please enter id for delete Cart");
        int id = getIntFromUser();
        boolean Delete = false;
        addProductCount(id);
        try {
            Delete = cartService.delete(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (Delete) {
            System.out.println("cart deleted");
        } else System.out.println("something is wrong");

    }

    public void productCountCheck() throws SQLException {
        productService.updateProductCount(1,20);
    }
    public boolean findProductCount(int id ,int count){
        Product product =null;
        try {
             product =productService.findById(id);
        } catch (SQLException e) {
            e.getMessage();

        }
        if (product.getProductCount()>= count) {
            try {
                productService.updateProductCount(id, product.getProductCount()-count);
            } catch (SQLException e) {
                e.getMessage();
            }
            return true;}

        else return false;

    }
    public boolean addProductCount(int id ){////////////////////////////////////برای دیلیت باید اضاف کند
        Cart cart =null;
        try {
            cart =cartService.findById(id);
        } catch (SQLException e) {
            e.getMessage();
        }
        Product product =null;
        try {
            product =productService.findById(cart.getProductIdFk());
        } catch (SQLException e) {
            e.getMessage();
        }
        try {
                productService.updateProductCount(cart.getProductIdFk(),
                        cart.getCount()+product.getProductCount());
            } catch (SQLException e) {
                e.getMessage();
            }
            return true;}




}
