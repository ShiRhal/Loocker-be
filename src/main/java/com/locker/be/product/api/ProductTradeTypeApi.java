package com.locker.be.product.api;

import com.locker.be.product.dto.ProductTradeTypeDto;
import com.locker.be.product.service.ProductTradeTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product/trade/type")
@Tag(name = "거래방식 API", description = "거래방식을 위한 API 입니다.")
public class ProductTradeTypeApi {

    private final ProductTradeTypeService productTradeTypeService;

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "신규 데이터를 입력합니다.")
    public void create(ProductTradeTypeDto.ProductTradeTypeReq dto) {
        productTradeTypeService.create(dto);
    }
}
