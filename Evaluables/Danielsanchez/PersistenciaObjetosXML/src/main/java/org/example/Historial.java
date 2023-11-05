package org.example;

public class Historial {
    private Instituto instituto;
    private String asignatura1;
    private String asignatura2;
    private String asignatura3;

    public Historial() {
    }

    public Historial(Instituto instituto, String asignatura1, String asignatura2, String asignatura3) {
        this.instituto = instituto;
        this.asignatura1 = asignatura1;
        this.asignatura2 = asignatura2;
        this.asignatura3 = asignatura3;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public String getAsignatura1() {
        return asignatura1;
    }

    public void setAsignatura1(String asignatura1) {
        this.asignatura1 = asignatura1;
    }

    public String getAsignatura2() {
        return asignatura2;
    }

    public void setAsignatura2(String asignatura2) {
        this.asignatura2 = asignatura2;
    }

    public String getAsignatura3() {
        return asignatura3;
    }

    public void setAsignatura3(String asignatura3) {
        this.asignatura3 = asignatura3;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "instituto=" + instituto +
                ", asignatura1='" + asignatura1 + '\'' +
                ", asignatura2='" + asignatura2 + '\'' +
                ", asignatura3='" + asignatura3 + '\'' +
                '}';
    }
}
