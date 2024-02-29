package spring.market.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Long idCompra;

  private LocalDateTime fecha;

  @Column(name = "medio_pago")
  private String medioPago;

  private String comentario;

  private String estado;

  @Column(name = "id_cliente")
  private Integer idCliente;

  @ManyToOne
  @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
  private Cliente cliente;

  @OneToMany(mappedBy = "compra")
  private List<ComprasProducto> productos;
  public Long getIdCompra() {
    return idCompra;
  }

  public void setIdCompra(Long idCompra) {
    this.idCompra = idCompra;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }

  public String getMedioPago() {
    return medioPago;
  }

  public void setMedioPago(String medioPago) {
    this.medioPago = medioPago;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }
}
