import java.util.LinkedList;

public class AlgoritmoLRU extends AlgoritmoDeSubstituicao{

    public AlgoritmoLRU(int numeroDeQuadros) {
        super(numeroDeQuadros);

        this.quadros = new LinkedList();
    }

    @Override
    public void inserir(String pageNumber) {

        int tmp = quadros.indexOf(pageNumber);
        if (tmp == -1) {
            if (quadros.size() < numeroDeQuadros) {
                quadros.add(pageNumber);
            } else {

                quadros.remove(0);
                quadros.add(pageNumber);
            }
            numeroDeFalhas++;
        } else {
            quadros.remove(tmp);
            quadros.add(pageNumber);
        }
    }
}
