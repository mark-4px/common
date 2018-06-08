/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.web.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSONObject;
import com.mark.core.exception.BusinessException;
import com.mark.core.exception.BusinessRuntimeException;
import com.mark.core.exception.ErrorConstants;
import com.mark.core.exception.UnauthorizedException;

/**
 * 
 * 
 * @author mark
 * @date 2018年5月9日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {
    public static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error("请求 发生异常，原因:" + ex.getMessage());
        if (!isAjaxRequest(request)) {
            ModelAndView mView = super.doResolveException(request, response, handler, ex);
            handleResponse(request, response, ex, mView);
            return mView;
        } else {
            response.addHeader("content-type", MediaType.APPLICATION_JSON_VALUE);
            try {
                String responseData = JSONObject.toJSONString(handleResponse(request, response, ex, null));
                PrintWriter writer = response.getWriter();
                writer.write(responseData);
                writer.flush();
            } catch (IOException e) {
                logger.error("获取相应流，发生错误！原因:" + e.getMessage());
            }
            return new ModelAndView();
        }
    }

    /**
     * 判断是否为ajax请求
     * 
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        String xRequestedWith = request.getHeader("X-Requested-With");
        if (StringUtils.isNotBlank(xRequestedWith)) {
            return xRequestedWith.indexOf("XMLHttpRequest") > -1;
        }

        String accpect = request.getHeader("Accept");
        if (StringUtils.isNotBlank(accpect)) {
            return accpect.contains(MediaType.APPLICATION_JSON_VALUE);
        }

        String contentType = request.getHeader("Content-Type");
        if (StringUtils.isNotBlank(contentType)) {
            return contentType.contains(MediaType.APPLICATION_JSON_VALUE);
        }

        return false;
    }

    private Map<String, Object> handleResponse(HttpServletRequest request, HttpServletResponse response, Exception ex, ModelAndView mView) {
        Map<String, Object> result = new HashMap<String, Object>(8);
        String errCode = null;
        String errMsg = ex.getMessage();
        ;
        // 异常分类处理
        if (ex instanceof BusinessException) {
            errCode = ((BusinessException) ex).getErrCode();
        } else if (ex instanceof BusinessRuntimeException) {
            errCode = ((BusinessRuntimeException) ex).getErrCode();
        } else if (ex instanceof UnauthorizedException) {
            errCode = ErrorConstants.SYSTEM_UN_AUTH;
            response.setStatus(401);
            if (mView != null) {
                mView.setViewName("error_401");
            }
        } else if (ex instanceof RuntimeException) {
            errCode = ErrorConstants.SYSTEM_ERROR;
            errMsg = ErrorConstants.SYSTEM_ERROR_MSG;
        } else {
            errCode = ErrorConstants.SYSTEM_BUSY;
            errMsg = ErrorConstants.SYSTEM_BUSY_MSG;
        }
        // 根据code 查找对应国际化资源的错误描述信息，暂时 使用异常消息处理
        if (StringUtils.isNotBlank(errCode)) {
            // errMsg = (ex.getMessage() !=null && ex.getMessage().length() > 100)?
            // ex.getMessage().substring(0,100):ex.getMessage();
            // TODO 国际化处理消息
        }
        result.put("errCode", errCode);
        result.put("errMsg", errMsg);
        if (mView != null) {
            mView.addObject("data", result);
        }
        return result;
    }
}