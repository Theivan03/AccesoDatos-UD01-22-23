package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;
@XStreamAlias("institutos")
public class ListaInstitutos {
    @XStreamImplicit(itemFieldName = "instituto")
    private List<Instituto> institutos;

    public ListaInstitutos(List<Instituto> institutos) {
        this.institutos = new ArrayList<>();
    }

    public List<Instituto> getInstitutos() {
        return institutos;
    }

    public void add(Instituto instituto) {
        institutos.add(instituto);
    }
}