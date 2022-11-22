import java.util.Scanner;

public class Test {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Valor: ");
        String refecencia = scanner.nextLine();
        String[] stringRefecencia = refecencia.split(";");

        //FIFO
        AlgoritmoDeSubstituicao fifo = new AlgoritmoFifo(3);

        for (int i = 0; i < stringRefecencia.length; i++) {
            fifo.inserir(stringRefecencia[i]);
        }

        System.out.println("Fifo - Page Faults: " + fifo.getPageFaultCount());

        // LRU
        AlgoritmoDeSubstituicao lru = new AlgoritmoLRU(3);

        for (int i = 0; i < (stringRefecencia.length -1); i++) {
           lru.inserir(stringRefecencia[i]);
        }
        System.out.println("LRU - Page Faults: " + lru.getPageFaultCount());

        // Segunda chance
        AlgoritmoDeSubstituicao sc = new AlgoritmoSegundaChance(3);

        for (int i = 0; i < (stringRefecencia.length -1); i++) {
            sc.inserir(stringRefecencia[i]);

                // Imprimi TUDO:
                sc.imprimirQuadros();
        }

        System.out.println("Segunda Chance - Page Faults: " + sc.getPageFaultCount());
    }
}