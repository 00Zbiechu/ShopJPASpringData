package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/getCustomerEntitiesByAddressCountryOrderByBirthDate/{country}")
    public List<CustomerDTO> getCustomerEntitiesByAddressCountryOrderByBirthDateAsc(@PathVariable("country") String country){

        return customerService.getCustomerEntitiesByAddressCountryOrderByBirthDateAsc(country);

    }

}
