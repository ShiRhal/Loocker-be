package com.locker.be.web.product.service;

import com.locker.be.web.product.dto.ProductTradeTypeDto;
import com.locker.be.web.product.mapper.ProductTradeTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductTradeTypeService {

    private final ProductTradeTypeMapper productTradeTypeMapper;

    public void create(ProductTradeTypeDto.ProductTradeTypeReq dto) {
        productTradeTypeMapper.create(dto);
    }
}
