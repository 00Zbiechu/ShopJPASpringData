package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.service.AddressService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

        private final AddressService addressService;


        @GetMapping("/getAddressByCountryOrStreet/{param}")
        public List<AddressDTO> getAddressByCountryOrStreet(@PathVariable("param") String param){

            return addressService.getAddressByCountryOrStreet(param);

        }


        @GetMapping("/getAddressForOlderCustomerThanParam/{date}")
        public List<AddressDTO> getAddressForOlderCustomerThanParam(@PathVariable("date") LocalDate date){

            return addressService.getAddressForOlderCustomerThanParam(date);

        }

}
