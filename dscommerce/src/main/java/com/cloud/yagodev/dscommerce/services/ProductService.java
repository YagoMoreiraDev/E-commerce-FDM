package com.cloud.yagodev.dscommerce.services;

import com.cloud.yagodev.dscommerce.domain.dtos.ProductDTO;
import com.cloud.yagodev.dscommerce.domain.entities.Product;
import com.cloud.yagodev.dscommerce.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }
}
