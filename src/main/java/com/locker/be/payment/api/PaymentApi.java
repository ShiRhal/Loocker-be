package com.locker.be.payment.api;

import com.locker.be.payment.dto.PaymentDto;
import com.locker.be.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("payment")
@Tag(name = "결제 API", description = "결제를 위한 API 입니다.")
public class PaymentApi {

    private final PaymentService paymentService;

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void create(@RequestBody final PaymentDto.PaymentCreateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        paymentService.create(dto, token);
    }

    @PutMapping("/paid/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 수정합니다.")
    public Long paid(@RequestBody final PaymentDto.PaymentPaidReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        return paymentService.paid(dto, token);
    }

    @PutMapping("/cancel/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 수정합니다.")
    public void cancel(@RequestBody final PaymentDto.PaymentCanceledReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        paymentService.cancel(dto, token);
    }

}
