import java.util.LinkedList;

public class AlgoritmoSegundaChance extends AlgoritmoDeSubstituicao{
    LinkedList bits;
    private static int PONTEIRO = 0;

    public AlgoritmoSegundaChance(int numeroDeQuadros) {
        super(numeroDeQuadros);
        this.quadros = new LinkedList();
        this.bits = new LinkedList();
    }

    @Override
    public void inserir(String pageNumber) {
        int tmp = quadros.indexOf(pageNumber);

        if (tmp == -1) {
            if (quadros.size() < numeroDeQuadros) {
                quadros.add(pageNumber);
                bits.add(0);
            } else {
                while ((int) bits.get(PONTEIRO) == 1) {
                    bits.set(PONTEIRO, 0);
                    PONTEIRO++;

                    if (PONTEIRO == numeroDeQuadros) {
                        PONTEIRO = 0;
                    }
                }
                quadros.remove(PONTEIRO);
                bits.remove(PONTEIRO);
                quadros.add(PONTEIRO, pageNumber);
                bits.add(PONTEIRO, 0);

                PONTEIRO++;

                if (PONTEIRO == numeroDeQuadros) {
                    PONTEIRO = 0;
                }
            }
        } else {
            bits.set(tmp, 1);
        }
    }

    @Override
    public void imprimirQuadros() {
        System.out.print("Quadros: ");
        for (int i = 0; i < quadros.size(); i++) {
            System.out.print(quadros.get(i) + " bit: " + bits.get(i) + " ");
        }
        System.out.println();
    }
}
