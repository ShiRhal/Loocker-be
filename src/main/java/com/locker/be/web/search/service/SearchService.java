package com.locker.be.web.search.service;

import com.locker.be.web.search.dto.SearchDto;
import com.locker.be.web.search.dto.SearchQueryDto;
import com.locker.be.web.search.mapper.SearchMapper;
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
