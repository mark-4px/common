/*
 * Copyright (c) 2016, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
 
package com.mark.common.dao;

import com.mark.common.domain.Book;
import com.mark.common.domain.query.BookQuery;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Book Dao
 * 
 * @author mark.wu
 * @date 2018-05-09
 */
@Repository
public interface IBookDao{

    Book getByPk(@Param("id") Integer id );
    
    List<Book> search(BookQuery query);
    
    long getCount(BookQuery query);
    
    List<Book> queryByPage(BookQuery query);
    
    int insert(Book book);
    
    int insertBatch(List<Book> books);
    
    int update(Book book);
    
    int updatePart(Book book);
    
    int deleteByPk(@Param("id") Integer id );
    
    int deleteBatchByPks(List<BookQuery> queries);
}
