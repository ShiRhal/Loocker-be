package com.locker.be.trade.mapper;

import com.locker.be.trade.dto.TradeDto;
import com.locker.be.trade.dto.TradeQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface TradeMapper {

    public Long create(TradeDto.TradeCreateReq dto);

    public String update(TradeDto.TradeUpdateReq dto);

    public Collection<TradeQueryDto.TradeRes> findId(TradeQueryDto.TradeReq dto);
}
