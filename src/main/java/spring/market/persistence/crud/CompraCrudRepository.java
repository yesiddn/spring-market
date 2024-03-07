package spring.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import spring.market.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> { // entity y tipo de dato de PK
  Optional<List<Compra>> findByIdCliente(String idCliente);
}
