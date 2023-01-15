package pl.excercise.jpa.projection;


import lombok.Value;

@Value
public class AddressCountryStreetZipcodeDTO {

    String country;
    String street;
    String zipCode;

}
