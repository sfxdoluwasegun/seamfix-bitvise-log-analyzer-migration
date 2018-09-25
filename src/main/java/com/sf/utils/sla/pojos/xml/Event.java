package com.sf.utils.sla.pojos.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author lash
 */
@XmlRootElement(name = "event")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Event implements Serializable {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private String time;

    @XmlAttribute
    private String desc;

    @XmlElement(name = "session")
    private Session session;

    @XmlElement(name = "parameters")
    private Parameters parameters;

    @XmlElement(name = "sfs")
    private Sfs sfs;

    @XmlElement(name = "error")
    private Error error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Sfs getSfs() {
        return sfs;
    }

    public void setSfs(Sfs sfs) {
        this.sfs = sfs;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
