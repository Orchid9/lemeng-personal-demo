package com.lemeng.personal.service;

import com.lemeng.personal.model.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @Author 张九星
 * @create 2020/4/7 17:37
 */
@Service
public interface UserInfoService {

    /**
     * 查询用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    UserInfo readUserInfo(String userId);

    /**
     * 保存更新用户信息
     *
     * @param userInfo 用户信息
     * @return 保存更新的用户信息
     */
    UserInfo saveUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @param studentId 用户信息
     */
    void deleteUserInfoById(String studentId);
}
