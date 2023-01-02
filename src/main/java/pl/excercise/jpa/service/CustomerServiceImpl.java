package pl.excercise.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.CustomerMapper;
import pl.excercise.jpa.projection.CustomerFullName;
import pl.excercise.jpa.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> findCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(String country) {

        return customerRepository.findCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(country)
                .stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<CustomerFullName> findAllByOrderBySurnameAsc() {
        return customerRepository.findAllByOrderBySurnameAsc();
    }

    @Override
    public List<CustomerDTO> getCustomerYoungerThanDate(LocalDate localdate) {
        return customerRepository.getCustomerYoungerThanDate(localdate).stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getSurnameContainsParam(String param) {
        return customerRepository.getSurnameContainsParam(param).stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

}
