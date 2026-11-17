package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.ProductModel;
import todo.todo_app.services.implementions.ProductServiceImplementation;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("products")
public class ProductController {

    private  final ProductServiceImplementation productServiceImplementation;

    public ProductController(ProductServiceImplementation productServiceImplementation){
        this.productServiceImplementation = productServiceImplementation;
    }

    @GetMapping
   public  List<ProductModel> getAllProduct(){
        return  productServiceImplementation.getAllProduct();
    }

    @PostMapping
    public ProductModel createProduct( @RequestBody ProductModel productModel){
        return productServiceImplementation.createProduct(productModel);
    }

    @PutMapping("/{id}")
    public ProductModel updateProductById( @PathVariable Long id,@RequestBody ProductModel productModel){
        return productServiceImplementation.updateProductById(id,productModel);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById( @PathVariable Long id){
        productServiceImplementation.deleteProductById(id);
    }

}
