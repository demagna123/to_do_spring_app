package todo.todo_app.services;

import todo.todo_app.models.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> getAllProduct();
    ProductModel createProduct(ProductModel productModel);
    ProductModel updateProductById(Long id, ProductModel productModel);
    void deleteProductById(Long id);
}
