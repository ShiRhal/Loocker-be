package com.locker.be.trade.service;

import com.locker.be.trade.dto.TradeDto;
import com.locker.be.trade.dto.TradeQueryDto;
import com.locker.be.trade.mapper.TradeMapper;
import com.locker.be.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class TradeService {

    private final TradeMapper tradeMapper;
    private final JwtUtil jwtUtil;

    public Long create (TradeDto.TradeCreateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);

        TradeDto.TradeCreateReq params = TradeDto.TradeCreateReq.builder()
                .PRODUCT_ID(dto.getPRODUCT_ID())
                .USER_ID(userID)
                .TRADE_TYPE_CODE(dto.getTRADE_TYPE_CODE())
                .build();

        tradeMapper.create(params);
        return params.getTRADE_ID();
    }

    public void update (TradeDto.TradeUpdateReq dto, String token) {
        if (token == null || token.isBlank()) {
            tradeMapper.update(dto);
            return;
        }

        Long userID = jwtUtil.getUserId(token);
        TradeDto.TradeUpdateReq params = TradeDto.TradeUpdateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .NEXT_STATUS_CODE(dto.getNEXT_STATUS_CODE())
                .build();
        tradeMapper.update(params);
    }

    // @Transactional(readOnly = true)
    public Collection<TradeQueryDto.TradeRes> findId(TradeQueryDto.TradeReq dto) {

        return tradeMapper.findId(dto);
    }
}
