package com.locker.be.product.mapper;

import com.locker.be.product.dto.ProductTradeTypeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductTradeTypeMapper {

    public void create(ProductTradeTypeDto.ProductTradeTypeReq dto);
}
