package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@XStreamAlias("institutos")
public class ListaInstitutos implements Serializable {
    @XStreamImplicit(itemFieldName = "instituto")
    private List<Instituto> institutos;

    public ListaInstitutos() {
    }

    public ListaInstitutos(List<Instituto> institutos) {
        this.institutos = new ArrayList<>();
    }

    public List<Instituto> getInstitutos() {
        return institutos;
    }

    public void add(Instituto instituto) {
        institutos.add(instituto);
    }

    @Override
    public String toString() {
        return "ListaInstitutos{" +
                "institutos=" + institutos +
                '}';
    }
}