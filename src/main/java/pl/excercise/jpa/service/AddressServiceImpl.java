package pl.excercise.jpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.AddressMapper;
import pl.excercise.jpa.projection.AddressAndCustomerBirthDate;
import pl.excercise.jpa.projection.AddressCountryStreetZipcode;
import pl.excercise.jpa.repository.AddressRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;


    @Override
    public List<AddressDTO> getAddressByCountryOrStreet(String param) {
        return addressRepository.getAddressByCountryOrStreet(param).stream()
                .map(AddressMapper.INSTANCE::addressToAddressDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressAndCustomerBirthDate> getAddressForOlderCustomerThanParam(LocalDate date) {
        return addressRepository.getAddressForOlderCustomerThanParam(date);
    }

    @Override
    public List<AddressCountryStreetZipcode> getAddressCountryStreetZipcode() {
        return addressRepository.getAddressCountryStreetZipcode();
    }
}
