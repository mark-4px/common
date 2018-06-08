/*
 * Copyright (c) 2016, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
 package com.mark.common.domain.query;

import java.util.Date;


/**
 * Book 查询对象
 * 
 * @author mark.wu
 * @date 2018-05-09
 */
public class BookQuery implements java.io.Serializable {

    /**
     * 序列化版本号
     */

    private static final long serialVersionUID = 589358204527744167L;

    /**
     * id 
     */
    private Integer id;

    /**
     * name 
     */
    private String name;

    /**
     * image 
     */
    private String image;

    /**
     * description 
     */
    private String description;

    /**
     * 定价 
     */
    private Double price;

    /**
     * category 
     */
    private String category;

    /**
     * createdTime 
     */
    private Date createdTimeBegin;

    /**
     * createdTime 
     */
    private Date createdTimeEnd;

    
    /**
     * 排序
     */
    private String sortBy;
    
    /**
     * 起始
     */
    private Integer start = Integer.valueOf(0);

    /**
     * 结束
     */
    private Integer end = Integer.valueOf(10000);

    /**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 分页大小,default 10
     */
    private Integer pageSize = 20;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreatedTimeBegin() {
        return this.createdTimeBegin;
    }
    
    public void setCreatedTimeBegin(Date createdTimeBegin) {
        this.createdTimeBegin = createdTimeBegin;
    }    
    
    public Date getCreatedTimeEnd() {
        return this.createdTimeEnd;
    }
    
    public void setCreatedTimeEnd(Date createdTimeEnd) {
        this.createdTimeEnd = createdTimeEnd;
    }
    
    
    private boolean checkBound(Integer i) {
        return i >= 0 && i <= Integer.MAX_VALUE;
    }

    public void setStart(Integer start) {
        if (checkBound(start)) {
            this.start = start;
        }
    }

    public Integer getStart() {
        return start;
    }

    public void setEnd(Integer end) {
        if (checkBound(end)) {
            this.end = end;
        }
    }

    public Integer getEnd() {
        return end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
