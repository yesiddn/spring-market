package spring.market.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.market.domain.Product;
import spring.market.domain.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController // le indica a spring que esta clase sera el controller de una api rest
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  public List<Product> getAll() {
    return productService.getAll();
  }

  public Optional<Product> getProduct(int productId) {
    return productService.getProduct(productId);
  }

  public Optional<List<Product>> getByCategoryId(int categoryId) {
    return productService.getCategoryById(categoryId);
  }

  public Product save(Product product) {
    return productService.save(product);
  }

  public boolean delete(int productId) {
    return productService.delete(productId);
  }
}
