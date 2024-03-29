package spring.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import spring.market.domain.Product;
import spring.market.persistence.entity.Producto;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
  @Mappings({
          @Mapping(source = "idProducto", target = "productId"),
          @Mapping(source = "nombre", target = "name"),
          @Mapping(source = "precioVenta", target = "price"),
          @Mapping(source = "cantidadStock", target = "stock"),
          @Mapping(source = "estado", target = "active"),
          @Mapping(source = "idCategoria", target = "categoryId"),
          @Mapping(source = "categoria", target = "category")
  })
  Product toProduct(Producto producto);
  List<Product> toProducts(List<Producto> productos);

  @InheritInverseConfiguration
  @Mapping(target = "codigoBarras", ignore = true)
  Producto toProducto(Product product);
}
