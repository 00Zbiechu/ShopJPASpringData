package pl.excercise.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.entity.CustomerEntity;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.model.CustomerOrderMapper;
import pl.excercise.jpa.projection.CustomerNameSurnameTotalPrice;
import pl.excercise.jpa.projection.CustomerOrderWithProduct;
import pl.excercise.jpa.repository.CustomerOrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService{

    private final CustomerOrderRepository customerOrderRepository;

    @Override
    public List<CustomerOrderDTO> getCustomerOrderWhichTotalPriceIsBetweenParams(BigDecimal priceOne, BigDecimal priceTwo) {
        return customerOrderRepository.getCustomerOrderWhichTotalPriceIsBetweenParams(priceOne,priceTwo).stream()
                .map(CustomerOrderMapper.INSTANCE::customerOrderEntityToCustomerOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerNameSurnameTotalPrice> getSumPriceOfOrdersForCustomer() {
        return customerOrderRepository.getSumPriceOfOrdersForCustomer();
    }

    @Override
    public List<CustomerOrderWithProduct> getCustomerOrderByProductsName(String name) {
        return customerOrderRepository.getCustomerOrderByProductsName(name);
    }

    @Override
    public List<CustomerOrderDTO> getCustomerOrderEntitiesWithoutProducts() {
        return customerOrderRepository.getCustomerOrderEntitiesWithoutProducts().stream()
                .map(CustomerOrderMapper.INSTANCE::customerOrderEntityToCustomerOrderDTO)
                .collect(Collectors.toList());
    }
}
