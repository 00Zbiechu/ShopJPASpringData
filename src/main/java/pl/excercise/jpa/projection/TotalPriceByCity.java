package pl.excercise.jpa.projection;

import java.math.BigDecimal;

public interface TotalPriceByCity {

    String getCity();

    BigDecimal getSum();

}
