package com.locker.be.web.trade.service;

import com.locker.be.web.trade.dto.TradeLockerLocationDto;
import com.locker.be.web.trade.dto.TradeLockerLocationQueryDto;
import com.locker.be.web.trade.mapper.TradeLockerLocationMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class TradeLockerLocationService {

    private final TradeLockerLocationMapper tradeLockerLocationMapper;
    private final JwtUtil jwtUtil;

    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> create (TradeLockerLocationDto.TradeLockerLocationCreateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerLocationDto.TradeLockerLocationCreateReq params = TradeLockerLocationDto.TradeLockerLocationCreateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .KIOSK_ID(dto.getKIOSK_ID())
                .USER_ID(userID)
                .build();
        return tradeLockerLocationMapper.create(params);
    }

    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> update (TradeLockerLocationDto.TradeLockerLocationUpdateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerLocationDto.TradeLockerLocationUpdateReq params = TradeLockerLocationDto.TradeLockerLocationUpdateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .KIOSK_ID(dto.getKIOSK_ID())
                .USER_ID(userID)
                .build();
        return tradeLockerLocationMapper.update(params);
    }

    public void delete (TradeLockerLocationDto.TradeLockerLocationDeleteReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerLocationDto.TradeLockerLocationDeleteReq params = TradeLockerLocationDto.TradeLockerLocationDeleteReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .build();
        tradeLockerLocationMapper.delete(params);
    }

    // @Transactional(readOnly = true)
    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> findSelect(TradeLockerLocationQueryDto.TradeLockerLocationReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerLocationQueryDto.TradeLockerLocationReq params = TradeLockerLocationQueryDto.TradeLockerLocationReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .build();
        return tradeLockerLocationMapper.findSelect(params);
    }

    // @Transactional(readOnly = true)
    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> findAll() {

        return tradeLockerLocationMapper.findAll();
    }
}
