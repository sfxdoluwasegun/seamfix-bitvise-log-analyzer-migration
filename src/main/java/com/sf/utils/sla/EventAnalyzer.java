package com.sf.utils.sla;

import com.google.gson.Gson;
import com.sf.utils.sla.entity.EventEntry;
import com.sf.utils.sla.pojos.AnalyzerObj;
import com.sf.utils.sla.pojos.xml.Event;
import nw.commons.NeemClazz;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lash
 */
public class EventAnalyzer extends NeemClazz {

    private AppDs appDs;
    private Gson gsonWriter = new Gson();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //2017-11-15 13:55:18.908973

    public EventAnalyzer(AppDs appDs){
        this.appDs = appDs;
    }

    public void processEvent(AnalyzerObj analyzerObj){
        if(analyzerObj.getEventStr() == null){
            return;
        }

        if(!analyzerObj.getEventStr().startsWith("<event")){
            System.out.println("Invalid element detected: " + analyzerObj.getEventStr());
            return;
        }

        //unmarshall event string into desired object
        Event newEvent = unmarshal(Event.class, analyzerObj.getEventStr());

//        System.out.println("Resulting event: " + new Gson().toJson(newEvent));

        if(newEvent != null && newEvent.getSession() != null){
//            logger.debug("Saving file to db: {}", newEvent.getSession().getId());
//            //transform to db object
            EventEntry dbEntry = getEventDbEntry(newEvent);
            dbEntry.setLogFileName(analyzerObj.getLogFileName());
            dbEntry.setServerIP(analyzerObj.getServerIP());
            dbEntry.setBatch(analyzerObj.getBatch());

            System.out.println("Writing... " + gsonWriter.toJson(dbEntry));

//            //save event to db
            appDs.getDbService().create(dbEntry);
        }
    }

    public EventEntry getEventDbEntry(Event newEvent){
        EventEntry entry = new EventEntry();

        entry.setEventName(newEvent.getName());
        entry.setEventDesc(newEvent.getDesc());
        entry.setEventTime(newEvent.getTime());

        if(newEvent.getSession() != null){
            if(newEvent.getSession().getId() != null) {
                entry.setSessionId(newEvent.getSession().getId());
            }

            if(newEvent.getSession().getVirtualAccount() != null){
                entry.setVirtualAccount(newEvent.getSession().getVirtualAccount());
            }
        }

        if(newEvent.getSfs() != null) {
            if (newEvent.getSfs().getParameters() != null) {
                if (newEvent.getSfs().getParameters().getBytesWritten() != null) {
                    entry.setBytesWritten(newEvent.getSfs().getParameters().getBytesWritten());
                }

                if(newEvent.getSfs().getParameters().getPath() != null){
                    entry.setFilePath(newEvent.getSfs().getParameters().getPath());
                }

                if(newEvent.getSfs().getParameters().getTimeMs() != null){
                    entry.setTimeMs(newEvent.getSfs().getParameters().getTimeMs());
                }

                if(newEvent.getSfs().getParameters().getCreatedNewFile() != null){
                    entry.setCreatedNewFile(newEvent.getSfs().getParameters().getCreatedNewFile());
                }

                if(newEvent.getSfs().getParameters().getDisconnectReason() != null){
                    entry.setDisconnectReason(newEvent.getSfs().getParameters().getDisconnectReason());
                }
            }

            if(newEvent.getSfs().getHelp() != null && newEvent.getSfs().getHelp().getMessage() != null){
                entry.setMessage(newEvent.getSfs().getHelp().getMessage());
            }
        }

        if(newEvent.getError() != null){
            if(newEvent.getError().getComponent() != null){
                entry.setErrorComponent(newEvent.getError().getComponent());
            }

            if(newEvent.getError().getCode() != null){
                entry.setErrorCode(newEvent.getError().getCode());
            }

            if(newEvent.getError().getMessage() != null){
                entry.setErrorMessage(newEvent.getError().getMessage());
            }

            if(newEvent.getError().getDescription() != null){
                entry.setErrorDescription(newEvent.getError().getDescription());
            }
        }

        return entry;
    }

    public <T extends Object> T unmarshal(Class<T> clazz, String eventStr) {
        try {
            InputStream inputStream = new ByteArrayInputStream(eventStr.getBytes());
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return clazz.cast(jaxbUnmarshaller.unmarshal(inputStream));
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("", e);
        }

        return null;
    }

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s.S"); //2017-11-15 13:55:18.908973
        try {
            System.out.println(dateFormat.parse("2018-05-09 15:15:16.615145 +0100"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
