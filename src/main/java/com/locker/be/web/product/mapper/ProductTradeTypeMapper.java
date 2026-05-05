package com.locker.be.web.product.mapper;

import com.locker.be.web.product.dto.ProductTradeTypeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductTradeTypeMapper {

    public void create(ProductTradeTypeDto.ProductTradeTypeReq dto);
}
