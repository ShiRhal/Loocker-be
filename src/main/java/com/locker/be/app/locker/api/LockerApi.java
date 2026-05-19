package com.locker.be.app.locker.api;

import com.locker.be.app.locker.dto.LockerDto;
import com.locker.be.app.locker.service.LockerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("kiosk/locker")
@Tag(name = "거래 API", description = "거래를 위한 API 입니다.")
public class LockerApi {

    private final LockerService lockerService;

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public String create(@RequestBody final LockerDto.LockerCreateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return lockerService.create(dto, token);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public String update(@RequestBody final LockerDto.LockerUpdateReq dto, @RequestHeader(value = "Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return lockerService.update(dto, token);
    }
}
