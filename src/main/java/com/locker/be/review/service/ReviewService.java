package com.locker.be.review.service;

import com.locker.be.review.dto.ReviewDto;
import com.locker.be.review.mapper.ReviewMapper;
import com.locker.be.review.dto.ReviewQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public Long create(ReviewDto.ReviewCreateReq dto) {
        return reviewMapper.create(dto);
    }

    public void update(ReviewDto.ReviewUpdateReq dto) {
        reviewMapper.update(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<ReviewQueryDto.ReviewRes> findAll(ReviewQueryDto.ReviewReq dto) {

        return reviewMapper.findAll(dto);
    }
}
