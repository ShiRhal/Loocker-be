package com.locker.be.web.search.api;

import com.locker.be.web.search.dto.SearchDto;
import com.locker.be.web.search.dto.SearchQueryDto;
import com.locker.be.web.search.service.SearchService;
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
@RequestMapping("web/search")
@Tag(name = "검색로그 API", description = "SP에서 입력이 진행 되기에 입력 api 호출은 하지 않습니다. {참고용}")
public class SearchApi {

    private final SearchService searchService;

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<SearchQueryDto.SearchRes> findAll() {
        return searchService.findAll();
    }

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void create(@RequestBody final SearchDto.SearchReq dto) {
        searchService.create(dto);
    }
}
