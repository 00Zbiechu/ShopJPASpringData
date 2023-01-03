package pl.excercise.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    @SequenceGenerator(name = "product_seq_generator", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @Column(nullable = false, scale = 19, precision = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer availableQuantity;

    @ManyToMany
    @JoinTable(name = "customer_order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_order_id"))
    private Set<CustomerOrderEntity> orders = new LinkedHashSet<>();

}
