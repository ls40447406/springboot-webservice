package com.lishuo.springboot.utils;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;


/**
 * Mapper接口：基本的增、删、改、查方法
   MySqlMapper：针对MySQL的额外补充接口，支持批量插入*/
@Component
public interface BaseMapper<T> extends Mapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
    //注意: 该类不能被扫描到  否则会报错
}
