/*
 * Copyright (c) 2016, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.service;

import java.util.List;

import com.mark.common.domain.Book;
import com.mark.common.domain.query.BookQuery;
import com.mark.common.page.Pagination;

/**
 * Book Service
 * 
 * @author mark.wu
 * @date 2018-05-09
 */
public interface IBookService {

    /**
     * 根据id查询
     * 
     * @param id id
     * @return
     */
    Book getBookByPk(Integer id);

    /**
     * 统计数量
     * 
     * @param query 查询条件对象
     * @return 统计数量
     */
    long count(BookQuery query);

    /**
     * 根据组合条件查询
     * 
     * @param query 查询对象
     * @return 集合,如果不存在,返回Empty List
     */
    List<Book> searchBook(BookQuery query);

    /**
     * 分页查询
     * 
     * @param query 查询对象
     * @return 分页结果,如果不存在,结果集为Empty List
     */
    Pagination<Book> pageBook(BookQuery query);

    /**
     * 保存
     * 
     * @param book
     * @return 操作影响行数
     */
    int insertBook(Book book);

    /**
     * 批量保存
     * 
     * @param books
     * @return 操作影响行数
     */
    int insertBooks(List<Book> books);

    /**
     * 更新
     * 
     * @param book
     * @return 操作影响行数
     */
    int updateBook(Book book);

    /**
     * 局部更新
     * 
     * @param book
     * @return 操作影响行数
     */
    int updatePartBook(Book book);

    /**
     * 根据主键删除
     * 
     * @param id id
     * @return 操作影响行数
     */
    int deleteBook(Integer id);

    /**
     * 根据主键集合批量删除
     * 
     * @param queries 主键集合
     * @return 操作影响行数
     */
    int deleteBooks(List<BookQuery> queries);
}
