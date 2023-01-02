package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	/*
	 * 1. Stwórz metodę, która wyciągnie encje Product z najwyższą wartością price.
	 * 2. Stwórz metodę, która wyciągnie obiekt Page<Product>.
	 * 3. Stwórz metodę, która wyciąganie unikalną listę encji Product, po polu Product.orders.customer.firstName
	 * */
}
