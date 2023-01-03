package pl.excercise.jpa;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.entity.CustomerEntity;
import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.entity.ProductEntity;
import pl.excercise.jpa.repository.AddressRepository;
import pl.excercise.jpa.repository.CustomerOrderRepository;
import pl.excercise.jpa.repository.CustomerRepository;
import pl.excercise.jpa.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Component
public class DatabaseInitializer {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    private final ProductRepository productRepository;

    private final CustomerOrderRepository customerOrderRepository;

    @PostConstruct
    public void initDatabase(){

        //Customerowie -----------------------------------------------------------------------

        CustomerEntity customer = CustomerEntity.builder()
                .firstName("Mateusz")
                .surname("Zbiewski")
                .birthDate(LocalDate.of(2000,02,20))
                .build();

        customerRepository.save(customer);


        CustomerEntity customerSecond = CustomerEntity.builder()
                .firstName("Jan")
                .surname("Kowalski")
                .birthDate(LocalDate.of(2000,03,10))
                .build();

        customerRepository.save(customerSecond);

        CustomerEntity customerThird = CustomerEntity.builder()
                .firstName("Adrian")
                .surname("Nowak")
                .birthDate(LocalDate.of(1992,03,10))
                .build();

        customerRepository.save(customerThird);


        //Adresy -------------------------------------------------------------------------------

        AddressEntity addressEntity = AddressEntity.builder()
                .country("Polska")
                .city("Koszalin")
                .street("Budowniczych")
                .zipcode("75-400")
                .customer(customer)
                .build();

        addressRepository.save(addressEntity);


        AddressEntity addressEntitySecond = AddressEntity.builder()
                .country("Polska")
                .city("Szczecin")
                .street("Jana Pawla II")
                .zipcode("75-500")
                .customer(customerSecond)
                .build();

        addressRepository.save(addressEntitySecond);

        AddressEntity addressEntityThird = AddressEntity.builder()
                .country("Niemcy")
                .city("Berlin")
                .street("Strasse")
                .zipcode("500")
                .customer(customerThird)
                .build();

        addressRepository.save(addressEntityThird);


        //Products ------------------------------------------------------------------------------


        ProductEntity productEntity = ProductEntity.builder()
                .name("Maslo")
                .price(BigDecimal.valueOf(5.99))
                .availableQuantity(100)
                .build();

        productRepository.save(productEntity);

        ProductEntity productEntitySecond = ProductEntity.builder()
                .name("Chleb")
                .price(BigDecimal.valueOf(3.99))
                .availableQuantity(50)
                .build();

        productRepository.save(productEntitySecond);

        ProductEntity productEntityThird = ProductEntity.builder()
                .name("Bulka")
                .price(BigDecimal.valueOf(0.99))
                .availableQuantity(200)
                .build();

        productRepository.save(productEntityThird);


        //CustomerOrder -----------------------------------------------------------------------------

        //Ceny
        BigDecimal productEntityOne = productEntity.getPrice();
        BigDecimal productEntityTwo = productEntitySecond.getPrice();
        BigDecimal productEntityThree = productEntityThird.getPrice();


        CustomerOrderEntity customerOrderEntity = CustomerOrderEntity.builder()
                .totalPrice(productEntityOne.add(productEntityTwo).add(productEntityThree))
                .customer(customer)
                .products(Set.of(productEntity,productEntitySecond,productEntityThird))
                .build();

        customerOrderRepository.save(customerOrderEntity);

        CustomerOrderEntity customerOrderEntitySecond = CustomerOrderEntity.builder()
                .totalPrice(productEntityTwo.add(productEntityThree))
                .customer(customerSecond)
                .products(Set.of(productEntitySecond,productEntityThird))
                .build();

        customerOrderRepository.save(customerOrderEntitySecond);

        CustomerOrderEntity customerOrderEntityThird = CustomerOrderEntity.builder()
                .totalPrice(productEntityOne.add(productEntityThree))
                .customer(customerThird)
                .products(Set.of(productEntity,productEntityThird))
                .build();

        customerOrderRepository.save(customerOrderEntityThird);


    }


}
