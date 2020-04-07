package com.lemeng.personal.service.impl;

import com.lemeng.personal.model.UserInfo;
import com.lemeng.personal.repository.UserInfoRepository;
import com.lemeng.personal.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 张九星
 * @create 2020/4/7 17:37
 */
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo readUserInfo(String userId) {
        return userInfoRepository.getOne(userId);
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public void deleteUserInfoById(String studentId) {
        userInfoRepository.deleteById(studentId);
    }
}
