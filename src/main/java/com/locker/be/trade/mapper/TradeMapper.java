package com.locker.be.trade.mapper;

import com.locker.be.trade.dto.TradeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TradeMapper {

    public Long create(TradeDto.TradeCreateReq dto);

    public void update(TradeDto.TradeUpdateReq dto);
}
