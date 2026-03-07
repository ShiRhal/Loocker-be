package com.locker.be.product.service;

import com.locker.be.product.dto.ProductDto;
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

    public Long create(ProductDto.ProductDetailReq dto) {
        productMapper.create(dto);
        return dto.getNewID();
    }

    // @Transactional(readOnly = true)
    public Collection<ProductQueryDto.ProductDetailRes> findOne(ProductQueryDto.ProductDetailReq dto) {

        return productMapper.findOne(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<ProductQueryDto.ProductRes> findAll(ProductQueryDto.ProductReq dto) {

        return productMapper.findAll(dto);
    }
}
