package com.drafire.user;

import com.drafire.user.dto.LoginRequest;
import com.drafire.user.dto.LoginResponse;

public interface IUserService {
    /**
     * 登录
     * @param request
     * @return
     */
    LoginResponse login(LoginRequest request);
}
