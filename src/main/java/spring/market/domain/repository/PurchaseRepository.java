package spring.market.domain.repository;

import spring.market.domain.Product;
import spring.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
  List<Purchase> getAll();
  Optional<List<Purchase>> getByClientId(String clientId);
  Purchase save(Purchase purchase);
}
