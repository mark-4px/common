/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.db.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mark.common.domain.query.BookQuery;
import com.mark.common.service.IBookService;

/**
 * 
 * @author mark
 * @date 2018年5月9日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        
        IBookService bookService = context.getBean(IBookService.class);

        long count = bookService.count(new BookQuery());
        
        logger.info("count {}", count);

        context.close();
    }

}
