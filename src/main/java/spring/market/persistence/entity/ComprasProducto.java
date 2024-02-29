package spring.market.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
  @EmbeddedId // para claves primarias compuesta y esta dada por otra clase, es decir, existen mas de dos primary key
  private ComprasProductoPK id;

  private Integer cantidad;
  private BigDecimal total; // para precios no se debe usar Double, es mejor usar BigDecimal o MonetaryAmount https://www.baeldung.com/java-money-and-currency
  private Boolean estado;

  @ManyToOne
  @JoinColumn(name = "id_compra", insertable = false, updatable = false)
  private Compra compra;

  @ManyToOne
  @JoinColumn(name = "id_producto", insertable = false, updatable = false)
  private Producto producto;

  public ComprasProductoPK getId() {
    return id;
  }

  public void setId(ComprasProductoPK id) {
    this.id = id;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }
}
