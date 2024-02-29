package spring.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import spring.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { // <Table, TipoDatoPK>
//  Tres tipos de repositorios:
//  - CrudRepository: realizar el crue
//  - PagingAndSortingRepository: incluye lo de Crud repository ademas de paginación y ordenamiento.
//  - JPARepository: Ademas de tener CrudRepository y PagingAndSortingRepository nos permite tareas específicas como Flush.

//  query methods, mejor practica
//  List<Producto> findByIdCategoria(int idCategoria);
  List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

//  forma nativa
//  @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
//  List<Producto> getByCategoria(int idCategoria);

  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
