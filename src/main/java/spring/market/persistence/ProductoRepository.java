package spring.market.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.market.domain.Product;
import spring.market.domain.repository.ProductRepository;
import spring.market.persistence.crud.ProductoCrudRepository;
import spring.market.persistence.entity.Producto;
import spring.market.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

//@Repository: le indicamos a la clase que es la encarga de interactuar con la base de datos. @Component: le indicamos que es un componente de spring.
//El primero es mejor porque indicamos el tipo de componente que es.
@Repository
public class ProductoRepository implements ProductRepository {
  @Autowired // esto facilita la inyeccion de dependencia, sin esto tendriamos que instanciar productoCrudRepository
  // y si no se pone al ejecutar el codigo nos lanzara un null pointer exception
  // solo se puede usar esta sintaxis en Beans o Componentes de spring
  private ProductoCrudRepository productoCrudRepository;

  @Autowired
  private ProductMapper mapper;

//   De esta forma toda la info que venga del dominio se puede traducir a la estructura de la persistencia
  @Override
  public List<Product> getAll() {
    List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
    return mapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getCategoryById(int categoryId) {
    List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
    return Optional.of(mapper.toProducts(productos));
  }

  @Override
  public Optional<List<Product>> getScaresProducts(int quantity) {
    Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    return productos.map(prods -> mapper.toProducts(prods)); // se usa el map porque en el mapper no tenemos ningun optional que retorne un optional con una lista
  }

  @Override
  public Optional<Product> getProduct(int productId) {
    return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
  }

  @Override
  public Product save(Product product) {
    Producto producto = mapper.toProducto(product);
    return mapper.toProduct(productoCrudRepository.save(producto));
  }

  @Override
  public void delete(int productId) {
    productoCrudRepository.deleteById(productId);
  }
}
