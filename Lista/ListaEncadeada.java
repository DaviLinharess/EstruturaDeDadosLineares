public class ListaEncadeada {

    private static class No {
        Object elem;
        No prev;
        No next;

        No(Object e, No p, No n) {
            elem = e;
            prev = p;
            next = n;
        }
    }

    private No head; //sentinela inicio
    private No tail; //sentinela fim
    private int n;   //size


    public ListaEncadeada() {
        head = new No(null, null, null);
        tail = new No(null, head, null);
        head.next = tail;
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFirst(No no) {
        if (no == head.next){
            return true;
        } else {
            return false;
        }
    }

    public boolean isLast(No no) {
        if (no == tail.prev){
            return true;
        } else {
            return false;
        }
    }

    public Object first() {
        if (isEmpty()){
            throw new RuntimeException("Lista Vazia");
        }
        return head.next.elem;
    }

    public Object last() {
        if (isEmpty()){
            throw new RuntimeException("Lista Vazia");
        }
        return tail.prev.elem;
    }

    public Object before(No no) {
        if (no.prev == head) {
            throw new RuntimeException("Não tem elemento antes dele.");
        }
        return no.prev.elem;
    }

    public Object after(No no) {
        if (no.next == tail) {
            throw new RuntimeException("Não tem elemento depois dele.");
        }
        return no.next.elem;
    }

    public void insertBefore(No no, Object o) {
        if (no == head) {
            throw new RuntimeException("Não pode colocar fora da Lista.");
        }

        No novo = new No(o, no.prev,no);
        no.prev.next = novo;
        no.prev = novo;
        n++;
    }

    public void insertAfter(No no, Object o) {
        if (no == tail) {
            throw new RuntimeException("Não pode colocar fora da Lista.");
        }

        No novo = new No(o, no, no.next);
        no.next.prev = novo;
        no.next = novo;
        n++;
    }

    public void insertFirst(Object o) {
        insertAfter(head, o);
    }

    public void insertLast(Object o){
        insertBefore(tail, o);
    }

    public Object remove(No no) {
        if (no == head || no == tail) {
            throw new RuntimeException("Não pode tirar os sentinelas.");
        }

        Object removido = no.elem;
        no.prev.next = no.next;
        no.next.prev = no.prev;
        n--;
        return removido;
    }
}