package pl.excercise.jpa.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface AddressAndCustomerBirthDate {

    String getId();
    String getCountry();
    String getCity();
    String getStreet();
    String getZipcode();

    @Value("#{target.customer.birthDate}")
    LocalDate getCustomerBirthDate();


}
