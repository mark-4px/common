/*
 * Copyright (c) 2016, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
 package com.mark.common.domain;

import java.util.Date;

/**
 * Book 实体类
 * 
 * @author mark.wu
 * @date 2018-05-09
 */
public class Book implements java.io.Serializable{

    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = -7723263825631869724L;

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
    private Date createdTime;


    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getImage() {
        return this.image;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Double getPrice() {
        return this.price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCategory() {
        return this.category;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public Date getCreatedTime() {
        return this.createdTime;
    }
}
