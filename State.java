package Compiladores.Automatos.Exer05;

public class State {
    private int id;
    //nome e rótulo são para fins de identificação mas são opcionais.
    private String name;
    private String label;

    public State(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
