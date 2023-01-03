package pl.excercise.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


//	1. Stwórz metodę, która wyciągnie encje Product z najwyższą wartością price.
	@Query("SELECT p FROM ProductEntity p ORDER BY p.price DESC LIMIT 1")
	List<ProductEntity> getTopProductWithHighestPrice();

//  2. Stwórz metodę, która wyciągnie obiekt Page<Product>.
	Page<ProductEntity> findAll(Pageable pageable);




	/*
	 * 3. Stwórz metodę, która wyciąganie unikalną listę encji Product, po polu Product.orders.customer.firstName
	 * */
}
