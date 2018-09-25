package com.sf.utils.sla;

import com.sf.utils.sla.pojos.AnalyzerObj;
import nw.commons.NeemClazz;
import nw.commons.StopWatch;
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
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            StringBuffer buffer = new StringBuffer();
            EventAnalyzer eventAnalyzer = new EventAnalyzer(appDs);
            String serverIP = getServerIP();
            String batch = new SimpleDateFormat("yyyyMMMddHHmmssSSS").format(new Date());
            System.out.println("Current batch: " + batch);

            for(String line; (line = reader.readLine()) != null; ){
//                System.out.println("==Processing...{}"+ line);

                //if we encounter an empty line, it means we have come to the end of an event
                if(StringUtils.isEmpty(line)){
                    if(buffer.length() > 0){
                        //process event block
                        String eventStr = buffer.toString();
//                        System.out.println("Event string =====>> " + eventStr);

                        AnalyzerObj analyzerObj = new AnalyzerObj(eventStr.trim(), logFile.getName(),serverIP, batch, logFile.getAbsolutePath());
                        eventAnalyzer.processEvent(analyzerObj);

                        //reinitialize buffer
                        buffer = new StringBuffer();
                    }
                }else{
                    //add string to buffer
                    buffer.append(line);
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
