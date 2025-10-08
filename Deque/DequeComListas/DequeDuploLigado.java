public class DequeDuplo {
    private static class Node {
        int valor;
        Node prox;
        Node ant;

        Node(int valor) {
            this.valor = valor;
            this.prox = null;
            this.ant = null;
        }
    }

    private Node inicio;
    private Node fim;
    private int tamanho;

    public DequeDuplo() {
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
            inicio.ant = novo;
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
            novo.ant = fim;
            fim = novo;
        }
        tamanho++;
    }

    public void popFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vazio");
        }
        inicio = inicio.prox;
        if (inicio != null) {
            inicio.ant = null;
        }
        tamanho--;
        if (isEmpty()) {
            fim = null;
        }
    }

    public void popBack() {
        if (isEmpty()) {
            throw new RuntimeException("Deque vazio");
        }
        fim = fim.ant;
        if (fim != null) {
            fim.prox = null;
        }
        tamanho--;
        if (isEmpty()) {
            inicio = null;
        }
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