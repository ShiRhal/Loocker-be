package com.locker.be.web.trade.service;

import com.locker.be.web.trade.dto.TradeDto;
import com.locker.be.web.trade.dto.TradeQueryDto;
import com.locker.be.web.trade.mapper.TradeMapper;
import com.locker.be.web.user.util.JwtUtil;
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
    private final TradeDeliveryDemoService tradeDeliveryDemoService;

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

    public String update (TradeDto.TradeUpdateReq dto, String token) {
        if (token == null || token.isBlank()) {
            tradeMapper.update(dto);
            return dto.getRESULT_STATUS_CODE();
        }

        Long userID = jwtUtil.getUserId(token);
        TradeDto.TradeUpdateReq params = TradeDto.TradeUpdateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .NEXT_STATUS_CODE(dto.getNEXT_STATUS_CODE())
                .TRADE_TYPE_CODE(dto.getTRADE_TYPE_CODE())
                .build();
        tradeMapper.update(params);
        String resultStatusCode = params.getRESULT_STATUS_CODE();
        if ("DELIVERY".equals(params.getTRADE_TYPE_CODE()) && ("PAID".equals(resultStatusCode))) {
            tradeDeliveryDemoService.start(params.getTRADE_ID());
        }
        return resultStatusCode;
    }

    // @Transactional(readOnly = true)
    public Collection<TradeQueryDto.TradeIdRes> findId(TradeQueryDto.TradeIdReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeQueryDto.TradeIdReq params = TradeQueryDto.TradeIdReq.builder()
                .PRODUCT_ID(dto.getPRODUCT_ID())
                .USER_ID(userID)
                .build();
        return tradeMapper.findId(params);
    }

    // @Transactional(readOnly = true)
    public Collection<TradeQueryDto.TradeRes> findAll(TradeQueryDto.TradeReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeQueryDto.TradeReq params = TradeQueryDto.TradeReq.builder()
                .PRODUCT_ID(dto.getPRODUCT_ID())
                .USER_ID(userID)
                .build();
        return tradeMapper.findAll(params);
    }
}
