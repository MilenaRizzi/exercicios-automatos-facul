package Compiladores.Automatos.Exer05;

public class Transition {
    private State origin;
    private State destiny;
    private String symbol;

    public Transition(State origin, State destiny, String symbol) {
        this.origin = origin;
        this.destiny = destiny;
        this.symbol = symbol;
    }

    public State getOrigin() {
        return this.origin;
    }

    public State getDestiny() {
        return this.destiny;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Transition transition = (Transition) object;
        if(origin.equals(transition.origin) && destiny.equals(transition.destiny)&& symbol.equals(transition.symbol)){
            return  true;
        }
        return false;
    }
}
