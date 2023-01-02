package pl.excercise.jpa.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.excercise.jpa.entity.CustomerEntity;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity customerDTOToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerToCustomerDTO(CustomerEntity customerEntity);

}
