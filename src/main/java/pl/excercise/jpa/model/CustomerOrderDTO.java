package pl.excercise.jpa.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerOrderDTO {


    private Long id;

    private BigDecimal totalPrice;

}
