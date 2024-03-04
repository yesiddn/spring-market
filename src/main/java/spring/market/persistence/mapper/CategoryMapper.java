package spring.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import spring.market.domain.Category;
import spring.market.persistence.entity.Categoria;

@Mapper(componentModel = "spring") // integracion con spring boot
public interface CategoryMapper {
  @Mappings({
          @Mapping(source = "idCategoria", target = "categoryId"), // source -> de donde viene (fuente) | target -> a donde va (destino)
          @Mapping(source = "descripcion", target = "category"),
          @Mapping(source = "estado", target = "active")
  })
  Category toCategory(Categoria categoria);

@InheritInverseConfiguration // se indica que es la inversa del mapping anterior
@Mapping(target = "productos", ignore = true)
  Categoria toCategoria(Category category);
}
