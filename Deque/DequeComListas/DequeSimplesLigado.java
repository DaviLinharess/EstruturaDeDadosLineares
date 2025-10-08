public class DequeSimples {
    private static class Node {
        int valor;
        Node prox;

        Node(int valor) {
            this.valor = valor;
            this.prox = null;
        }
    }

    private Node inicio;
    private Node fim;
    private int tamanho;

    public DequeSimples() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void pushFront(int valor) {
        Node novo = new Node(valor);
        if (isEmpty()) {
            inicio = fim = novo;
        } 
        else {
            novo.prox = inicio;
            inicio = novo;
        }
        tamanho++;
    }

    public void pushBack(int valor) {
        Node novo = new Node(valor);
        if (isEmpty()) {
            inicio = fim = novo;
        } 
        else {
            fim.prox = novo;
            fim = novo;
        }
        tamanho++;
    }

    public void popFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vazio");
        }
        inicio = inicio.prox;
        tamanho--;
        if (isEmpty()) {
            fim = null;
        }
    }

    public void popBack() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vazio");
        }
        if (tamanho == 1) {                                 //se for só um elemento
            inicio = fim = null;
        } 
        else {
            Node atual = inicio;
            while (atual.prox != fim) {                     //vai até o penúltimo, gerando o tempo O(n)
                atual = atual.prox;
            }
            atual.prox = null;
            fim = atual;
        }
        tamanho--;
    }

    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vazio");
        }
        return inicio.valor;
    }

    public int back() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vazio");
        }
        return fim.valor;
    }

    public int size() {
        return tamanho;
    }
}