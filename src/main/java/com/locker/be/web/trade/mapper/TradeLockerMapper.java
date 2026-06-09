package com.locker.be.web.trade.mapper;

import com.locker.be.web.trade.dto.TradeLockerDto;
import com.locker.be.web.trade.dto.TradeLockerQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface TradeLockerMapper {

    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> create(TradeLockerDto.TradeLockerLocationCreateReq dto);

    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> update(TradeLockerDto.TradeLockerLocationUpdateReq dto);

    public void delete(TradeLockerDto.TradeLockerLocationDeleteReq dto);

    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> findSelect(TradeLockerQueryDto.TradeLockerLocationReq dto);

    public Collection<TradeLockerQueryDto.TradeLockerLocationRes> findAll();

    public Collection<TradeLockerQueryDto.TradeLockerStateRes> findState(TradeLockerQueryDto.TradeLockerStateReq dto);

    public Collection<TradeLockerQueryDto.TradeLockerImgRes> findImg(TradeLockerQueryDto.TradeLockerImgReq dto);
}
