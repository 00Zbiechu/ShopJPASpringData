package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.projection.AddressAndCustomerBirthDate;
import pl.excercise.jpa.projection.AddressAndTotalPrice;
import pl.excercise.jpa.projection.AddressCountryStreetZipcode;
import pl.excercise.jpa.projection.TotalPriceByCity;
import pl.excercise.jpa.service.AddressService;

import java.math.BigDecimal;
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
        public List<AddressAndCustomerBirthDate> getAddressForOlderCustomerThanParam(@PathVariable("date") LocalDate date){

            return addressService.getAddressForOlderCustomerThanParam(date);

        }

        @GetMapping("/getAddressCountryStreetZipcode")
        List<AddressCountryStreetZipcode> getAddressCountryStreetZipcode(){

            return addressService.getAddressCountryStreetZipcode();

        }


        @GetMapping("/getAddressCustomerWhoPaidMoreThanParam/{value}")
        public List<AddressAndTotalPrice> getAddressCustomerWhoPaidMoreThanParam(@PathVariable("value") BigDecimal value) {

            return addressService.getAddressCustomerWhoPaidMoreThanParam(value);
        }

    @GetMapping("/getSumOfTotalPriceCity/{city}")
    List<TotalPriceByCity> getSumOfTotalPriceCity(@PathVariable("city") String city) {
        return addressService.getSumOfTotalPriceCity(city);
    }

}
