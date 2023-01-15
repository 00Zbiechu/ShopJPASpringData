package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.projection.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

//    1. Stwórz metodę, która będzie wyciągała encję Address po polach Country lub Street
     @Query("SELECT a FROM AddressEntity a WHERE a.country LIKE %:param% OR a.street LIKE %:param%")
     List<AddressEntity> getAddressByCountryOrStreet(String param);

//     2. Stwórz metodę, która wyciąganie encje Address dla wartości mniejszych birthDate powiązanej encji Customer, od podanej wartości.
     @Query("SELECT a FROM AddressEntity a JOIN a.customer c WHERE c.birthDate<:date")
     List<AddressAndCustomerBirthDate> getAddressForOlderCustomerThanParam(LocalDate date);

//     3. Stwórz metodę, która wyciągnie projekcje wszystkich encji Address, zawierającą tylko pola country, street, zipcode.
     @Query("SELECT new pl.excercise.jpa.projection.AddressCountryStreetZipcodeDTO(a.country, a.street, a.zipcode) FROM AddressEntity a")
     List<AddressCountryStreetZipcodeDTO> getAddressCountryStreetZipcode();

//     4. Stwórz metodę, która wyciągnie unikalne encje Address powiązane z encją Customer, których chociaż jedno z CustomerOrderEntity miało pole totalPrice większe od podanego w argumencie.
     @Query("SELECT DISTINCT a.street as street,a.country as country, a.city as city,co.totalPrice as totalPrice FROM AddressEntity AS a JOIN a.customer AS c JOIN c.orders co WHERE co.totalPrice>:value")
     List<AddressAndTotalPrice> getAddressCustomerWhoPaidMoreThanParam(BigDecimal value);

//    5. Stwórz metodę, która będzie sumować totalPrice z CustomerOrderEntity dla podanego argumentu city.
     @Query("SELECT a.city as city, SUM(co.totalPrice) as sum FROM AddressEntity a JOIN a.customer c JOIN c.orders co WHERE a.city=:city GROUP BY a.city")
     List<TotalPriceByCity> getSumOfTotalPriceCity(String city);
}
