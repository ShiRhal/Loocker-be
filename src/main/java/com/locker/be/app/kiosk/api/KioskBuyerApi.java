package com.locker.be.app.kiosk.api;

import com.locker.be.app.kiosk.dto.KioskBuyerQueryDto;
import com.locker.be.app.kiosk.service.KioskBuyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("kiosk/buyer")
@Tag(name = "보관함 판매자 API", description = "보관함 판매자를 위한 api 입니다.")
public class KioskBuyerApi {

    private final KioskBuyerService kioskBuyerService;

    @GetMapping("/locker")
    @Operation(summary = "비어있는 보관함 리스트 반환.")
    public Collection<KioskBuyerQueryDto.KioskLockerRes> lockerListBuyer(KioskBuyerQueryDto.KioskLockerReq dto) {

        return kioskBuyerService.lockerListBuyer(dto);
    }

    @GetMapping("/product")
    @Operation(summary = "보관함 판매글 리스트 반환.")
    public Collection<KioskBuyerQueryDto.KioskProductRes> productListBuyer(KioskBuyerQueryDto.KioskProductReq dto) {

        return kioskBuyerService.productListBuyer(dto);
    }

}
