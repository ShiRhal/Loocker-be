package com.locker.be.product.mapper;

import com.locker.be.product.dto.ProductDto;
import com.locker.be.product.dto.ProductQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface ProductMapper {

    public Long create(ProductDto.ProductDetailReq dto);

    public Collection<ProductQueryDto.ProductDetailRes> findOne(ProductQueryDto.ProductDetailReq dto);

    public Collection<ProductQueryDto.ProductRes> findAll(ProductQueryDto.ProductReq dto);
}
