import java.util.LinkedList;

public class AlgoritmoFifo extends AlgoritmoDeSubstituicao{
    private static int INSERCAO = 0;

    public AlgoritmoFifo(int numeroDeQuadros) {

        super(numeroDeQuadros);
        this.quadros = new LinkedList();
    }

    @Override
    public void inserir(String pageNumber) {

        if (!quadros.contains(pageNumber)) {
            if (quadros.size() < numeroDeQuadros) {
                quadros.add(pageNumber);
            } else {
                quadros.remove(INSERCAO);
                quadros.add(INSERCAO);
                quadros.add(INSERCAO, pageNumber);
                INSERCAO++;
                if (INSERCAO == numeroDeQuadros) {
                    INSERCAO = 0;
                }
            }
            numeroDeFalhas++;
        }
    }
}
