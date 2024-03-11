package spring.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import spring.market.domain.Purchase;
import spring.market.domain.PurchaseItem;
import spring.market.persistence.entity.Compra;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
//  Con respecto a MapStruct desde java 8 en adelante no es necesario usar la anotación @Mappings (No afecta si se usa):
  @Mapping(source = "idCompra", target = "purchaseId")
  @Mapping(source = "idCliente", target = "clientId")
  @Mapping(source = "fecha", target = "date")
  @Mapping(source = "medioPago", target = "paymentMethod")
  @Mapping(source = "comentario", target = "comment")
  @Mapping(source = "estado", target = "state")
  @Mapping(source = "productos", target = "items") // usa el PurchaseItemMapper para traerlo a esta clase
  Purchase toPurchase(Compra compra);
  List<Purchase> toPurchases(List<Compra> compras);

  @InheritInverseConfiguration
  @Mapping(target = "cliente", ignore = true) // en el mappin principal, deben estar todos los mappings, de lo contrario hay que ignorarlos
  Compra toCompra(Purchase purchase);
}
