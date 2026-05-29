package com.locker.be.app.locker.api;

import com.locker.be.app.locker.dto.LockerPayDto;
import com.locker.be.app.locker.service.LockerPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("kiosk/locker/pay")
@Tag(name = "보관함 결제 API", description = "보관함 결제를 위한 API 입니다.")
public class LockerPayApi {

    private final LockerPayService lockerPayService;

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void create(@RequestBody final LockerPayDto.LockerPayCreateReq dto) {
        lockerPayService.create(dto);
    }

    @PutMapping("/paid")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public Long paid(@RequestBody final LockerPayDto.LockerPayUpdateReq dto) {
        return lockerPayService.paid(dto);
    }

}
