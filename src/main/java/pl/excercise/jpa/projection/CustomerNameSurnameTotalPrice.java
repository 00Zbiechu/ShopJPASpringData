package pl.excercise.jpa.projection;

import org.springframework.beans.factory.annotation.Value;
import pl.excercise.jpa.entity.CustomerEntity;

import java.math.BigDecimal;

public interface CustomerNameSurnameTotalPrice {

    String getFirstName();
    String getSurname();
    BigDecimal getTotalPrice();


}
