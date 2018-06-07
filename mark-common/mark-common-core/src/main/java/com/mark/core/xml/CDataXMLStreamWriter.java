/*
 * Copyright (c) 2013, mark and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.mark.core.xml;

import java.util.regex.Pattern;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


/**
 * Implementation which is able to decide to use a CDATA section for a string.
 * 
 * @author sunkey
 * @date Jan 24, 2015
 */
public class CDataXMLStreamWriter extends DelegatingXMLStreamWriter {
    private static final Pattern XML_CHARS = Pattern.compile("[&<>]");

    public CDataXMLStreamWriter(XMLStreamWriter del) {
        super(del);
    }

    @Override
    public void writeCharacters(String text) throws XMLStreamException {
        boolean useCData = XML_CHARS.matcher(text).find();
        if (useCData) {
            super.writeCData(text);
        } else {
            super.writeCharacters(text);
        }
    }
}
