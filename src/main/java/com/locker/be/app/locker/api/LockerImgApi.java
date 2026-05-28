package com.locker.be.app.locker.api;

import com.locker.be.app.locker.dto.LockerImgDto;
import com.locker.be.app.locker.dto.LockerImgQueryDto;
import com.locker.be.app.locker.service.LockerImgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("kiosk/locker/img")
@Tag(name = "보관함 웹캠 API", description = "보관함 웹캠을 위한 API 입니다.")
public class LockerImgApi {

    private final LockerImgService lockerImgService;

    @GetMapping("/select")
    @Operation(summary = "이미지 조회.")
    public Collection<LockerImgQueryDto.LockerImgRes> findImg(LockerImgQueryDto.LockerImgReq dto) {
        return lockerImgService.findImg(dto);
    }

    @PutMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "보관함 웹캠 이미지를 저장합니다.")
    public void create(@ModelAttribute final LockerImgDto.LockerImgCreateReq dto) {
        lockerImgService.create(dto);
    }

}
