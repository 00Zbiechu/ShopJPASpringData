package pl.excercise.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_generator")
    @SequenceGenerator(name = "customer_seq_generator", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String surname;

    @Column(nullable = false)
    private LocalDate birthDate;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private AddressEntity address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<CustomerOrderEntity> orders;
}
