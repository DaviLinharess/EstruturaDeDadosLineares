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
        int[] novo = new int[novaCapacidade];
        for (int i=0; i <= topoVermelho; i++) {                 // laço pra copiar a Pilha vermelha pro novo Array 
            novo[i] = dados[i];
        }
        int elementosPretos = capacidade - topoPreto;           
        int novoTopoPreto = novaCapacidade - elementosPretos;   
        for (int i=0; i < elementosPretos; i++) {               
            novo[novoTopoPreto + i] = dados[topoPreto + i];
        }
        topoPreto = novoTopoPreto;
        capacidade = novaCapacidade;                            
        dados = novo;
    }

    // OUTROS MÉTODOS
    public boolean isEmptyVermelho() {                
        return topoVermelho == -1;                    
    }
    public boolean isEmptyPreto() {                  
        return topoPreto == capacidade;               
    }                                       
   public int sizeVermelho () {                      
        return topoVermelho + 1;                     
    }
    public int sizePreto () {                         
        return capacidade - topoPreto;                
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
    

    
   

    
