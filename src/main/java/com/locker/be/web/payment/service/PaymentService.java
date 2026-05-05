package com.locker.be.web.payment.service;

import com.locker.be.web.payment.dto.PaymentDto;
import com.locker.be.web.payment.mapper.PaymentMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;
    private final JwtUtil jwtUtil;

    public void create (PaymentDto.PaymentCreateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);

        PaymentDto.PaymentCreateReq params = PaymentDto.PaymentCreateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .PRODUCT_ID(dto.getPRODUCT_ID())
                .USER_ID(userID)
                .build();

        paymentMapper.create(params);
    }

    public Long paid (PaymentDto.PaymentPaidReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);

        PaymentDto.PaymentPaidReq params = PaymentDto.PaymentPaidReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .AMOUNT(dto.getAMOUNT())
                .ORDER_ID(dto.getORDER_ID())
                .PAYMENT_KEY(dto.getPAYMENT_KEY())
                .USER_ID(userID)
                .build();

        return paymentMapper.paid(params);
    }

    public void cancel (PaymentDto.PaymentCanceledReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);

        PaymentDto.PaymentCanceledReq params = PaymentDto.PaymentCanceledReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .ORDER_ID(dto.getORDER_ID())
                .USER_ID(userID)
                .build();

        paymentMapper.cancel(params);
    }

}
