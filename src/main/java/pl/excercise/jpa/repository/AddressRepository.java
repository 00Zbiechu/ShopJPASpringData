package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.AddressEntity;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

//    1. Stwórz metodę, która będzie wyciągała encję Address po polach Country lub Street
     @Query("SELECT a FROM AddressEntity a WHERE a.country LIKE %:param% OR a.street LIKE %:param%")
     List<AddressEntity> getAddressByCountryOrStreet(String param);

//     2. Stwórz metodę, która wyciąganie encje Address dla wartości mniejszych birthDate powiązanej encji Customer, od podanej wartości.


    /*
    * 3. Stwórz metodę, która wyciągnie projekcje wszystkich encji Address, zawierającą tylko pola country, street, zipcode.
    * 4. Stwórz metodę, która wyciągnie unikalne encje Address powiązane z encją Customer, których chociaż jedno z CustomerOrderEntity miało pole totalPrice większe od podanego w argumencie.
    * 5. Stwórz metodę, która będzie sumować totalPrice z CustomerOrderEntity dla podanego argumentu city.
    * */
}
