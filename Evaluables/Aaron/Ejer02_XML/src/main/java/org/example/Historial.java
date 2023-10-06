package org.example;

import java.util.List;

public class Historial {
    private String nombreInstituto;
    private int anyoAcademico;
    private List<String> asignatura;

    public Historial(String nombreInstituto, int anyoAcademico, List<String> asignatura) {
        this.nombreInstituto = nombreInstituto;
        this.anyoAcademico = anyoAcademico;
        this.asignatura = asignatura;
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

    public List<String> getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(List<String> asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "nombreInstituto='" + nombreInstituto + '\'' +
                ", anyoAcademico=" + anyoAcademico +
                ", asignatura=" + asignatura +
                '}';
    }
}
