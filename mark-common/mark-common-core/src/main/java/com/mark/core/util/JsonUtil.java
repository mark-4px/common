/*
 * Copyright (c) 2013, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.core.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.mark.core.json.JsonMapper;

/**
 * json工具
 * 
 * @author sunkey
 * @date Jun 11, 2014
 */
public class JsonUtil {

    private final static JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();

    /**
     * Object可以是POJO，也可以是Collection或数组。 若Object为null则直接返回null. 如果集合为空集合, 返回"[]".
     */
    public static String toJson(Object object) {
        return (object != null ? jsonMapper.toJson(object) : null);
    }

    /**
     * 反序列化POJO或简单Collection如List<String>.
     * 
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     * 
     * 如需反序列化复杂Collection如List<MyBean>, 请使用fromJson(String,JavaType)
     * 
     * @see #fromJson(String, JavaType)
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return jsonMapper.fromJson(jsonString, clazz);
    }

    /**
     * 反序列化复杂Collection如List<Bean>, 先使用函數createCollectionType构造类型,然后调用本函数.
     * 
     * @see #createCollectionType(Class, Class...)
     */
    public static <T> T fromJson(String jsonString, JavaType javaType) {
        return jsonMapper.fromJson(jsonString, javaType);
    }

    /**
     * 构造泛型的Collection Type如: ArrayList<MyBean>,
     * 则调用constructCollectionType(ArrayList.class,MyBean.class)
     * HashMap<String,MyBean>, 则调用(HashMap.class,String.class, MyBean.class)
     */
    public static JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return jsonMapper.createCollectionType(collectionClass, elementClasses);
    }

    /**
     * 将json字符串转换成树形结构
     * 
     * @param jsonString json字符串
     * @return
     */
    public static JsonNode fromJson(String jsonString) {
        return jsonMapper.fromJson(jsonString);
    }
}
