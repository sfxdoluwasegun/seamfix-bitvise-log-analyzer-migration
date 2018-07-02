package com.sf.utils.sla.pojos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author lash
 */
@XmlRootElement(name = "help")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Help implements Serializable {
    @XmlAttribute
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
