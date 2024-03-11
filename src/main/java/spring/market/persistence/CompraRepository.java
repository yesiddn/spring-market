package spring.market.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.market.domain.Purchase;
import spring.market.domain.repository.PurchaseRepository;
import spring.market.persistence.crud.CompraCrudRepository;
import spring.market.persistence.entity.Compra;
import spring.market.persistence.mapper.PurchaseMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
  @Autowired
  private CompraCrudRepository compraCrudRepository;

  @Autowired
  private PurchaseMapper mapper;
  @Override
  public List<Purchase> getAll() {
    return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByClientId(String clientId) {
    return compraCrudRepository.findByIdCliente(clientId)
            .map(compras -> mapper.toPurchases(compras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    Compra compra = mapper.toCompra(purchase);
    compra.getProductos().forEach(producto -> producto.setCompra(compra));

    return mapper.toPurchase(compraCrudRepository.save(compra));
  }
}
