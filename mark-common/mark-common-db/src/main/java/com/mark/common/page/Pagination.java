/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mark
 * @date 2017年10月11日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public class Pagination<T> extends SimplePage implements Serializable, Pageable {
    private static final long serialVersionUID = 6241632276505840392L;
    private List<T> data = new ArrayList<T>();

    public Pagination() {
    }

    public Pagination(Pagination<?> page) {
        this(page.getPageNo(), page.getPageSize(), page.getTotalCount(), page.getPageType());
    }

    public Pagination(Integer pageNo, Integer pageSize, Long totalCount) {
        this(pageNo, pageSize, totalCount, PageType.CONSECUTIVE);
    }

    public Pagination(Integer pageNo, Integer pageSize, Long totalCount, PageType pageType) {
        super(pageNo, pageSize, totalCount, pageType);
    }

    public Pagination(Integer pageNo, Integer pageSize, Long totalCount, Integer step, PageType pageType) {
        super(pageNo, pageSize, totalCount, step, pageType);
    }

    public Integer getFirstResult() {
        return Integer.valueOf((getPageNo().intValue() - 1) * getPageSize().intValue());
    }

    public Integer getMaxResult() {
        return getPageSize();
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
