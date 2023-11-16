package model.entity;

public class Sponsor {
    private int codigo;
    private String nombre;

    public Sponsor() {
    }

    public Sponsor(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("Código: %s\nNombre: %-15s", codigo, nombre);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
