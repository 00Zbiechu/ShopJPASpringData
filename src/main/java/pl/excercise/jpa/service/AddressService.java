package pl.excercise.jpa.service;

import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.projection.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddressByCountryOrStreet(String param);

    List<AddressAndCustomerBirthDate> getAddressForOlderCustomerThanParam(LocalDate date);

    List<AddressCountryStreetZipcodeDTO> getAddressCountryStreetZipcode();

    List<AddressAndTotalPrice> getAddressCustomerWhoPaidMoreThanParam(BigDecimal value);

    List<TotalPriceByCity> getSumOfTotalPriceCity(String city);

}
