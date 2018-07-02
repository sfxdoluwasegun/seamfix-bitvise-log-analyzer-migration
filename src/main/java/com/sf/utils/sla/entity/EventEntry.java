package com.sf.utils.sla.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lash
 */
@Entity
@Table(name = "event_logs")
public class EventEntry extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate = new Date();

    @Column(name = "session_id")
    private Long sessionId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_desc")
    private String eventDesc;

    @Column(name = "event_time")
    private String eventTime;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "time_ms")
    private Long timeMs;

    @Column(name = "bytes_written")
    private Long bytesWritten;

    @Column(name = "virtual_account")
    private String virtualAccount;

    @Column(name = "server_ip")
    private String serverIP;

    @Column(name = "help_message")
    private String message;

    @Column(name = "created_new_file")
    private Boolean createdNewFile;

    @Column(name = "log_file_name")
    private String logFileName;

    @Column(name = "disconnect_reason")
    private String disconnectReason;

    @Column(name = "error_component")
    private String errorComponent;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "error_desc")
    private String errorDescription;

    @Column(name = "batch")
    private String batch;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Boolean getCreatedNewFile() {
        return createdNewFile;
    }

    public void setCreatedNewFile(Boolean createdNewFile) {
        this.createdNewFile = createdNewFile;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public String getDisconnectReason() {
        return disconnectReason;
    }

    public void setDisconnectReason(String disconnectReason) {
        this.disconnectReason = disconnectReason;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorComponent() {
        return errorComponent;
    }

    public void setErrorComponent(String errorComponent) {
        this.errorComponent = errorComponent;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
