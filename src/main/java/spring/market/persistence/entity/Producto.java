package spring.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private Long idProducto; // Se utilizan los tipos extendidos (Integer, String, etc) porque es posible que en un determinado momento tengamos un valor null desde la base de datos. Sí tuviéramos un "int" sería 0 por defecto y esto sería un error.

  private String nombre;

  @Column(name = "codigo_barras")
  private String codigoBarras;

  @Column(name = "precio_venta")
  private Double precioVenta;

  @Column(name = "cantidad_stock")
  private Integer cantidadStock;

  private Boolean estado;

  @Column(name = "id_categoria")
  private Integer idCategoria;

  @ManyToOne
  @JoinColumn(name = "id_categoria", insertable = false, updatable = false) // estas propiedades restringen el insertar o editar datos en la tabla categorias por medio de la relacion
  private Categoria categoria;

  public Long getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Long idProducto) {
    this.idProducto = idProducto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCodigoBarras() {
    return codigoBarras;
  }

  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

  public Double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public Integer getCantidadStock() {
    return cantidadStock;
  }

  public void setCantidadStock(Integer cantidadStock) {
    this.cantidadStock = cantidadStock;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }
}
