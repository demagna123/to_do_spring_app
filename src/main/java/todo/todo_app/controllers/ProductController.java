package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.ProductModel;
import todo.todo_app.services.implementions.ProductService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("products")
public class ProductController {

    private  final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
   public  List<ProductModel> getAllProduct(){
        return  productService.getAllProduct();
    }

    @PostMapping
    public ProductModel createProduct( @RequestBody ProductModel productModel){
        return productService.createProduct(productModel);
    }

    @PutMapping("/{id}")
    public ProductModel updateProductById( @PathVariable Long id,@RequestBody ProductModel productModel){
        return productService.updateProductById(id,productModel);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById( @PathVariable Long id){
        productService.deleteProductById(id);
    }

}
