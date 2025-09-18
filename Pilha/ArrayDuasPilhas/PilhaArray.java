//declaração da classe e atributos

public class PilhaArray implements Pilha{                   // implements = herança do arquivo Pilha
    private int capacidade;                                 // tamanho ATUAl do array
    private Object[] a;                                     // array que vai guardar os elementos
    private int t;                                          // topo do array, se for t= -1, então pilha está vazia
    private int FC;                                         // fator de crescimento, como usaremos duplicação, será sempre 0
    public PilhaArray(int capacidade, int crescimento) {    // responsavel por criar e iniciar uma nova pilha
        this.capacidade = capacidade;                       // capacidade = tamanho inicial, crescimento = dizer se é increm. ou duplic.
        t = -1;                                             // topo -1 para indicar que está PilhaVaziaExcecao
        FC = crescimento;                                   // se crescimento for maior que 0, usa incremental
        if (crescimento <= 0)                               // se for menor igual a 0, usa duplicação
            FC = 0;
        a = new Object[capacidade];                         // cria o array onde os elementos serão guardados, sendo o valor inicial
    }                                                       // o que está em "capacidade"
}                                                           // em Java, Object[] é "um array de qualquer tipo de objeto"

