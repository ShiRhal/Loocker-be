package com.locker.be.web.trade.api;

import com.locker.be.web.trade.dto.TradeLockerDto;
import com.locker.be.web.trade.dto.TradeLockerQueryDto;
import com.locker.be.web.trade.dto.TradeQueryDto;
import com.locker.be.web.trade.service.TradeLockerService;
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
@RequestMapping("web/trade/locker")
@Tag(name = "거래 API", description = "보관함 지점 선택을 위한 API 입니다.")
public class TradeLockerApi {

    private final TradeLockerService tradeLockerService;

    @GetMapping("/location/list/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> findAll() {
        return tradeLockerService.findAll();
    }

    @GetMapping("/location/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> findAll(TradeLockerQueryDto.TradeLockerLocationReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeLockerService.findSelect(dto, token);
    }

    @GetMapping("/state/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeLockerQueryDto.TradeLockerStateRes> findState(TradeLockerQueryDto.TradeLockerStateReq dto) {
        return tradeLockerService.findState(dto);
    }

    @PostMapping("/location/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> create(@RequestBody final TradeLockerDto.TradeLockerLocationCreateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeLockerService.create(dto, token);
    }

    @PostMapping("/location/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 수정합니다.")
    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> update(@RequestBody final TradeLockerDto.TradeLockerLocationUpdateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeLockerService.update(dto, token);
    }

    @PutMapping("/location/delete")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 삭제합니다. [참고용]")
    public void delete(@RequestBody final TradeLockerDto.TradeLockerLocationDeleteReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        tradeLockerService.delete(dto, token);
    }

    @GetMapping("/img/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<TradeLockerQueryDto.TradeLockerImgRes> findId(TradeLockerQueryDto.TradeLockerImgReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return tradeLockerService.findImg(dto, token);
    }

}
