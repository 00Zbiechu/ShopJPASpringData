package pl.excercise.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.CustomerMapper;
import pl.excercise.jpa.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> getCustomerEntitiesByAddressCountryOrderByBirthDateAsc(String country) {

        return customerRepository.getCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(country)
                .stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
                .collect(Collectors.toList());

    }

}
