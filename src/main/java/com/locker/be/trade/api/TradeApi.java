package com.locker.be.trade.api;

import com.locker.be.trade.dto.TradeDto;
import com.locker.be.trade.service.TradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("trade")
@Tag(name = "거래 API", description = "거래를 위한 API 입니다.")
public class TradeApi {

    private final TradeService tradeService;

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
    public void update(@RequestBody final TradeDto.TradeUpdateReq dto, @RequestHeader(value = "Authorization", required = false) String authorization) {
        String token = authorization.replace("Bearer ", "");
        tradeService.update(dto, token);
    }
}
