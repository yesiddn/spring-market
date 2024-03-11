package spring.market.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.market.domain.Product;
import spring.market.domain.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController // le indica a spring que esta clase sera el controller de una api rest
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping()
  @Operation(description = "Get all supermarket products")
  @ApiResponse(responseCode = "200", description = "All products")
  public ResponseEntity<List<Product>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK); // recibe dos argumentos: respuesta y http status
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) { // ya no es necesario responder con un Optional
//    return productService.getProduct(productId)
//            .map(product -> new ResponseEntity<>(product, HttpStatus.OK)) // para ver el contenido del Optional
//            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // si no se encuentra nada en el Optional

    return ResponseEntity.of(productService.getProduct(productId)); // desde spring 5 existe este método static en ResponseEntity para evitar hacer lo anterior
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<List<Product>> getByCategoryId(@PathVariable("id") int categoryId) {
    return productService.getCategoryById(categoryId)
            .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  } // cuando se consulta a la base de datos y se desea obtener una lista de producto por categoria y la categoria no existe entonces se devuelve una lista vacía, entonces, al hacer el map or else nunca entra al or else porque En el Optional si está presenta la lista, solo que está vacía, entonces aunque la categoria no exista siempre devolverá estatus OK -> 200.

  @PostMapping()
  public ResponseEntity<Product> save(@RequestBody Product product) {
    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable("id") int productId) {
    if (productService.delete(productId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // return new ResponseEntity(this.productService.delete(productId)
    //            ? HttpStatus.OK
    //            : HttpStatus.NOT_FOUND);
  }
}
