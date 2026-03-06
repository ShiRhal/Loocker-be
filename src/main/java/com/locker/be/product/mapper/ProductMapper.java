package com.locker.be.product.mapper;

import com.locker.be.product.dto.ProductQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface ProductMapper {

    public Collection<ProductQueryDto.ProductRes> findAll(ProductQueryDto.ProductReq dto);
}
