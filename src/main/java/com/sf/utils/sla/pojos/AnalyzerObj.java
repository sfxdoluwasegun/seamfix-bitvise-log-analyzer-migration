package com.sf.utils.sla.pojos;

/**
 * @author lash
 */
public class AnalyzerObj {
    private String eventStr;
    private String logFileName;
    private String serverIP;
    private String batch;

    public AnalyzerObj(String eventStr, String logFileName, String serverIP, String batch){
        this.eventStr = eventStr;
        this.logFileName = logFileName;
        this.serverIP = serverIP;
        this.batch = batch;
    }

    public String getEventStr() {
        return eventStr;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public String getServerIP() {
        return serverIP;
    }

    public String getBatch() {
        return batch;
    }
}
