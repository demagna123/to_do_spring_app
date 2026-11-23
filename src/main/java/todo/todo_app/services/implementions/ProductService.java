package todo.todo_app.services.implementions;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todo.todo_app.models.ProductModel;
import todo.todo_app.repositories.ProductRepository;

import java.util.List;

@Transactional
@Service
public class ProductService implements todo.todo_app.services.ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductModel> getAllProduct(){
        return productRepository.findAll();
    }

    public  ProductModel createProduct(ProductModel productModel){
        return  productRepository.save(productModel);
    }

    public  ProductModel updateProductById(Long id, ProductModel productModel){
        ProductModel product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("produit non trouvé"));
        product.setName(productModel.getName());
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        product.setQuantity(productModel.getQuantity());

        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
