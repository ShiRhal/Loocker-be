package com.locker.be.web.admin.service;

import com.locker.be.web.admin.dto.AdminQueryDto;
import com.locker.be.web.admin.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;

    // @Transactional(readOnly = true)
    public Collection<AdminQueryDto.AdminRes> login(AdminQueryDto.AdminReq dto) {

        return adminMapper.login(dto);
    }

}
