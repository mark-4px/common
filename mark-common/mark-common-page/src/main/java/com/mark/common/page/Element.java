/*
 * Copyright (c) 2015, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.common.page;

import java.io.Serializable;

/**
 * 
 * @author mark
 * @date 2017年10月11日
 * @site www.mark.ah.cn
 * @email mark@mark.ah.cn
 */
public class Element implements Serializable {
    private static final long serialVersionUID = 6343872482813655069L;
    private int key;
    private int value;
    private Boolean enable = Boolean.valueOf(true);
    private ElementType type = ElementType.MIDDLE;

    public Element(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Element(int key, int value, boolean enable) {
        this.key = key;
        this.value = value;
        this.enable = Boolean.valueOf(enable);
    }

    public Element(int key, int value, boolean enable, ElementType type) {
        this.enable = Boolean.valueOf(enable);
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public ElementType getType() {
        return this.type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public static Element create(int i) {
        return new Element(i, i);
    }

    public static Element create(int i, boolean enable) {
        return new Element(i, i, enable);
    }

    public static Element create(int i, boolean enable, ElementType type) {
        return new Element(i, i, enable, type);
    }

    public static Element create(int i, int j, boolean enable, ElementType type) {
        return new Element(i, j, enable, type);
    }

    public String toString() {
        return "Element [key=" + this.key + "\t value=" + this.value + "\t enable=" + this.enable + "\t type=" + this.type + "]";
    }
}
