package com.locker.be.web.product.api;

import com.locker.be.web.product.dto.ProductDto;
import com.locker.be.web.product.dto.ProductQueryDto;
import com.locker.be.web.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("web/product")
@Tag(name = "상품 API", description = "상품을 위한 API 입니다.")
public class ProductApi {

    private final ProductService productService;

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public ProductQueryDto.ProductAllRes findAll(@ModelAttribute final ProductQueryDto.ProductReq dto) {
        return productService.findAll(dto);
    }

    @GetMapping("/detail/select")
    @Operation(summary = "검색조건에 따른 상품 상세내용에 대한 데이터를 반환합니다.")
    public Collection<ProductQueryDto.ProductDetailRes> findOne(@ModelAttribute final ProductQueryDto.ProductDetailReq dto) {
        return productService.findOne(dto);
    }

    @PostMapping(value = "/detail/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "신규 데이터를 입력합니다.")
    public Long create(@ModelAttribute ProductDto.ProductDetailCreateReq dto) {
        return productService.create(dto);
    }

    @PutMapping(value = "/detail/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "데이터를 수정합니다.")
    public void update(@ModelAttribute final ProductDto.ProductDetailUpdateReq dto) {
        productService.update(dto);
    }

    @PutMapping("/detail/delete")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 삭제합니다.")
    public void delete(@RequestBody final ProductDto.ProductDetailDeleteReq dto) {
        productService.delete(dto);
    }
}
