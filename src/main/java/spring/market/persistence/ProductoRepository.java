package spring.market.persistence;

import spring.market.persistence.crud.ProductoCrudRepository;
import spring.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
  private ProductoCrudRepository productoCrudRepository;

  public List<Producto> getAll() {
    return (List<Producto>) productoCrudRepository.findAll(); // findAll retorna un Itelable, por lo cual se castea a una Lista
  }

  public List<Producto> getByCategoria(int idCategoria) {
    return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
  }

  public Optional<List<Producto>> getEscasos(int cantidad) {
    return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
  }
}
