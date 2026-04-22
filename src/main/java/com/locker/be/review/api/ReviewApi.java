package com.locker.be.review.api;

import com.locker.be.review.dto.ReviewDto;
import com.locker.be.review.dto.ReviewQueryDto;
import com.locker.be.review.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("review")
@Tag(name = "리뷰 API")
public class ReviewApi {

    private final ReviewService reviewService;

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 리뷰에 대한 데이터를 반환합니다.")
    public Collection<ReviewQueryDto.ReviewRes> findAll(ReviewQueryDto.ReviewReq dto) {
        return reviewService.findAll(dto);
    }

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public Long create(@RequestBody final ReviewDto.ReviewCreateReq dto) {
        return reviewService.create(dto);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void update(@RequestBody final ReviewDto.ReviewUpdateReq dto) {
        reviewService.update(dto);
    }
}
