package pl.excercise.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.excercise.jpa.entity.ProductEntity;
import pl.excercise.jpa.model.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getTopProductWithHighestPrice();

    List<ProductDTO> findAll(int pageNumber, int pageSize);

}
