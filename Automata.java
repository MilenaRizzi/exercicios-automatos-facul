package Compiladores.Automatos.Exer05;

import java.util.HashMap;
import java.util.HashSet;

//M = (Q, Σ, δ, q0, F);
public class Automata {
    private HashMap<Integer, State> states;
    private HashMap<Integer, State> finalState;
    private HashSet<Transition> transitions;
    private State startState;
    private static int startStateLimit = 0;

    public Automata() {
        states = new HashMap<>();
        finalState = new HashMap<>();
        transitions = new HashSet<>();
    }


    public void setState(int id) {
        State state = new State(id);
        states.put(id, state);
    }

    public void setFinalState(int id) {
        State state = new State(id);
        finalState.put(id, state);
    }

    public void setStartState(int id) {
        startState = states.get(id);
    }


    public void setTransition(int origin, int destiny, String symbol) {
        State origem = states.get(origin);
        State destino = states.get(destiny);
        Transition transition = new Transition(origem, destino, symbol);
        transitions.add(transition);
    }

    public Transition getTransition(int origin, String symbol) {
        for (Transition transition : transitions) {
            if (transition.getOrigin().getId() == origin && transition.getSymbol().equals(symbol)) {
                return transition;
            }
        }
        return null;
    }

    public State getStartState() {
        return this.startState;
    }

    public State getFinalState(int id) {
        return states.get(id);
    }

    public int getFinalStateSize() {
        return finalState.size();
    }

    public State getState(int id) {
        return states.get(id);
    }

    public boolean isStartState(int id) {
        if (startState != null && startState.getId() == id) {
            return true;
        }
        return false;
    }

    public boolean isFinalState(int id) {
        return finalState.containsKey(id);
    }

    private void message(String msg) {
        System.out.println(msg);
    }
}
