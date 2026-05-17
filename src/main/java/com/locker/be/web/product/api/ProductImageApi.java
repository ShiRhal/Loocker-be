package com.locker.be.web.product.api;

import com.locker.be.web.product.dto.ProductImageDto;
import com.locker.be.web.product.dto.ProductImageQueryDto;
import com.locker.be.web.product.service.ProductImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("web/product")
@Tag(name = "이미지 API", description = "자바단에서 입력과 삭제가 진행 되기에 api 호출은 하지 않습니다. {참고용}")
public class ProductImageApi {

    private final ProductImageService productImageService;

    @PutMapping("/image/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "신규 데이터를 입력합니다.")
    public void create(@RequestBody final ProductImageDto.ProductImageCreateReq dto) {
        productImageService.saveImages(dto);
    }

    @PutMapping("/image/delete")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "신규 데이터를 삭제합니다.")
    public void delete(@RequestBody final ProductImageDto.ProductImageDeleteReq dto) {
        productImageService.delete(dto);
    }

    @GetMapping("/image/select")
    @Operation(summary = "검색조건에 따른 상품 이미지에 대한 데이터를 반환합니다.")
    public Collection<ProductImageQueryDto.ProductImageRes> findAll(@ModelAttribute final ProductImageQueryDto.ProductImageReq dto) {
        return productImageService.findAll(dto);
    }
}
