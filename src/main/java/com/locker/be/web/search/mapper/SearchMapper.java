package com.locker.be.web.search.mapper;

import com.locker.be.web.search.dto.SearchDto;
import com.locker.be.web.search.dto.SearchQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface SearchMapper {

    public void create(SearchDto.SearchReq dto);

    public Collection<SearchQueryDto.SearchRes> findAll();

}
