/*
 * Copyright (c) 2016, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用控制器
 * 
 * @author mark
 * @date 2018年5月9日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

    /**
     * 错误页面
     * 
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = "/error/{code}")
    public String errer(@PathVariable(value = "code") String code, Model model) {

        return "error_" + code;
    }

    /**
     * 空白页
     * 
     * @return
     */
    @RequestMapping(value = "/dashboard")
    public String blank() {
        return "dashboard";
    }

}
