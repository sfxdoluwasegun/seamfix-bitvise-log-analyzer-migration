package com.sf.utils.sla.pojos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lash
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Parameters {
    @XmlAttribute
    private String path;

    @XmlAttribute
    private Long timeMs;

    @XmlAttribute
    private Long bytesWritten;

    @XmlAttribute
    private Boolean createdNewFile;

    @XmlAttribute
    private String disconnectReason;

    @XmlAttribute
    private String listenAddress;

    @XmlAttribute
    private String clientVersion;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getTimeMs() {
        return timeMs;
    }

    public void setTimeMs(Long timeMs) {
        this.timeMs = timeMs;
    }

    public Long getBytesWritten() {
        return bytesWritten;
    }

    public void setBytesWritten(Long bytesWritten) {
        this.bytesWritten = bytesWritten;
    }

    public Boolean getCreatedNewFile() {
        return createdNewFile;
    }

    public void setCreatedNewFile(Boolean createdNewFile) {
        this.createdNewFile = createdNewFile;
    }

    public String getDisconnectReason() {
        return disconnectReason;
    }

    public void setDisconnectReason(String disconnectReason) {
        this.disconnectReason = disconnectReason;
    }

    public String getListenAddress() {
        return listenAddress;
    }

    public void setListenAddress(String listenAddress) {
        this.listenAddress = listenAddress;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }
}
