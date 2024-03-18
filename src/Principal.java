import br.edu.ordenacao.Ordenacao;

public class Principal {
    public static void main(String[] args) {
        int [] vetor = {2, 0, -9, 40, 8, 6, -2, 70};
        Ordenacao ordem = new Ordenacao();

        vetor = ordem.quickSort(vetor, 0, vetor.length-1);
        for(int i = 0; i< vetor.length; i++) {
            System.out.print(" " +
                    vetor[i]);
        }
    }
}