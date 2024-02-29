package spring.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria")
  private Integer idCategoria;

  private String descripcion;
  private Boolean estado;

  @OneToMany(mappedBy = "categoria") // lo contraio de productos, categoria es el nombre del atributo dado de la relacion ManyToOne de la clase Producto
  private List<Producto> productos;

  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }
}
