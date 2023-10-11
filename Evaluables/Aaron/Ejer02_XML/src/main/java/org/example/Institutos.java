package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

@XStreamAlias("institutos")
public class Institutos {

    private List<Instituto> institutos;

    public Institutos(List<Instituto> institutos) {
        this.institutos = institutos;
    }

    public List<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(List<Instituto> institutos) {
        this.institutos = institutos;
    }

    @Override
    public String toString() {
        return "Institutos{" +
                "institutos=" + institutos +
                '}';
    }
}
