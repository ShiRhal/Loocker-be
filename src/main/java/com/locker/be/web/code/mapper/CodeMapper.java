package com.locker.be.web.code.mapper;

import com.locker.be.web.code.dto.CodeQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface CodeMapper {

    public Collection<CodeQueryDto.StateRes> findState();

    public Collection<CodeQueryDto.CityRes> findCity();

    public Collection<CodeQueryDto.MainCategoryRes> findMainCategory();

    public Collection<CodeQueryDto.SubCategoryRes> findSubCategory();
}
