package pl.excercise.jpa.projection;

import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.repository.CustomerOrderRepository;

public interface CustomerOrderWithProduct {

    Integer getCustomerOrderId();

    String getProductName();

}
