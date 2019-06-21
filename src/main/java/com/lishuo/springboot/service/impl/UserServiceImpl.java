package com.lishuo.springboot.service.impl;

import com.lishuo.springboot.mapper.UserMapper;
import com.lishuo.springboot.pojo.UserEntity;
import com.lishuo.springboot.pojo.UserPojo;
import com.lishuo.springboot.service.UserService;
import com.lishuo.springboot.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService<UserEntity> implements UserService {


}
