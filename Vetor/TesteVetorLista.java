public class TesteVetorLista {
    public static void main(String[] args) {

        VetorLista vetor = new VetorLista();
        System.out.println("Teste do VetorLista \n");

        System.out.println("Lista inicialmente vazia? " + vetor.isEmpty());
        System.out.println("Tamanho inicial: " + vetor.size());

        System.out.println("\n Inserindo elementos ");

        vetor.insertAtRank(0, "A");
        vetor.insertAtRank(1, "B");
        vetor.insertAtRank(2, "C");
        vetor.insertAtRank(1, "X"); 


        System.out.println("\n Acessando elementos pelo rank");
        System.out.println("Elemento na posição 0: " + vetor.elemAtRank(0));
        System.out.println("Elemento na posição 1: " + vetor.elemAtRank(1));
        System.out.println("Elemento na posição 3: " + vetor.elemAtRank(3));

        System.out.println("\n Substituindo o elemento ");

        Object antigo = vetor.replaceAtRank(2, "Y");

        System.out.println("Substituiu " + antigo + " por Y");
        print(vetor);

        System.out.println(" \n Removendo elementos");
        Object removido = vetor.removeAtRank(1);
        System.out.println("Removeu: " + removido);
        print(vetor);

        System.out.println("\n Inserindo no final ");
        vetor.insertAtRank(vetor.size(), "Z");
        print(vetor);
 
        System.out.println("\n Lista final vazia? " + vetor.isEmpty());
        System.out.println("Tamanho final: " + vetor.size());
    }

    public static void print(VetorLista vetor) {
        System.out.println("Lista Atual: ");
        for (int i = 0; i < vetor.size(); i++) {
            System.out.println(vetor.elemAtRank(i) + " ");
        }
    }
}

