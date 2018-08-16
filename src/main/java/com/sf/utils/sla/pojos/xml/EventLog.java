package com.sf.utils.sla.pojos.xml;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author lash
 */
@XmlRootElement(name = "log")
public class EventLog implements Serializable {

    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
