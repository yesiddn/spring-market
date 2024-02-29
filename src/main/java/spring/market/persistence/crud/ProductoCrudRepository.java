package spring.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import spring.market.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { // <Table, TipoDatoPK>
//  Tres tipos de repositorios:
//  - CrudRepository: realizar el crue
//  - PagingAndSortingRepository: incluye lo de Crud repository ademas de paginación y ordenamiento.
//  - JPARepository: Ademas de tener CrudRepository y PagingAndSortingRepository nos permite tareas específicas como Flush.
}
