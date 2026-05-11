package com.locker.be.web.trade.api;

import com.locker.be.web.trade.dto.TradeDto;
import com.locker.be.web.trade.dto.TradeQueryDto;
import com.locker.be.web.trade.service.TradeService;
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
@RequestMapping("web/trade")
@Tag(name = "거래 API", description = "거래를 위한 API 입니다.")
public class TradeApi {

    private final TradeService tradeService;

    @GetMapping("/id/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeQueryDto.TradeIdRes> findId(TradeQueryDto.TradeIdReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeService.findId(dto, token);
    }

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeQueryDto.TradeRes> findAll(TradeQueryDto.TradeReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeService.findAll(dto, token);
    }

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public Long create(@RequestBody final TradeDto.TradeCreateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeService.create(dto, token);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public String update(@RequestBody final TradeDto.TradeUpdateReq dto, @RequestHeader(value = "Authorization", required = false) String authorization) {
        String token = null;
        if (authorization != null && authorization.startsWith("Bearer ")) {
            token = authorization.replace("Bearer ", "");
        }
        return tradeService.update(dto, token);
    }
}
