package org.loevc.cloud.halcyon.admin.controller;

import org.loevc.cloud.halcyon.admin.service.UserInfoService;
import org.loevc.cloud.halcyon.common.entity.UserInfo;

import java.util.List;

public class UserInfoController {

    private UserInfoService userInfoService;

    public List<UserInfo> getUser(){
        return userInfoService.getUserList();
    }

}