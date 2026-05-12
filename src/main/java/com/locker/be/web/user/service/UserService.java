package com.locker.be.web.user.service;

import com.locker.be.web.user.dto.UserDto;
import com.locker.be.web.user.dto.UserQueryDto;
import com.locker.be.web.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public void update(UserDto.UserUpdateReq dto) {
        userMapper.update(dto);
    }

    public void banned(UserDto.UserBannedReq dto) {
        userMapper.banned(dto);
    }

    public void delete(UserDto.UserDeleteReq dto) {
        userMapper.delete(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserProductRes> findPrd(UserQueryDto.UserInfoReq dto) {

        return userMapper.findPrd(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserWishlistRes> findWish(UserQueryDto.UserInfoReq dto) {

        return userMapper.findWish(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserAccountRes> findAccount(UserQueryDto.UserInfoReq dto) {

        return userMapper.findAccount(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserAddressRes> findAddress(UserQueryDto.UserInfoReq dto) {

        return userMapper.findAddress(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserSaleRes> findSale(UserQueryDto.UserInfoReq dto) {

        return userMapper.findSale(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserBuyRes> findBuy(UserQueryDto.UserInfoReq dto) {

        return userMapper.findBuy(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserReviewRes> findReview(UserQueryDto.UserInfoReq dto) {

        return userMapper.findReview(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<UserQueryDto.UserTradeRes> findTrade(UserQueryDto.UserInfoReq dto) {

        return userMapper.findTrade(dto);
    }

    // @Transactional(readOnly = true)
    public UserQueryDto.UserRes findUser(UserQueryDto.UserInfoReq dto) {

        return userMapper.findUser(dto);
    }

    public UserQueryDto.UserInfoRes findInfo(UserQueryDto.UserInfoReq dto) {
        UserQueryDto.UserRes user = findUser(dto);

        UserQueryDto.UserInfoRes res = new UserQueryDto.UserInfoRes();
        res.setUSER(user);
        res.setPRODUCT(findPrd(dto));
        res.setWISHLIST(findWish(dto));
        res.setACCOUNT(findAccount(dto));
        res.setADDRESS(findAddress(dto));
        res.setSALELIST(findSale(dto));
        res.setBUYLIST(findBuy(dto));
        res.setREVIEW(findReview(dto));
        return res;
    }
}
