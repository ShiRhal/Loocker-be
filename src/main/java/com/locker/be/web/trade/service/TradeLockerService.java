package com.locker.be.web.trade.service;

import com.locker.be.web.trade.dto.TradeLockerDto;
import com.locker.be.web.trade.dto.TradeLockerQueryDto;
import com.locker.be.web.trade.mapper.TradeLockerMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class TradeLockerService {

    private final TradeLockerMapper tradeLockerMapper;
    private final JwtUtil jwtUtil;

    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> create (TradeLockerDto.TradeLockerLocationCreateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerDto.TradeLockerLocationCreateReq params = TradeLockerDto.TradeLockerLocationCreateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .KIOSK_ID(dto.getKIOSK_ID())
                .USER_ID(userID)
                .build();
        return tradeLockerMapper.create(params);
    }

    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> update (TradeLockerDto.TradeLockerLocationUpdateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerDto.TradeLockerLocationUpdateReq params = TradeLockerDto.TradeLockerLocationUpdateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .KIOSK_ID(dto.getKIOSK_ID())
                .USER_ID(userID)
                .build();
        return tradeLockerMapper.update(params);
    }

    public void delete (TradeLockerDto.TradeLockerLocationDeleteReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerDto.TradeLockerLocationDeleteReq params = TradeLockerDto.TradeLockerLocationDeleteReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .build();
        tradeLockerMapper.delete(params);
    }

    // @Transactional(readOnly = true)
    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> findSelect(TradeLockerQueryDto.TradeLockerLocationReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        TradeLockerQueryDto.TradeLockerLocationReq params = TradeLockerQueryDto.TradeLockerLocationReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .build();
        return tradeLockerMapper.findSelect(params);
    }

    // @Transactional(readOnly = true)
    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> findAll() {

        return tradeLockerMapper.findAll();
    }

    // @Transactional(readOnly = true)
    public Collection<TradeLockerQueryDto.TradeLockerStateRes> findState(TradeLockerQueryDto.TradeLockerStateReq dto) {

        return tradeLockerMapper.findState(dto);
    }
}
