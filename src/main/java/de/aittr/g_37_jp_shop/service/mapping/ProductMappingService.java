package de.aittr.g_37_jp_shop.service.mapping;

import de.aittr.g_37_jp_shop.domain.dto.ProductDto;
import de.aittr.g_37_jp_shop.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMappingService {
     //manual method. you also need to use an annotation @Service and class instead of interface
//    public ProductDto mapEntityToDto(Product entity){
//        ProductDto dto = new ProductDto();
//        dto.setId(entity.getId());
//        dto.setTitle(entity.getTitle());
//        dto.setPrice(entity.getPrice());
//        return dto;
//    }

     ProductDto mapEntityToDto(Product entity);

     @Mapping(target = "id", ignore = true)
     @Mapping(target = "active", constant = "true")
     Product mapDtoToEntity(ProductDto dto);
}
