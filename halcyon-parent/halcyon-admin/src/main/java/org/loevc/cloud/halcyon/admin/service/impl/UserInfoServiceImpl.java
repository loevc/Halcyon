package org.loevc.cloud.halcyon.admin.service.impl;

import org.loevc.cloud.halcyon.admin.service.UserInfoService;
import org.loevc.cloud.halcyon.common.entity.UserInfo;
import org.loevc.cloud.halcyon.common.entity.UserInfoKotlin;

import java.util.Collections;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {


    @Override
    public List<UserInfo> getUserList() {
        UserInfoKotlin userInfoKotlin = new UserInfoKotlin();
        return Collections.emptyList();
    }
}
