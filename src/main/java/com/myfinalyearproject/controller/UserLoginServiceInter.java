package com.myfinalyearproject.controller;

import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.domain.UserInfoLogin;

public interface UserLoginServiceInter {

	boolean verifyUser(UserInfoLogin user);
}
