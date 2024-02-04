package menu;

import model.Category;
import service.CategoryService;
import utility.ApplicationContext;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public final Scanner scanner=new Scanner(System.in);
     CategoryService categoryService = ApplicationContext.getCategoryService();

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
            System.out.println("player deleted");
        } else System.out.println("something is wrong");

    }

}
