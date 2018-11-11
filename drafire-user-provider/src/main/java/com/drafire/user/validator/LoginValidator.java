package com.drafire.user.validator;

import com.drafire.user.dto.LoginRequest;
import org.springframework.util.StringUtils;

public class LoginValidator {
    public static boolean checkUserLoginRequest(LoginRequest request){
        if(StringUtils.isEmpty(request.getName())||StringUtils.isEmpty(request.getPassword())){
            return false;
        }
        return true;
    }
}
