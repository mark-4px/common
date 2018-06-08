/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page.logic;

import java.util.ArrayList;
import java.util.List;

import com.mark.common.page.Element;

/**
 * 
 * @author mark
 * @date 2017年10月11日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public final class SimpleLogic extends PageLogic {
    private static final long serialVersionUID = -5397164841615598822L;

    public SimpleLogic(Long totalCount, Integer totalPage, Integer pageSize, Integer pageNo) {
        super(totalCount, totalPage, pageSize, pageNo);
    }

    public SimpleLogic(Long totalCount, Integer totalPage, Integer pageSize, Integer pageNo, Integer step) {
        super(totalCount, totalPage, pageSize, pageNo, step);
    }

    public List<Element> previous() {
        List<Element> es = new ArrayList<Element>(1);

        boolean b = this.pageNo.intValue() > 1;
        es.add(one(b ? this.pageNo.intValue() - 1 : this.pageNo.intValue(), b));

        return es;
    }

    public List<Element> next() {
        List<Element> es = new ArrayList<Element>(1);

        boolean b = this.pageNo.intValue() < this.totalPage.intValue();
        es.add(one(b ? this.pageNo.intValue() + 1 : this.pageNo.intValue(), b));

        return es;
    }
}
