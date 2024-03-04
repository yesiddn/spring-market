package spring.market.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.market.domain.Product;
import spring.market.domain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAll() {
    return productRepository.getAll();
  }

  public Optional<Product> getProduct(int productId) {
    return productRepository.getProduct(productId);
  }

  public Optional<List<Product>> getCategoryById(int categoryId) {
    return productRepository.getCategoryById(categoryId);
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public boolean delete(int productId) {
    // Dos formas de retornar
    return getProduct(productId).map(product -> {
      productRepository.delete(productId);
      return true;
    }).orElse(false);

//    if (getProduct(productId).isPresent()) {
//      productRepository.delete(productId);
//      return true
//    }
//    return false;
  }
}
