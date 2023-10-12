package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("asinatura")
public class Asignatura {
    private String asignatura;

    public Asignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "asignatura='" + asignatura + '\'' +
                '}';
    }
}

