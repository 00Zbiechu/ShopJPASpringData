package pl.excercise.jpa.model;


import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;

    private BigDecimal price;

    private Integer availableQuantity;

}
