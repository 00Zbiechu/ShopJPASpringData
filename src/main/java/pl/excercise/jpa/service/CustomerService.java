package pl.excercise.jpa.service;

import pl.excercise.jpa.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getCustomerEntitiesByAddressCountryOrderByBirthDateAsc(String country);

}
