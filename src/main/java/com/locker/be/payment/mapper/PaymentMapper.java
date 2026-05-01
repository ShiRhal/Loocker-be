package com.locker.be.payment.mapper;

import com.locker.be.payment.dto.PaymentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface PaymentMapper {

    public void create(PaymentDto.PaymentCreateReq dto);

    public Long paid(PaymentDto.PaymentPaidReq dto);

    public void cancel(PaymentDto.PaymentCanceledReq dto);
}
