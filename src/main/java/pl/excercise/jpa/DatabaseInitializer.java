package pl.excercise.jpa;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.entity.CustomerEntity;
import pl.excercise.jpa.repository.AddressRepository;
import pl.excercise.jpa.repository.CustomerRepository;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class DatabaseInitializer {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

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


    }

}
