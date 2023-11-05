package EJ2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.example.Viaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("institutos")
public class ListaInstitutos implements Serializable {
    @XStreamImplicit(itemFieldName = "instituto")
    private List<Instituto> listaInstitutos;

    public ListaInstitutos(List<Instituto> listaInstitutos) {
        this.listaInstitutos = new ArrayList<>();
    }
    public ListaInstitutos() {
        this.listaInstitutos = new ArrayList<>();
    }

    public List<Instituto> getListaInstitutos() {
        return listaInstitutos;
    }

    public void setListaInstitutos(List<Instituto> listaInstitutos) {
        this.listaInstitutos = listaInstitutos;
    }

    public void add(Instituto instituto) {
        this.listaInstitutos.add(instituto);
    }
    @Override
    public String toString() {
        return "ListaInstitutos{" +
                "listaInstitutos=" + listaInstitutos +
                '}';
    }
}
