package com.locker.be.review.mapper;

import com.locker.be.review.dto.ReviewDto;
import com.locker.be.review.dto.ReviewQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface ReviewMapper {

    public Long create (ReviewDto.ReviewCreateReq dto);

    public void update (ReviewDto.ReviewUpdateReq dto);

    public Collection<ReviewQueryDto.ReviewRes> findAll(ReviewQueryDto.ReviewReq dto);
}
