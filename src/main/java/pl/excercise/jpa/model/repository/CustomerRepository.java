package pl.excercise.jpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.model.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	/*
	 * 1. Stwórz metodę, która wyciagnie encje Customer po polu Address.country posortowane po birthDate rosnąco.
	 * 2. Stwórz metodę, która wyciągnie projekcje zawierającą jedno pole fullName, będące połączeniem firstName + surname.
	 * 3. Stwórz metodę, która będzie wyciągała encje Customer dla birthDate większe niż podana data i niepustego firstName.
	 * 4. Stwórz metodę, która będzie wyciągała encje Customer dla surname zawierającego w sobie daną frazę (odpowiednik LIKE %fraza%).
	 * */
}
