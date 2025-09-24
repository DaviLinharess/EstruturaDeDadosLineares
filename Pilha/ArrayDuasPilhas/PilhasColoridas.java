package Pilha.ArrayDuasPilhas;

public class PilhasColoridas {
    private int[] dados;
    private int capacidade;
    private int topoVermelho;
    private int topoPreto;

    public PilhasColoridas(int capacidadeInicial) {   // construtor que prepara as duas pilhas
        this.capacidade = capacidadeInicial;
        this.dados = new int[capacidade];
        this.topoVermelho = -1;
        this.topoPreto = capacidade;
    }

    // PUSH
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

    // POP
    public int popVermelho() {
        if (topoVermelho == -1) {
            throw new PilhaVaziaExcecao("A Pilha vermelha está vazia.");
        }
        int valor = dados[topoVermelho];                // Vai retornar o valor que ESTAVA no topo, mas agora foi retirado 
        topoVermelho--;                                 // por isso o "valor = dados" veio antes do topoVermelho--;

        if (totalSize() <= capacidade / 3 && capacidade > 4) {
            resize(capacidade / 2);
        }
        return valor;                               
    }

    public int popPreto() {
        if (topoPreto == capacidade) {
            throw new PilhaVaziaExcecao("A Pilha preta está vazia.");
        }
        int valor = dados[topoPreto];                // Vai retornar o valor que ESTAVA no topo, mas agora foi retirado
        topoPreto++;                                // por isso o "valor = dados" veio antes do topoPreto--;

        if (totalSize() <= capacidade / 3 && capacidade > 4) {
            resize(capacidade /2);
        }
        return valor;                               
    }

    //RESIZE
    private void resize(int novaCapacidade) {
        System.out.println(">> resize: " + capacidade + " -> " + novaCapacidade);
        int[] novo = new int[novaCapacidade];
        for (int i=0; i <= topoVermelho; i++) {                 // laço pra copiar a Pilha vermelha pro novo Array 
            novo[i] = dados[i];
        }
        int elementosPretos = capacidade - topoPreto;           // quantos elementos pretos tem na pilha preta
        int novoTopoPreto = novaCapacidade - elementosPretos;   //novo topo preto colocado no novo array
        for (int i=0; i < elementosPretos; i++) {               // copiar a pilha preta pro novo array
            novo[novoTopoPreto + i] = dados[topoPreto + i];
        }
        topoPreto = novoTopoPreto;
        capacidade = novaCapacidade;                            // atualiza os atributos
        dados = novo;
    }

    // OUTROS MÉTODOS
    public boolean isEmptyVermelho() {                // verifica se está vazia
        return topoVermelho == -1;                    // retorna true se topoVermelho == -1, se não, false
    }
    public boolean isEmptyPreto() {                   // verifica se está vazia
        return topoPreto == capacidade;               // retorna true se topoPreto == capacidade, se não, false
    }                                       
   public int sizeVermelho () {                      // tamanho pilha vermelha
        return topoVermelho + 1;                      // +1 pq o indice comeca em -1
    }
    public int sizePreto () {                         // tamanho pilha preta
        return capacidade - topoPreto;                // capacidade - topoPreto pq o indice comeca em capacidade
    }
    public int totalSize() {
        return sizeVermelho() + sizePreto();
    }
    public int topVermelho() {
        if (isEmptyVermelho()) {
            throw new PilhaVaziaExcecao("Pilha vermelha está vazia.");
        }
        return dados[topoVermelho];      
    }
    public int topPreto() {
        if (isEmptyPreto()) {
            throw new PilhaVaziaExcecao("Pilha preta está vazia.");
        }    
        return dados[topoPreto];
    }
}
    

    
   

    
