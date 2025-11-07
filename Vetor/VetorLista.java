public class VetorLista {
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

    private No head;        //sentinela inicio
    private No tail;        //sentinela fim
    private int n;          //tamanho lista


    public VetorLista() {
        head = new No(null, null, null);
        tail = new No(null, head, null);
        head.next = tail;
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if (n==0){
            return true;
        }
        return false;
    }

    private No getNoAtRank(int r) {
        if (r < 0 || r >= n) {
            throw new RuntimeException("Rank não tem na Lista");
        }

        No atual;
        if (r < n / 2) {
            atual = head.next;
            for (int i = 0; i < r; i++) {
                atual = atual.next;
            }
        } else {
            atual = tail.prev;
            for (int i = n-1; i > r; i--) {
                atual = atual.prev;
            }
        }
        return atual;
    }


    public Object elemAtRank (int r) {
        return getNoAtRank(r).elem;
    }

    public Object replaceAtRank(int r, Object o) {
        No no = getNoAtRank(r);
        Object antigo = no.elem;
        no.elem = o;
        return antigo;
    }

    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > n) {
            throw new RuntimeException("Rank não tem na Lista");
        }
        
        No atual;
        if (r == n) {
            atual = tail;
        } else {
            atual = getNoAtRank(r);
        }

        No novo = new No(o, atual.prev, atual);
        atual.prev.next = novo;
        atual.prev = novo;
        n++;
    }

    public Object removeAtRank(int r) {
        if (r < 0 || r >= n) {
            throw new RuntimeException("Rank não tem na Lista");
        }

        No alvo = getNoAtRank(r);
        Object removido = alvo.elem;

        alvo.prev.next = alvo.next;
        alvo.next.prev = alvo.prev;
        n--;

        return removido;
    }
}