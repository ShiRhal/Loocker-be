package com.locker.be.web.code.service;

import com.locker.be.web.code.mapper.CodeMapper;
import com.locker.be.web.code.dto.CodeQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeService {

    private final CodeMapper codeMapper;

    // @Transactional(readOnly = true)
    public Collection<CodeQueryDto.StateRes> findState() {

        return codeMapper.findState();
    }

    // @Transactional(readOnly = true)
    public Collection<CodeQueryDto.CityRes> findCity() {

        return codeMapper.findCity();
    }

    // @Transactional(readOnly = true)
    public Collection<CodeQueryDto.MainCategoryRes> findMainCategory() {

        return codeMapper.findMainCategory();
    }

    // @Transactional(readOnly = true)
    public Collection<CodeQueryDto.SubCategoryRes> findSubCategory() {

        return codeMapper.findSubCategory();
    }

}
