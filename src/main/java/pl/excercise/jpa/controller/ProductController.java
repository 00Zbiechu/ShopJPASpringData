package pl.excercise.jpa.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.excercise.jpa.model.ProductDTO;
import pl.excercise.jpa.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getTopProductWithHighestPrice")
    List<ProductDTO> getTopProductWithHighestPrice(){
       return productService.getTopProductWithHighestPrice();
    }

    @GetMapping("/getPageOfProducts")
    List<ProductDTO> getPageOfProducts(@RequestParam int page, @RequestParam int size){
        return productService.findAll(page,size);
    }

    @GetMapping("/getProductEntitiesByCustomerFirstName/{name}")
    public List<ProductDTO> getProductEntitiesByCustomerFirstName(@PathVariable String name){
        return productService.getProductEntitiesByCustomerFirstName(name);
    }


}
