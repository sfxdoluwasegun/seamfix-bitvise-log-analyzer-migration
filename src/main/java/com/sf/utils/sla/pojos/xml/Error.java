package com.sf.utils.sla.pojos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lash
 */
@XmlRootElement(name = "error")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Error {
    @XmlAttribute
    private String component;

    @XmlAttribute
    private String code;

    @XmlAttribute
    private String message;

    @XmlAttribute
    private String description;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
