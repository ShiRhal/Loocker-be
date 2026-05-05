package com.locker.be.web.payment.mapper;

import com.locker.be.web.payment.dto.PaymentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    public void create(PaymentDto.PaymentCreateReq dto);

    public Long paid(PaymentDto.PaymentPaidReq dto);

    public void cancel(PaymentDto.PaymentCanceledReq dto);
}
