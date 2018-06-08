/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page.logic;

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
public final class ComplexLogic extends PageLogic {
    private static final long serialVersionUID = 4303777043889644540L;

    public ComplexLogic(Long totalCount, Integer totalPage, Integer pageSize, Integer pageNo, Integer step) {
        super(totalCount, totalPage, pageSize, pageNo, step);
    }

    protected Element first() {
        return this.pageNo.intValue() > 1 ? point(this.pageNo.intValue() - 1, ElementType.FIRST) : point(-1, ElementType.FIRST);
    }

    public List<Element> previous() {
        List<Element> es = new ArrayList<Element>();
        if (this.pageNo.intValue() < 2 * getStep().intValue()) {
            current(es, 1, this.pageNo.intValue() < getStep().intValue() ? getStep().intValue() : this.pageNo.intValue() + 1);
            omit(es);
        } else {
            sequence(es, 1, getStep().intValue());
            omit(es);
            if (this.pageNo.intValue() <= this.totalPage.intValue() - (2 * getStep().intValue() - 1)) {
                current(es, this.pageNo.intValue() - getStep().intValue() / 2, this.pageNo.intValue() + getStep().intValue() / 2);
                omit(es);
            }
        }
        return es;
    }

    public List<Element> next() {
        List<Element> es = new ArrayList<Element>();
        if (this.pageNo.intValue() <= this.totalPage.intValue() - (2 * getStep().intValue() - 1)) {
            sequence(es, this.totalPage.intValue() - getStep().intValue() / 2, this.totalPage.intValue() + 1);
        } else if (this.pageNo.intValue() >= this.totalPage.intValue() - getStep().intValue() / 2) {
            current(es, this.totalPage.intValue() - (getStep().intValue() - 1), this.totalPage.intValue());
        } else {
            current(es, this.pageNo.intValue() - 1, this.totalPage.intValue());
        }
        return es;
    }

    protected Element last() {
        return this.pageNo.intValue() < this.totalPage.intValue() ? point(this.pageNo.intValue() + 1, ElementType.LAST) : point(-1, ElementType.LAST);
    }
}
