package pl.excercise.jpa.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.excercise.jpa.entity.CustomerOrderEntity;

@Mapper
public interface CustomerOrderMapper {

    CustomerOrderMapper INSTANCE = Mappers.getMapper(CustomerOrderMapper.class);

    CustomerOrderDTO customerOrderEntityToCustomerOrderDTO(CustomerOrderEntity customerOrderEntity);

    CustomerOrderEntity customerOrderDTOToCustomerOrderEntity(CustomerOrderDTO customerOrderDTO);

}
