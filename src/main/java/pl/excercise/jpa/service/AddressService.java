package pl.excercise.jpa.service;

import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.model.AddressDTO;

import java.time.LocalDate;
import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddressByCountryOrStreet(String param);

    List<AddressDTO> getAddressForOlderCustomerThanParam(LocalDate date);

}
