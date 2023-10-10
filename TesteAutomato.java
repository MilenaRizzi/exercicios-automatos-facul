package Compiladores.Automatos.Exer05;

public class TesteAutomato {
    public static void main(String[] args) {
        Automata automato = new Automata();

        // Definir estados
        automato.setState(0);  // Estado 0
        automato.setState(1);  // Estado 1
        automato.setState(2);  // Estado 2
        automato.setState(3);  // Estado 3
        automato.setState(4);  // Estado 4

        //definir estado inicial
        automato.setStartState(0);

        // Definir estados finais
        automato.setFinalState(4);

        // Definir transições
        //origem destino simbolo
        automato.setTransition(0, 0, "1"); // De 0 para 0 com '1'
        automato.setTransition(0, 0, "2"); // De 0 para 0 com '2'
        automato.setTransition(0, 1, "0"); // De 0 para 1 com '0'

        automato.setTransition(1, 2, "1"); // De 1 para 2 com '1'
        automato.setTransition(1, 3, "2"); // De 1 para 3 com '2'

        automato.setTransition(2, 2, "0"); // De 2 para 2 com '0'
        automato.setTransition(2, 4, "1"); // De 2 para 4 - final com '1'
        automato.setTransition(2, 4, "2"); // De 1 para 2 com '1'

        automato.setTransition(3, 3, "0"); // De 3 para 3 com '0'
        automato.setTransition(3, 3, "1"); // De 3 para 3 com '1'
        automato.setTransition(3, 4, "2"); // De 3 para 4 com '2'

        automato.setTransition(4, 4, "0"); // De 4 para 4 com '0'
        automato.setTransition(4, 4, "1"); // De 4 para 4 com '1'
        automato.setTransition(4, 4, "2"); // De 4 para 4 com '2'

        /*cadeia de entrada - aceitas
         * "0110"
         * "12120221"
         * "10101012"*/

        /*Rejeitadas
         * "001"
         * "12010"
         * "210201"*/
        String[] input = {"0110", "12120221", "10101012", "001", "12010", "210201"};

        for (int i = 0; i <= 4; i++) {
            automato.setState(i);
            automato.getState(i).setName("Q" + i); // Defina o nome do estado
        }

       for(String in : input) {
           transitionShow(in, automato);
       }

    }

    public static void transitionShow(String symbol, Automata automato) {
        Transition transition;
        State destiny;
        int j = 0;
        int origin = 0;
        try {
            while (j < symbol.length()) {

                if (!(symbol.charAt(j) == ' ')) {
                    transition = automato.getTransition(origin, "" + symbol.charAt(j));
                    destiny = transition.getDestiny();
                    origin = destiny.getId();

                    System.out.println("Leu o simbolo \"" + symbol.charAt(j) + "\" foi para o \""
                            + automato.getState(origin).getName());
                    j++;
                } else {
                    System.out.println("Este autômato não aceita transições vazias! ");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Estado final nao existe");
        }
        finalStateOfAutomata(symbol, automato, origin);
    }

    public static void finalStateOfAutomata(String symbol, Automata myAutomata, int origin) {
        if (myAutomata.isFinalState(origin)) {
            System.out.println("\nA entrada \"" + symbol + "\" foi aceita !!!\n");
        } else {
            System.out.println("\nA entrada \"" + symbol + "\" foi rejeitada!!!\n");
        }
    }
}
