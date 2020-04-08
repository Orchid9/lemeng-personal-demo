package com.lemeng.personal.controller;

import com.lemeng.personal.dto.UserInfoDTO;
import com.lemeng.personal.model.UserInfo;
import com.lemeng.personal.service.UserInfoService;
import com.nhsoft.provider.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@Api("用户信息")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @ApiOperation("查询用户信息")
    @GetMapping("nhsoft.demo.user.info.read")
    public Response readUserInfo(@ApiParam("用户id") String userId) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        UserInfo userInfo = userInfoService.readUserInfo(userId);
        BeanUtils.copyProperties(userInfo, userInfoDTO);
        return Response.data(userInfoDTO);
    }

    /**
     * 保存更新用户信息
     *
     * @param userInfoDTO 用户信息
     * @return 保存更新的用户信息
     */
    @ApiOperation("保存更新用户信息")
    @PostMapping("nhsoft.demo.user.info.save")
    public Response saveUserInfo(@ApiParam("用户信息") UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        return Response.data(userInfoService.saveUserInfo(userInfo));
    }

    /**
     * 删除用户信息
     *
     * @param studentId 用户信息
     * @return 删除结果
     */
    @ApiOperation("删除用户信息")
    @DeleteMapping("nhsoft.demo.user.info.delete")
    public Response deleteUserInfo(@ApiParam("学科id") String studentId) {
        userInfoService.deleteUserInfoById(studentId);
        return Response.empty();
    }
}
