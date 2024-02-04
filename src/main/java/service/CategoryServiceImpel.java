package service;

import base.BaseRepository;
import base.BaseServiceImpel;
import model.Category;
import repository.CategoryRepository;

public class CategoryServiceImpel extends BaseServiceImpel<Integer, Category, CategoryRepository>implements CategoryService {

    public CategoryServiceImpel(CategoryRepository repository) {
        super(repository);
    }
}
