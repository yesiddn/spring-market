package spring.market.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.market.domain.Purchase;
import spring.market.domain.repository.PurchaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
  @Autowired
  private PurchaseRepository purchaseRepository;
  public List<Purchase> getAll() {return purchaseRepository.getAll();}
  public Optional<List<Purchase>> getByClientId(String clientId) {return purchaseRepository.getByClientId(clientId);}
  public Purchase save(Purchase purchase) {return purchaseRepository.save(purchase);}
}
