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
        dados[topoPreto] = valor;                // coloca o valor no array
    }

    private void resize(int novaCapacidade) {
        System.out.println(">> resize chamado com capacidade" + novaCapacidade);
    }
}