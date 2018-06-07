/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.core.exception;

/**
 *
 * @author mark
 * @date 2018年5月9日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public class UnauthorizedException extends BusinessException {

    public UnauthorizedException(String errCode, String errMsg) {
        super(errCode, errMsg);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    private static final long serialVersionUID = 2963695387086944272L;

}
