package pl.excercise.jpa.service;

import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.projection.CustomerFullName;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(String country);

    List<CustomerFullName> findAllByOrderBySurnameAsc();

    List<CustomerDTO> getCustomerYoungerThanDate(LocalDate localDate);

    List<CustomerDTO> getSurnameContainsParam(String param);

}
