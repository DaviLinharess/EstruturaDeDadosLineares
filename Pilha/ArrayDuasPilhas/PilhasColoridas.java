package ArrayDuasPilhas;

public class PilhasColoridas {
    private int[] dados;
    private int capacidade;
    private int topoVermelho;
    private int topoPreto;


    public PilhasColoridas(int capacidadeInicial) {  //Construtor que prepara as duas pilhas
        this.capacidade = capacidadeInicial;
        this.dados = new int[capacidade];
        this.topoVermelho = -1;
        this.topoPreto = capacidade;
    }

    public void pushVermelho(int valor) {
        if (topoVermelho + 1 == topoPreto) {
            resize(capacidade * 2);
        }
        topoVermelho++;                             // aumenta o topo
        dados[topoVermelho] = valor;                // coloca o valor no array
    }

    public void pushPreto(int valor) {
        if (topoVermelho + 1 == topoPreto) {
            resize(capacidade * 2);
        }
        topoPreto--;                                // "aumenta" o topo
        dados[topoPreto] = valor;                   // coloca o valor no array
    }

    public int popVermelho() {
        if (topoVermelho == -1) {
            throw new PilhaVaziaExcecao("A Pilha está vazia.");
        }
        valor = dados[topoVermelho];
        topoVermelho--;                             // Vai retornar o valor que ESTAVA no topo, mas agora foi retirado
        return valor;                               // por isso o "valor = dados" veio antes do topoVermelho--;
    }

    public int popPreto() {
        if (topoPreto == capacidade) {
            throw new PilhaVaziaExcecao("A Pilha está vazia.");
        }
        valor = dados[topoVermelho];
        topoPreto++;                                // Vai retornar o valor que ESTAVA no topo, mas agora foi retirado
        return valor;                               // por isso o "valor = dados" veio antes do topoPreto--;
    }
   

    private void resize(int novaCapacidade) {
        int[] novo = new int[novaCapacidade];
        for (int i=0; i <= topoVermelho; i++) {     // laço pra copiar a Pilha vermelha pro novo Array 
            novo[i] = dados[i];
        }
        int elementosPretos = capacidade - topoPreto; // quantos elementos pretos tem na pilha preta
        int novoTopoPreto = novaCapacidade - elementosPretos;
    }
}