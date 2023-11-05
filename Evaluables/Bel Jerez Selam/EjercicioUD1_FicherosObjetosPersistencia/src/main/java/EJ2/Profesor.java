package EJ2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.time.LocalDate;
import java.util.List;

@XStreamAlias("profesor")
public class Profesor extends Persona {
    private String fechaIncorporacion;
    @XStreamImplicit(itemFieldName = "historial")
    private List<Historial> historial;
    @XStreamImplicit(itemFieldName = "falta")
    private List<Falta> faltas;

    public Profesor(String fechaIncorporacion, List<Historial> historial, List<Falta> faltas) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.faltas = faltas;
    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, double sueldoBruto, String fechaIncorporacion, List<Historial> historial, List<Falta> faltas) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
        this.historial = historial;
        this.faltas = faltas;
    }

    public String getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(String fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "fechaIncorporacion='" + fechaIncorporacion + '\'' +
                ", historial=" + historial +
                ", faltas=" + faltas +
                '}';
    }
}
