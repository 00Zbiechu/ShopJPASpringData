package pl.excercise.jpa.projection;

import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.model.AddressDTO;

import java.math.BigDecimal;

public interface AddressAndTotalPrice {

    String getStreet();

    String getCountry();

    String getCity();

    BigDecimal getTotalPrice();

}
