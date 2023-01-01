package pl.excercise.jpa.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer_order")
public class CustomerOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_order_seq_generator")
    @SequenceGenerator(name = "customer_order_seq_generator", sequenceName = "customer_order_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(scale = 19, precision = 2, nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(mappedBy = "orders")
    private Set<ProductEntity> products = new LinkedHashSet<>();
}
