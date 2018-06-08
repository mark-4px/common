/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page;

/**
 * 
 * @author mark
 * @date 2017年10月11日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public enum ElementType {
    FIRST("F"), MIDDLE("M"), LAST("L"), NONE("NA");

    private String type;

    private ElementType(String type) {
        this.type = type;
    }

    public String toString() {
        return this.type;
    }
}
