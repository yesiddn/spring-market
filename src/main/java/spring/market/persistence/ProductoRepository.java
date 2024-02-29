package spring.market.persistence;

import spring.market.persistence.crud.ProductoCrudRepository;
import spring.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
  private ProductoCrudRepository productoCrudRepository;

  public List<Producto> getAll() {
    return (List<Producto>) productoCrudRepository.findAll(); // findAll retorna un Itelable, por lo cual se castea a una Lista
  }
}
