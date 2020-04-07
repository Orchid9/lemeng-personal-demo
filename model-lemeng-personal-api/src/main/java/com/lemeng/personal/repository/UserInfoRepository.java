package com.lemeng.personal.repository;

import com.lemeng.personal.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo> {

}