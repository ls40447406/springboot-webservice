package com.lishuo.springboot.mapper;

import com.lishuo.springboot.pojo.UserEntity;
import com.lishuo.springboot.utils.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<UserEntity> {

}
