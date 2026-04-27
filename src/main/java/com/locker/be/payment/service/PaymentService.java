package com.locker.be.payment.service;

import com.locker.be.payment.dto.PaymentDto;
import com.locker.be.payment.mapper.PaymentMapper;
import com.locker.be.user.util.JwtUtil;
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

}
