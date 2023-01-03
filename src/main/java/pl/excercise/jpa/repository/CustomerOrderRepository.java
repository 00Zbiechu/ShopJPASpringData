package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.CustomerEntity;
import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.projection.CustomerNameSurnameTotalPrice;
import pl.excercise.jpa.projection.CustomerOrderWithProduct;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {

//	1. Stwórz metodę, która będzie wyciągającą encję CustomerOrder po polu totalPrice, którego wartość jest pomiędzy dwoma podanymi argumentami.
	@Query("SELECT co FROM CustomerOrderEntity co WHERE co.totalPrice BETWEEN :priceOne AND :priceTwo")
	List<CustomerOrderEntity> getCustomerOrderWhichTotalPriceIsBetweenParams(BigDecimal priceOne, BigDecimal priceTwo);

//	2. Stwórz metodę, która wyciągnie sumy totalPrice dla poszczególnych encji Customer.
	@Query("SELECT c.firstName AS firstName, c.surname AS surname, SUM(co.totalPrice) as totalPrice FROM CustomerOrderEntity AS co JOIN co.customer c  GROUP BY firstName,surname")
	List<CustomerNameSurnameTotalPrice> getSumPriceOfOrdersForCustomer();

//	 3. Stwórz metodę, która wyciaga encje CustomerOrder po Product.name.
	@Query(value = "select customer_order.id as customerOrderId, product.name as productName  from customer_order " +
			"inner join product_customer_order on customer_order.id = product_customer_order.customer_order_id" +
			" inner join product on product.id =product_customer_order.product_id" +
			" where product.name=:name",nativeQuery = true)
	List<CustomerOrderWithProduct> getCustomerOrderByProductsName(@Param("name") String name);

//	 4. Stwórz metodę, która wyciąga CustomerOrder, które nie są powiązane z żadną encją Product.
	@Query("SELECT co FROM CustomerOrderEntity co WHERE co.products=null")
	List<CustomerOrderEntity> getCustomerOrderEntitiesWithoutProducts();
}
