package EJ2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

@XStreamAlias("historial")
public class Historial implements Serializable {
    private String nombreInstituto;
    private int anyoAcademico;
    @XStreamImplicit(itemFieldName = "asignatura")
    private List<String> asignaturas;

    public Historial(String nombreInstituto, int anyoAcademico, List<String> asignaturas) {
        this.nombreInstituto = nombreInstituto;
        this.anyoAcademico = anyoAcademico;
        this.asignaturas = asignaturas;
    }

    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public int getAnyoAcademico() {
        return anyoAcademico;
    }

    public void setAnyoAcademico(int anyoAcademico) {
        this.anyoAcademico = anyoAcademico;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "nombreInstituto='" + nombreInstituto + '\'' +
                ", anyoAcademico=" + anyoAcademico +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
