package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.projection.CustomerNameSurnameTotalPrice;
import pl.excercise.jpa.projection.CustomerOrderWithProduct;
import pl.excercise.jpa.service.CustomerOrderService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/customerorder")
@RequiredArgsConstructor
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @GetMapping("/getCustomerOrderWhichTotalPriceIsBetweenParams")
    public List<CustomerOrderDTO> getCustomerOrderWhichTotalPriceIsBetweenParams(@RequestParam BigDecimal priceOne, @RequestParam BigDecimal priceTwo){

        return customerOrderService.getCustomerOrderWhichTotalPriceIsBetweenParams(priceOne, priceTwo);

    }

    @GetMapping("/getSumPriceOfOrdersForCustomer")
    public List<CustomerNameSurnameTotalPrice> getSumPriceOfOrdersForCustomer(){

        return customerOrderService.getSumPriceOfOrdersForCustomer();

    }


    @GetMapping("/getCustomerOrderByProductsName/{name}")
    public List<CustomerOrderWithProduct> getCustomerOrderByProductsName(@PathVariable("name") String name){

        return customerOrderService.getCustomerOrderByProductsName(name);

    }

    @GetMapping("/getCustomerOrderEntitiesWithoutProducts")
    public List<CustomerOrderDTO> getCustomerOrderEntitiesWithoutProducts(){

        return customerOrderService.getCustomerOrderEntitiesWithoutProducts();

    }

}
