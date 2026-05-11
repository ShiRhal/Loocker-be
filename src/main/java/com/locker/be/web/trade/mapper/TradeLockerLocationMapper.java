package com.locker.be.web.trade.mapper;

import com.locker.be.web.trade.dto.TradeLockerLocationDto;
import com.locker.be.web.trade.dto.TradeLockerLocationQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface TradeLockerLocationMapper {

    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> create(TradeLockerLocationDto.TradeLockerLocationCreateReq dto);

    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> update(TradeLockerLocationDto.TradeLockerLocationUpdateReq dto);

    public void delete(TradeLockerLocationDto.TradeLockerLocationDeleteReq dto);

    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> findSelect(TradeLockerLocationQueryDto.TradeLockerLocationReq dto);

    public Collection<TradeLockerLocationQueryDto.TradeLockerLocationRes> findAll();
}
