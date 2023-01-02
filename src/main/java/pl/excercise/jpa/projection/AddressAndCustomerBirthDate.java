package pl.excercise.jpa.projection;

import java.time.LocalDate;

public interface AddressAndCustomerBirthDate {

    String getId();
    String getCountry();
    String getCity();
    String getStreet();
    String getZipcode();
    LocalDate getCustomerBirthDate();


}
