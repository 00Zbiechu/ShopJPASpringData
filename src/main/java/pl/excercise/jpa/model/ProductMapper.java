package pl.excercise.jpa.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.excercise.jpa.entity.ProductEntity;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(ProductEntity productEntity);


    ProductEntity productDTOToProduct(ProductDTO productDTO);


}
