package classes;

public class Gato {
    private int ID;
    private String nombre;
    private String raza;
    private String color;

    public Gato() {
        super();
    }

    public Gato(int ID, String nombre, String raza, String color) {
        this.ID = ID;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}