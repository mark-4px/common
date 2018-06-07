/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.core.exception;

/**
 * 
 *
 * @author mark
 * @date 2018年5月9日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public class ErrorConstants {
    
    public static final String RESPONSE_CODE_KEY = "errCode";
    
    public static final String RESPONSE_MSG_KEY = "errMsg";
    
    public static final String RESPONSE_DATA_KEY =  "data"; 
    
    //系统异常 code范围:00001~19999
    /**
     * 系统错误
     */
    public static final String SYSTEM_ERROR = "00001";

    /**
     * 系统繁忙
     */
    public static final String SYSTEM_BUSY = "00002";
    
    /**
     * Json解析异常
     */
    public static final String SYSTEM_JSON_PARSE_EXCEPTION = "00003";

    /**
     * 会话超时
     */
    public static final String SYSTEM_SESSION_TIMEOUT = "00004";
    
    /**
     * HTTP消息不能读取
     */
    public static final String  SYSTEM_HTTP_MESSAGE_NOT_READABLE = "00005";

    /**
     * 数据重复
     */
    public static final String SYSTEM_DUPLICATE_DATA = "00006";

    /**
     * 不支持的媒体类型
     */
    public static final String SYSTEM_NOT_SUPPORTED_MEDIA_TYPE = "00007";

    /**
     * 数据绑定错误
     */
    public static final String  SYSTEM_DATA_BIND_ERROR = "00008";
    
    /**
     * 未认证(没有权限)
     */
    public static final String SYSTEM_UN_AUTH = "00009";
    /**
     * 未登录
     */
    public static final String SYSTEM_UN_LOGIN = "unLogin";
    
    //业务运行时异常 code范围:20000~29999
    
    //业务受检异常  code范围:30000~39999
    //用户名错误
    public static final String BUSINESS_ACCOUNT_ERROR = "30000";
    
    //密码错误
    public static final String BUSINESS_PWD_ERROR = "30001";
    
    
    public static final String SYSTEM_ERROR_MSG ="系统异常";
    
    
    public static final String SYSTEM_BUSY_MSG="系统繁忙";
    
}
