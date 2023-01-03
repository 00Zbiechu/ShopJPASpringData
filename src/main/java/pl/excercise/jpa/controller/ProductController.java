package pl.excercise.jpa.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    List<ProductDTO> getPageOfProducts(){
        return productService.getPageOfProducts();
    }


}
