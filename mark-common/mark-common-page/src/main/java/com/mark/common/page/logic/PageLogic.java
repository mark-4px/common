/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mark.common.page.Element;
import com.mark.common.page.ElementType;

/**
 * 
 * @author mark
 * @date 2017年10月11日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public abstract class PageLogic implements Serializable {
    private static final long serialVersionUID = -1291904389514892490L;
    protected final Long totalCount;
    protected final Integer totalPage;
    protected final Integer pageSize;
    protected final Integer pageNo;
    private int step = 3;

    public PageLogic(Long totalCount, Integer totalPage, Integer pageSize, Integer pageNo) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public PageLogic(Long totalCount, Integer totalPage, Integer pageSize, Integer pageNo, Integer step) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.step = (step.intValue() > 0 ? step.intValue() : this.step);
    }

    public abstract List<Element> previous();

    public abstract List<Element> next();

    protected Element first() {
        return point(1);
    }

    protected Element last() {
        return point(this.totalPage.intValue());
    }

    protected Element one(int page) {
        return Element.create(page);
    }

    protected Element one(int page, boolean enable) {
        return Element.create(page, enable);
    }

    protected void sequence(List<Element> es, int start, int end) {
        for (int i = start; i < end; i++) {
            es.add(Element.create(i));
        }
    }

    protected void current(List<Element> es, int start, int end) {
        for (int i = start; i <= end; i++) {
            es.add(Element.create(i, i != this.pageNo.intValue()));
        }
    }

    protected Element point(int point) {
        return Element.create(point, point != this.pageNo.intValue(), point == 1 ? ElementType.FIRST : ElementType.LAST);
    }

    protected Element point(int point, ElementType elementType) {
        return Element.create(point, (point != this.pageNo.intValue()) && (point > 0), elementType);
    }

    protected void omit(List<Element> es) {
        es.add(Element.create(-1, false, ElementType.NONE));
    }

    public List<Element> execute() {
        List<Element> elements = new ArrayList<Element>();

        Element f = first();
        if (null != f) {
            elements.add(f);
        }
        List<Element> p = previous();
        if ((null != p) && (p.size() > 0)) {
            elements.addAll(p);
        }
        List<Element> n = next();
        if ((null != n) && (n.size() > 0)) {
            elements.addAll(n);
        }
        Element l = last();
        if (null != l) {
            elements.add(l);
        }
        return elements;
    }

    public Integer getStep() {
        return Integer.valueOf(this.step);
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }
}
