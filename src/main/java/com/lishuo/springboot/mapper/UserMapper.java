package com.lishuo.springboot.mapper;

import com.lishuo.springboot.pojo.UserEntity;
import com.lishuo.springboot.pojo.UserPojo;
import com.lishuo.springboot.utils.MapperBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper extends MapperBase<UserEntity> {

}
