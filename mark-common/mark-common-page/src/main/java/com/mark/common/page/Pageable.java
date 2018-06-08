/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page;

import java.util.List;

/**
 * 
 * @author mark
 * @date 2017年10月11日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public abstract interface Pageable {
    public abstract PageType getPageType();

    public abstract Long getTotalCount();

    public abstract Integer getTotalPage();

    public abstract Integer getPageSize();

    public abstract Integer getPageNo();

    public abstract Integer getStep();

    public abstract Boolean getHasNext();

    public abstract Boolean getHasPrev();

    public abstract List<Element> getElements();
}
