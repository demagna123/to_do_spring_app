package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.CategoryModel;
import todo.todo_app.services.implementions.CategoryServiceImplementation;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("categories/")
public class CategoryController {

    private final CategoryServiceImplementation categoryServiceImplementation;

    public CategoryController (CategoryServiceImplementation categoryServiceImplementation){
        this.categoryServiceImplementation = categoryServiceImplementation;
    }
    @GetMapping("/list")
    public List<CategoryModel> getAllCategory(){

        return  categoryServiceImplementation.getAllCategory();
    }
    @PostMapping("/create")
    public  CategoryModel createCategory( @RequestBody CategoryModel categoryModel){

        return categoryServiceImplementation.createCategory(categoryModel);
    }

    @PutMapping("/update/{id}")
    public CategoryModel updateCategoryById(@PathVariable Long id, @RequestBody CategoryModel categoryModel){

        return  categoryServiceImplementation.updateCategoryById(id, categoryModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id){

        categoryServiceImplementation.deleteCategoryById(id);
    }
}
