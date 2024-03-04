package spring.market.domain.repository;

import spring.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  List<Product> getAll();
  Optional<List<Product>> getCategoryById(int categoryId);
  Optional<List<Product>> getScaresProducts(int quantity);
  Optional<Product> getProduct (int productId);
  Product save(Product product);
  void delete(int productId);
}
