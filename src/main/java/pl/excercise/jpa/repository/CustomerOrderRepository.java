package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.CustomerOrderEntity;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {
	/*
	 * 1. Stwórz metodę, która będzie wyciągającą encję CustomerOrder po polu totalPrice, którego wartość jest pomiędzy dwoma podanymi argumentami.
	 * 2. Stwórz metodę, która wyciągnie sumy totalPrice dla poszczególnych encji Customer.
	 * 3. Stwórz metodę, która wyciaga encje CustomerOrder po Product.name.
	 * 4. Stwórz metodę, która wyciąga CustomerOrder, które nie są powiązane z żadną encją Product.
	 * */
}
