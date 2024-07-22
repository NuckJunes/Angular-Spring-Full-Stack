package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.mappers.BasicUserMapper;
import com.greenteam.FullStackApplication.mappers.FullUserMapper;
import com.greenteam.FullStackApplication.repositories.UserRepository;
import com.greenteam.FullStackApplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    /* Mappers */
    private final BasicUserMapper basicUserMapper;
    private final FullUserMapper fullUserMapper;

    /* Repositories */
    private final UserRepository userRepository;
}
