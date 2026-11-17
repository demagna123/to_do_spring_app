package todo.todo_app.services.implementions;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todo.todo_app.models.CategoryModel;
import todo.todo_app.repositories.CategoryRepository;

import java.util.List;
@Transactional
@Service
public class CategoryServiceImplementation {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImplementation (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategory(){
        return  categoryRepository.findAll();
    }

    public  CategoryModel createCategory(CategoryModel categoryModel){
        return categoryRepository.save(categoryModel);
    }

    public  CategoryModel updateCategoryById(Long id,  CategoryModel categoryModel){
        CategoryModel book = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("categorie non trouvé") );

        book.setName(categoryModel.getName());
        return   categoryRepository.save(book);
    }

    public  void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }
}
