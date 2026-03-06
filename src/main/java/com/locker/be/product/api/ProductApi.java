package com.locker.be.product.api;

import com.locker.be.product.dto.ProductQueryDto;
import com.locker.be.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product")
@Tag(name = "상품 API", description = "상품을 위한 API 입니다.")
public class ProductApi {

    private final ProductService productService;

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<ProductQueryDto.ProductRes> findAll(ProductQueryDto.ProductReq dto) {
        return productService.findAll(dto);
    }
}
