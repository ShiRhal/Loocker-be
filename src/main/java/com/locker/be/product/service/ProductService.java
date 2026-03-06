package com.locker.be.product.service;

import com.locker.be.product.dto.ProductQueryDto;
import com.locker.be.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    // @Transactional(readOnly = true)
    public Collection<ProductQueryDto.ProductRes> findAll(ProductQueryDto.ProductReq dto) {

        return productMapper.findAll(dto);
    }
}
