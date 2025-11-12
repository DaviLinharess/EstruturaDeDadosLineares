public class TesteListaEncadeada {
    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada();
    
        System.out.println("TESTE DA LISTA DUPLAMENTE ENCADEADA \n");

        System.out.println("Lista está vazia? " + lista.isEmpty());
        System.out.println("Tamanho inicial: " + lista.size());

        lista.insertFirst("B");
        lista.insertLast("C");
        lista.insertFirst("A");

        System.out.println("\n Depois de colocar no início e no fim:");
        printLista(lista);

        ListaEncadeada.No meio = lista.head.next.next; // nó "B"
        lista.insertBefore(meio, "X");
        lista.insertAfter(meio, "Y");

        System.out.println("\n Após inserções antes e depois de B:");
        printLista(lista);

        Object antigo = lista.replaceElement(meio, "Z");
        System.out.println("\n Substituiu '" + antigo + "' por 'Z':");
        printLista(lista);

        ListaEncadeada.No primeiro = lista.head.next; // A
        ListaEncadeada.No ultimo = lista.tail.prev;   // C
        lista.swapElements(primeiro, ultimo);

        System.out.println("\n Depois de trocar primeiro e último:");
        printLista(lista);
        

        Object removido = lista.remove(meio);
        System.out.println("\n Removeu o nó central: " + removido);
        printLista(lista);

        System.out.println("\nLista está vazia? " + lista.isEmpty());
        System.out.println("Tamanho final: " + lista.size());
    }

    public static void printLista(ListaEncadeada lista) {
        ListaEncadeada.No atual = lista.head.next;
        System.out.print("Lista: ");
        while (atual != lista.tail) {
            System.out.print(atual.elem + " ");
            atual = atual.next;
        }
        System.out.println();
    }
}