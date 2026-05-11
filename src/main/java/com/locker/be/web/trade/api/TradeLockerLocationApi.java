package com.locker.be.web.trade.api;

import com.locker.be.web.trade.dto.TradeLockerLocationDto;
import com.locker.be.web.trade.dto.TradeLockerLocationQueryDto;
import com.locker.be.web.trade.service.TradeLockerLocationService;
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
@RequestMapping("web/trade/locker/location")
@Tag(name = "거래 API", description = "보관함 지점 선택을 위한 API 입니다.")
public class TradeLockerLocationApi {

    private final TradeLockerLocationService tradeLockerLocationService;

    @GetMapping("/list/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> findAll() {

        return tradeLockerLocationService.findAll();
    }

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> findAll(TradeLockerLocationQueryDto.TradeLockerLocationReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeLockerLocationService.findSelect(dto, token);
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> create(@RequestBody final TradeLockerLocationDto.TradeLockerLocationCreateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeLockerLocationService.create(dto, token);
    }

    @PostMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 수정합니다.")
    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> update(@RequestBody final TradeLockerLocationDto.TradeLockerLocationUpdateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeLockerLocationService.update(dto, token);
    }

    @PutMapping("/delete")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 삭제합니다. [참고용]")
    public void delete(@RequestBody final TradeLockerLocationDto.TradeLockerLocationDeleteReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        tradeLockerLocationService.delete(dto, token);
    }
}
