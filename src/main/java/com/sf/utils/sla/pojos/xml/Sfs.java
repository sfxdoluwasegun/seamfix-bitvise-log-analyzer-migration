package com.sf.utils.sla.pojos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author lash
 */
@XmlRootElement(name = "sfs")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Sfs implements Serializable {

    @XmlElement(name = "parameters")
    private Parameters parameters;

    @XmlElement(name = "help")
    private Help help;

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Help getHelp() {
        return help;
    }

    public void setHelp(Help help) {
        this.help = help;
    }
}
