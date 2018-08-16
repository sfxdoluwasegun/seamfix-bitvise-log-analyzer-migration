package com.sf.utils.sla;

import com.google.gson.Gson;
import com.sf.utils.sla.entity.EventEntry;
import com.sf.utils.sla.pojos.AnalyzerObj;
import com.sf.utils.sla.pojos.xml.Event;
import com.sf.utils.sla.pojos.xml.EventLog;
import nw.commons.NeemClazz;
import nw.commons.StopWatch;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lash
 */
public class AppLauncher extends NeemClazz {

    private AppDs appDs;
    private Gson gsonWriter = new Gson();

    public AppLauncher(){
        appDs = AppDs.getInstance();
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch(true);
        AppLauncher app = new AppLauncher();
        app.start(args);
        System.out.println("Time taken: "+ sw.elapsedTime());
    }

    public void start(String[] args){
        if(args == null || args.length == 0){
            logger.debug("No file path specified!!");
            return;
        }

        File logFile = new File(args[0]);
//        File logFile = new File("/Users/lash/Documents/Copied_From_Server/BvSshServer20180223-101948954-P0100/BvSshServer20180421-010950662-P0100.log");
//        File logFile = new File("/Users/lash/Downloads/BvSshServer20171115-135508522-P0100/BvSshServer20171115-135508522-P0100.log"); //1GB log file
        if(!logFile.exists()){
            System.out.println("Log file does not exist!!");
            return;
        }
        System.out.println("Log file detected: " + logFile.getName());

        try {
            String serverIP = getServerIP();
            String fileName = logFile.getName();
            String batch = new SimpleDateFormat("yyyyMMMddHHmmssSSS").format(new Date());
            System.out.println("Current batch: " + batch);

            //initialize event analyzer
            EventAnalyzer eventAnalyzer = new EventAnalyzer(appDs);

            //unmarshall file to list of events
            EventLog log = eventAnalyzer.unmarshal(EventLog.class, FileUtils.readFileToString(logFile));
            if(log.getEvents() != null){
                System.out.println("No. of events found: " + log.getEvents().size());
                for(Event newEvent : log.getEvents()){
                    EventEntry dbEntry = eventAnalyzer.getEventDbEntry(newEvent);
                    dbEntry.setLogFileName(fileName);
                    dbEntry.setServerIP(serverIP);
                    dbEntry.setBatch(serverIP);

                    System.out.println("Writing... " + gsonWriter.toJson(dbEntry));

                    //save event to db
                    appDs.getDbService().create(dbEntry);
                }
            }

        } catch (FileNotFoundException e) {
            logger.error("Log file not found!!", e);
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error in reading line in log file!!", e);
            return;
        } finally {
            appDs.getDbService().closeFactory();
        }
    }

    private String getServerIP(){
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

}
