package com.locker.be.code.api;

import com.locker.be.code.service.CodeService;
import com.locker.be.code.dto.CodeQueryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("code")
@Tag(name = "코드 API", description = "코드들을 위한 API 입니다.")
public class CodeApi {

    private final CodeService codeService;

    @GetMapping("/state")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<CodeQueryDto.StateRes> findState() {
        return codeService.findState();
    }

    @GetMapping("/city")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<CodeQueryDto.CityRes> findCity() {
        return codeService.findCity();
    }

    @GetMapping("/main/category")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<CodeQueryDto.MainCategoryRes> findMainCategory() {
        return codeService.findMainCategory();
    }

    @GetMapping("/sub/category")
    @Operation(summary = "검색조건에 따른 상품 리스트에 대한 데이터를 반환합니다.")
    public Collection<CodeQueryDto.SubCategoryRes> findSubCategory() {
        return codeService.findSubCategory();
    }

}
