package spring.market.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.market.domain.Purchase;
import spring.market.domain.service.PurchaseService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/purchases")
public class PurchaseController {
  @Autowired
  private PurchaseService purchaseService;

  @GetMapping()
  public ResponseEntity<List<Purchase>> getAll() {
    // generar dos respuestas: positiva, negativa
    try {
      return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    } catch (RuntimeException ex) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<Purchase>> getByClientId(@PathVariable("id") String clientId) {
    try {
      return ResponseEntity.of(purchaseService.getByClientId(clientId));
    } catch (RuntimeException ex) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping()
  public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
    return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
  }
}
