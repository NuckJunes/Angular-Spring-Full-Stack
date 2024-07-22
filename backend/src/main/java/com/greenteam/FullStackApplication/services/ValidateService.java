package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.entities.User;

public interface ValidateService {
    User findUser(String username);
}
