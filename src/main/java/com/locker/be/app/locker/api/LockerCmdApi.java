package com.locker.be.app.locker.api;

import com.locker.be.app.locker.dto.LockerCmdQueryDto;
import com.locker.be.app.locker.dto.LockerCmdDto;
import com.locker.be.app.locker.service.LockerCmdService;
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
@RequestMapping("kiosk/locker/command")
@Tag(name = "라즈베리파이 command API", description = "라즈베리파이 command를 위한 API 입니다.")
public class LockerCmdApi {

    private final LockerCmdService lockerCmdService;

    @GetMapping("/select")
    @Operation(summary = "명령 조회.")
    public Collection<LockerCmdQueryDto.LockerCmdRes> findCmd(LockerCmdQueryDto.LockerCmdReq dto) {
        return lockerCmdService.findCmd(dto);
    }

    @GetMapping("/status/select")
    @Operation(summary = "명령 조회.")
    public Collection<LockerCmdQueryDto.LockerCmdStatusRes> findCmdStatus(LockerCmdQueryDto.LockerCmdStatusReq dto) {
        return lockerCmdService.findCmdStatus(dto);
    }

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void create(@RequestBody final LockerCmdDto.LockerCmdInsertReq dto) {
        lockerCmdService.create(dto);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void update(@RequestBody final LockerCmdDto.LockerCmdUpdateReq dto) {
        lockerCmdService.update(dto);
    }

    @PutMapping("admin/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void adminCreate(@RequestBody final LockerCmdDto.LockerAdminCmdInsertReq dto) {
        lockerCmdService.adminCreate(dto);
    }

}
