public class TesteSequenciaEncadeada {
    public static void main(String[] args) {

        SequenciaEncadeada seq = new SequenciaEncadeada();
        System.out.println("Teste da Sequencia Encadeada\n");

        System.out.println("Sequência inicialmente vazia? " + seq.isEmpty());
        System.out.println("Tamanho inicial: " + seq.size());


        System.out.println("\n Inserindo elementos no início e no fim.");
        seq.insertFirst("A");
        seq.insertLast("B");
        seq.insertLast("C");
        seq.insertLast("D");
        print(seq);

        System.out.println("\n Primeiro elemento: " + seq.first().elem);
        System.out.println("Último elemento: " + seq.last().elem);


        SequenciaEncadeada.No meio = seq.first().next.next; // nó "C"
        System.out.println("\nInserindo antes e depois de " + meio.elem);
        seq.insertBefore(meio, "X");
        seq.insertAfter(meio, "Y");
        print(seq);


        System.out.println("\n Substituindo elemento.");
        Object antigo = seq.replaceElement(meio, "Z");
        System.out.println("Substituiu " + antigo + " por Z");
        print(seq);

        System.out.println("\n Trocando o primeiro e o último elemento.");
        seq.swapElements(seq.first(), seq.last());
        print(seq);


        System.out.println("\n Removendo o nó do meio (Z).");
        seq.remove(meio);
        print(seq);

        // Métodos de rank
        System.out.println("\n Testando atRank e rankOf.");
        SequenciaEncadeada.No noRank2 = seq.atRank(2);
        System.out.println("Elemento no rank 2: " + noRank2.elem);
        System.out.println("Rank do primeiro: " + seq.rankOf(seq.first()));


        System.out.println("\n Removendo elemento do rank 1.");
        Object removido = seq.removeAtRank(1);
        System.out.println("Removeu: " + removido);
        print(seq);

        System.out.println("\n Inserindo elemento no rank 1.");
        seq.insertAtRank(1, "Q");
        print(seq);

        System.out.println("Sequência ao final vazia? " + seq.isEmpty());
        System.out.println("Tamanho Final: " + seq.size());

    }


    public static void print(SequenciaEncadeada seq) {
        System.out.print("Sequência: ");
        SequenciaEncadeada.No atual = seq.head.next;
        while (atual != seq.tail) {
            System.out.print(atual.elem + " ");
            atual = atual.next;
        }
        System.out.println("\n Tamanho atual: " + seq.size() + "\n");
    }
}
