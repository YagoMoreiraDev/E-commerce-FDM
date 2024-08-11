package com.cloud.yagodev.dscommerce.services;

import com.cloud.yagodev.dscommerce.domain.dtos.ProductDTO;
import com.cloud.yagodev.dscommerce.domain.entities.Product;
import com.cloud.yagodev.dscommerce.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        var product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return new ProductDTO(productRepository.save(product));
    }
}
