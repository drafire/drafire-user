package com.drafire.user.impl;

import com.drafire.user.IUserService;
import com.drafire.user.dto.LoginRequest;
import com.drafire.user.dto.LoginResponse;
import com.drafire.user.validator.LoginValidator;
import org.springframework.stereotype.Service;

@Service("userServide")
public class UserServiceImpl implements IUserService {

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        //参数校验
        LoginResponse response=new LoginResponse();
        if(!LoginValidator.checkUserLoginRequest(loginRequest)){
            response.setCode("100001");
            response.setMsg("请求参数校验失败");
            return response;
        }
        if("root".equals(loginRequest.getName())&&"root".equals(loginRequest.getPassword())) {
            response.setCode("000000");
            return response;
        }
        response.setCode("100002");
        response.setMsg("登录失败,帐号或密码错误");
        return response;
    }
}
