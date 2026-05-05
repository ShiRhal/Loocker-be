package com.locker.be.web.product.mapper;

import com.locker.be.web.product.dto.ProductImageDto;
import com.locker.be.web.product.dto.ProductImageQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface ProductImageMapper {

    public Long create(ProductImageDto.ProductImageCreateReq dto);

    public void delete(ProductImageDto.ProductImageDeleteReq dto);

    public void deleteForUpdate(ProductImageDto.ProductImageDeleteReq dto);

    public String findPri(ProductImageQueryDto.ProductPriImageReq dto);

    public Collection<ProductImageQueryDto.ProductImageRes> findAll(ProductImageQueryDto.ProductImageReq dto);
}
