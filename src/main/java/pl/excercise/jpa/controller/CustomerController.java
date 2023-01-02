package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.projection.CustomerFullName;
import pl.excercise.jpa.service.CustomerService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/getCustomerByCountry/{country}")
    public List<CustomerDTO> getCustomerByCountry(@PathVariable("country") String country){

        return customerService.findCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(country);

    }


    @GetMapping("/getFullName")
    public List<CustomerFullName> getFullName(){
        return customerService.findAllByOrderBySurnameAsc();
    }


    @GetMapping("/getCustomerYoungerThanDate/{date}")
    public List<CustomerDTO> getCustomerYoungerThanDate(@PathVariable("date") LocalDate localDate){

        return customerService.getCustomerYoungerThanDate(localDate);

    }

    @GetMapping("/getSurnameContainsParam/{param}")
    public List<CustomerDTO> getSurnameContainsParam(@PathVariable("param") String param){

        return customerService.getSurnameContainsParam(param);

    }


}
