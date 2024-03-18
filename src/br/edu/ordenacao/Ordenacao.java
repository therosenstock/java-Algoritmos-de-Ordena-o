package br.edu.ordenacao;

public class Ordenacao {
    public Ordenacao() {
        super();
    }

    public int[] bubbleSort(int [] vetor){
        int tamanho = vetor.length;
        for(int i = 0; i< tamanho; i++){
            for(int j = 0; j< tamanho - 1; j++){
                if(vetor[j] > vetor[j+1]){
                    int aux = vetor[j];
                    vetor[j]= vetor[j + 1];
                    vetor[j+1]= aux;
                }
            }
        }
        return vetor;
    }
    public int[] mergeSort(int[] vetor, int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim)/2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio+1, fim);
            intercala(vetor, inicio, meio, fim);
        }
        return vetor;
    }

    public int[] intercala(int [] vetor, int inicio, int meio, int fim){
        int novoVetor[] = new int[vetor.length];
        for(int i = inicio; i<= fim; i++){
            novoVetor[i] = vetor[i];
        }
        int esq = inicio;
        int dir = meio+1;

        for (int j = inicio; j <=fim; j++){
            if(esq>meio){
                vetor[j] = novoVetor[dir];
                dir++;
            }else if(dir > fim){
                vetor[j] = novoVetor[esq];
                esq++;
            }else if(novoVetor[esq]< novoVetor[dir]){
                vetor[j] = novoVetor[esq];
                esq++;
            }else{
                vetor[j] = novoVetor[dir];
                dir++;
            }
        }
        return vetor;
    }

    public int[] quickSort(int [] vetor, int inicio, int fim){
        if(fim > inicio){
            int pivoFixo = dividir(vetor, inicio, fim);
            quickSort(vetor, inicio, pivoFixo - 1);
            quickSort(vetor, pivoFixo + 1, fim);
        }
        return vetor;
    }
    public int dividir(int[] vetor, int inicio, int fim){
        int pEsq = inicio + 1;
        int pDir = fim;
        int pivo = vetor[inicio];

        while(pEsq <= pDir){
            while( pEsq <= pDir && vetor[pEsq] <= pivo){
                pEsq++;
            }
            while(pDir >= pEsq && vetor[pDir] > pivo){
                pDir--;
            }
            if(pEsq < pDir){
                trocar(vetor, pEsq, pDir);
                pEsq++;
                pDir--;
            }
        }
        trocar(vetor, inicio, pDir);
        return pDir;
    }

    private void trocar(int[] vetor, int i, int j) {
        int aux = vetor[j];
        vetor[j] = vetor[i];
        vetor[i] = aux;
    }
}
