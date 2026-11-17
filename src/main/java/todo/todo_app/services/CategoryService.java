package todo.todo_app.services;

import todo.todo_app.models.BookModel;
import todo.todo_app.models.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> getAllCategory();
    CategoryModel createCategory(CategoryModel categoryModel);
    CategoryModel updateCategoryById(Long id, CategoryModel categoryModel);
    void deleteCategoryById(Long id);
}
