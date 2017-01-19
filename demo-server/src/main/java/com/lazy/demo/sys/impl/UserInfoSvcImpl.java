package com.lazy.demo.sys.impl;

import org.springframework.stereotype.Service;

import com.lazy.demo.sys.UserInfoSvc;

@Service
public class UserInfoSvcImpl implements UserInfoSvc {

    public String getName(Long userId) {
        
        
        return userId+" name is hello.";
    }

}

	