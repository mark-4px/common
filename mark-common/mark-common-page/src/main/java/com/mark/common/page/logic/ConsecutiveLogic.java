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
public final class ConsecutiveLogic extends PageLogic {
    private static final long serialVersionUID = -6244837545189150594L;
    private int mystep = 9;

    public ConsecutiveLogic(Long totalCount, Integer totalPage, Integer pageSize, Integer pageNo) {
        super(totalCount, totalPage, pageSize, pageNo);
    }

    public ConsecutiveLogic(Long totalCount, Integer totalPage, Integer pageSize, Integer pageNo, Integer step) {
        super(totalCount, totalPage, pageSize, pageNo, step);
    }

    private int rate() {
        return getStep().intValue() / 2 - 2;
    }

    public Integer getStep() {
        int i = super.getStep().intValue() > this.mystep ? super.getStep().intValue() : this.mystep;
        return Integer.valueOf(i > this.totalPage.intValue() ? this.totalPage.intValue() : i);
    }

    protected Element first() {
        return this.pageNo.intValue() > 1 ? point(this.pageNo.intValue() - 1, ElementType.FIRST) : null;
    }

    public List<Element> previous() {
        List<Element> es = new ArrayList<Element>();
        if (getStep().intValue() < this.totalPage.intValue()) {
            if (this.pageNo.intValue() <= rate() + 1) {
                current(es, 1, getStep().intValue());
                es.add(one(this.totalPage.intValue()));
            } else if (this.pageNo.intValue() <= this.totalPage.intValue() - (getStep().intValue() - rate())) {
                es.add(one(1));
                current(es, this.pageNo.intValue() - rate(), this.pageNo.intValue() - rate() + getStep().intValue() - 1);
                es.add(one(this.totalPage.intValue()));
            } else if (this.pageNo.intValue() > this.totalPage.intValue() - (getStep().intValue() - rate())) {
                es.add(one(1));
                current(es, this.pageNo.intValue() - rate(), this.totalPage.intValue());
            }
        } else {
            current(es, 1, this.totalPage.intValue());
        }
        return es;
    }

    public List<Element> next() {
        return null;
    }

    protected Element last() {
        return this.pageNo.intValue() < this.totalPage.intValue() ? point(this.pageNo.intValue() + 1, ElementType.LAST) : null;
    }
}
