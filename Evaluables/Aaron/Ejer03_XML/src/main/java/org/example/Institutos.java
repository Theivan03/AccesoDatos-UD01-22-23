package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

@XStreamAlias("institutos")
public class Institutos implements Serializable {

    @XStreamImplicit(itemFieldName="instituto")
    private List<Instituto> instituto;

    public Institutos(List<Instituto> instituto) {

        this.instituto = instituto;
    }

    public List<Instituto> getInstituto() {
        return instituto;
    }

    public void setInstituto(List<Instituto> instituto) {
        this.instituto = instituto;
    }

    @Override
    public String toString() {
        return "Institutos{" +
                "instituto=" + instituto +
                '}';
    }
}
