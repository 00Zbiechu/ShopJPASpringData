package pl.excercise.jpa.service;


import pl.excercise.jpa.entity.CustomerEntity;
import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.projection.CustomerNameSurnameTotalPrice;
import pl.excercise.jpa.projection.CustomerOrderWithProduct;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrderDTO> getCustomerOrderWhichTotalPriceIsBetweenParams(BigDecimal priceOne, BigDecimal priceTwo);
    List<CustomerNameSurnameTotalPrice> getSumPriceOfOrdersForCustomer();
    List<CustomerOrderWithProduct> getCustomerOrderByProductsName(String name);

    List<CustomerOrderDTO> getCustomerOrderEntitiesWithoutProducts();

}
