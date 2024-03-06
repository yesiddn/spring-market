package spring.market.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.market.domain.Product;
import spring.market.domain.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController // le indica a spring que esta clase sera el controller de una api rest
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping()
  public List<Product> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable("id") int productId) {
    return productService.getProduct(productId);
  }

  @GetMapping("/category/{id}")
  public Optional<List<Product>> getByCategoryId(@PathVariable("id") int categoryId) {
    return productService.getCategoryById(categoryId);
  }

  @PostMapping()
  public Product save(@RequestBody Product product) {
    return productService.save(product);
  }

  @DeleteMapping("{id}")
  public boolean delete(@PathVariable("id") int productId) {
    return productService.delete(productId);
  }
}
