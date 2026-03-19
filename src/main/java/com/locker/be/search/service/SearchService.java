package com.locker.be.search.service;

import com.locker.be.search.dto.SearchDto;
import com.locker.be.search.dto.SearchQueryDto;
import com.locker.be.search.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {

    private final SearchMapper searchMapper;

    // @Transactional(readOnly = true)
    public Collection<SearchQueryDto.SearchRes> findAll() {

        return searchMapper.findAll();
    }


    public void create(SearchDto.SearchReq dto) {
        searchMapper.create(dto);
    }

}
