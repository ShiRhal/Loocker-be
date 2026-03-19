package com.locker.be.search.mapper;

import com.locker.be.search.dto.SearchDto;
import com.locker.be.search.dto.SearchQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface SearchMapper {

    public void create(SearchDto.SearchReq dto);

    public Collection<SearchQueryDto.SearchRes> findAll();

}
