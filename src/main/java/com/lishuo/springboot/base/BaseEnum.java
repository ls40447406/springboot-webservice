package com.lishuo.springboot.base;

/**
 * 基础数据枚举类
 */
public interface BaseEnum<K,V> {

    /**
     * 获取编码
     *
     * @return 编码
     */
    K code();

    /**
     * 获取描述
     *
     * @return 描述
     */
    V desc();

}
