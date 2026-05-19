package com.locker.be.app.locker.service;

import com.locker.be.app.locker.dto.LockerDto;
import com.locker.be.app.locker.mapper.LockerMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LockerService {

    private final LockerMapper lockerMapper;
    private final JwtUtil jwtUtil;


    public String create (LockerDto.LockerCreateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        LockerDto.LockerCreateReq params = LockerDto.LockerCreateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .LOCKER_ID(dto.getLOCKER_ID())
                .RESULT_STATUS_CODE(dto.getRESULT_STATUS_CODE())
                .build();

        lockerMapper.create(params);
        return params.getRESULT_STATUS_CODE();
    }

    public String update (LockerDto.LockerUpdateReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        LockerDto.LockerUpdateReq params = LockerDto.LockerUpdateReq.builder()
                .TRADE_ID(dto.getTRADE_ID())
                .USER_ID(userID)
                .NEXT_STATUS(dto.getNEXT_STATUS())
                .ROLE_TYPE(dto.getROLE_TYPE())
                .RESULT_STATUS_CODE(dto.getRESULT_STATUS_CODE())
                .build();
        lockerMapper.update(params);
        return params.getRESULT_STATUS_CODE();
    }

}
