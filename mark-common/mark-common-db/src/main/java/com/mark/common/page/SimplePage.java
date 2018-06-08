/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page;

import com.mark.common.page.logic.ComplexLogic;
import com.mark.common.page.logic.ConsecutiveLogic;
import com.mark.common.page.logic.PageLogic;
import com.mark.common.page.logic.SimpleLogic;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author mark
 * @date 2017年10月11日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public class SimplePage implements Pageable, Serializable {
    private static final long serialVersionUID = -1808994039724824854L;
    private List<Element> elements;
    private Long totalCount = Long.valueOf(0L);
    private Integer pageSize = Integer.valueOf(10);
    private Integer pageNo = Integer.valueOf(1);
    private Integer step = Integer.valueOf(-1);
    private PageLogic logic;
    private PageType pageType;

    public SimplePage() {
    }

    public SimplePage(Integer pageNo, Integer pageSize, Long totalCount) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);

        setPageType(PageType.SIMPLE);
        setStep(this.logic.getStep());
    }

    public SimplePage(Integer pageNo, Integer pageSize, Long totalCount, PageType pageType) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);

        setPageType(pageType);
        setStep(this.logic.getStep());
    }

    public SimplePage(Integer pageNo, Integer pageSize, Long totalCount, Integer step, PageType pageType) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);
        setStep(step);

        setPageType(pageType);
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
        selector(pageType);
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = Long.valueOf(totalCount.longValue() < 0L ? 0L : totalCount.longValue());
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = Integer.valueOf((null == pageSize) || (pageSize.intValue() < 1) ? 10 : pageSize.intValue());
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = Integer.valueOf((null == pageNo) || (pageNo.intValue() < 1) ? 1 : pageNo.intValue());
        this.pageNo = (this.pageNo.intValue() > getTotalPage().intValue() ? getTotalPage() : this.pageNo);
    }

    private void setStep(Integer step) {
        this.step = step;
    }

    private void selector(PageType pageType) {
        switch (pageType) {
        case COMPLEX:
            this.logic = new ComplexLogic(getTotalCount(), getTotalPage(), getPageSize(), getPageNo(), getStep());
            break;
        case CONSECUTIVE:
            this.logic = new ConsecutiveLogic(getTotalCount(), getTotalPage(), getPageSize(), getPageNo(), getStep());

            break;
        case SIMPLE:
        default:
            this.logic = new SimpleLogic(getTotalCount(), getTotalPage(), getPageSize(), getPageNo(), getStep());
        }
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public PageType getPageType() {
        return this.pageType;
    }

    public Integer getTotalPage() {
        Long page = Long.valueOf(this.totalCount.longValue() / this.pageSize.intValue());
        return Integer.valueOf(String.valueOf(this.totalCount.longValue() % this.pageSize.intValue() == 0L ? page.longValue() : page.longValue() + 1L));
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public Integer getStep() {
        return this.step;
    }

    public Boolean getHasPrev() {
        return Boolean.valueOf(this.pageNo.intValue() > 1);
    }

    public Boolean getHasNext() {
        return Boolean.valueOf(getTotalPage().intValue() > getPageNo().intValue());
    }

    public List<Element> getElements() {
        this.elements = this.logic.execute();
        return this.elements;
    }
}
