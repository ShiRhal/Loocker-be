package com.locker.be.trade.service;

import com.locker.be.trade.dto.TradeDto;
import com.locker.be.trade.mapper.TradeMapper;
import com.locker.be.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TradeService {

    private final TradeMapper tradeMapper;
    private final JwtUtil jwtUtil;

    public Long create (TradeDto.TradeInsertReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);

        TradeDto.TradeInsertReq params = TradeDto.TradeInsertReq.builder()
                .PRODUCT_ID(dto.getPRODUCT_ID())
                .USER_ID(userID)
                .TRADE_TYPE_CODE(dto.getTRADE_TYPE_CODE())
                .build();

        return tradeMapper.create(params);
    }
}
