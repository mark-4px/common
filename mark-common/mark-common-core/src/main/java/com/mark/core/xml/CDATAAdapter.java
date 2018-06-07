/*
 * Copyright (c) 2013, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.core.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 * xml node add CDATA
 * example: @XmlJavaTypeAdapter(value=CDATAAdapter.class)
 *          private String description;
 * 
 * @author sunkey
 * @date May 26, 2014
 */
public class CDATAAdapter extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return "<![CDATA[" + v + "]]>";
    }

}
