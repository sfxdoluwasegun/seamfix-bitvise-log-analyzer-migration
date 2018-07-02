package com.sf.utils.sla.pojos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author lash
 */
@XmlRootElement(name = "session")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Session implements Serializable {
    @XmlAttribute
    private Long id;

    @XmlAttribute
    private String remoteAddress;

    @XmlAttribute
    private String virtualAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}
