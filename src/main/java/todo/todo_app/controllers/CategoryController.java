package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.CategoryModel;
import todo.todo_app.services.implementions.CategoryService;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/list")
    public List<CategoryModel> getAllCategory(){

        return  categoryService.getAllCategory();
    }
    @PostMapping("/create")
    public  CategoryModel createCategory( @RequestBody CategoryModel categoryModel){

        return categoryService.createCategory(categoryModel);
    }

    @PutMapping("/update/{id}")
    public CategoryModel updateCategoryById(@PathVariable Long id, @RequestBody CategoryModel categoryModel){

        return  categoryService.updateCategoryById(id, categoryModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id){

        categoryService.deleteCategoryById(id);
    }
}
