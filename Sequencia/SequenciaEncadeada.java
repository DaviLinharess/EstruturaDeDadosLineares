public class SequenciaEncadeada {

    public static class No {
        Object elem;
        No prev;
        No next;

        No (Object e, No p, No n) {
            elem = e;
            prev = p;
            next = n;
        }
    }
    public No head;
    public No tail;
    public int n;

    public SequenciaEncadeada() {
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

    public No first() {
        if (isEmpty()){
            throw new RuntimeException("Sequencia Vazia");
        }
        return head.next;
    }

    public No last() {
        if (isEmpty()){
            throw new RuntimeException("Sequencia Vazia");
        }
        return tail.prev;
    }

    public No before(No no) {
        if (no == head || no.prev == head) {
            throw new RuntimeException("Não tem Nó antes dele.");
        }
        return no.prev;
    }

    public No after(No no) {
        if (no == tail || no.next == tail) {
            throw new RuntimeException("Não tem Nó depois dele");
        }
        return no.next;
    }
        
    public Object replaceElement(No no, Object o) {
        Object antigo = no.elem;
        no.elem = o;
        return antigo;
    }

    public void swapElements(No no1, No no2) {
        Object troca = no1.elem;
        no1.elem = no2.elem;
        no2.elem = troca;
    }

    public void insertBefore(No no, Object o) {
        if (no == head) {
            throw new RuntimeException("Não pode colocar fora da Sequencia.");
        }

        No novo = new No(o, no.prev,no);
        no.prev.next = novo;
        no.prev = novo;
        n++;
    }

    public void insertAfter(No no, Object o) {
        if (no == tail) {
            throw new RuntimeException("Não pode colocar fora da Sequencia.");
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

    //Começa agora a parte do TAD Vetor

    private No getNoAtRank(int r) {
        if (r < 0 || r >= n) {
            throw new RuntimeException("Rank não tem na Sequencia");
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
            throw new RuntimeException("Rank não tem na Sequencia");
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
            throw new RuntimeException("Rank não tem na Sequencia");
        }

        No alvo = getNoAtRank(r);
        Object removido = alvo.elem;

        alvo.prev.next = alvo.next;
        alvo.next.prev = alvo.prev;
        n--;

        return removido;
    }

    //Métodos ponte: atRank e rankOf

    public No atRank (int r) {
        if (r < 0 || r >= n) {
            throw new RuntimeException("Rank não tem na Sequencia");
        }

        No no;
        if (r <= n/2) {
            no = head.next;
            for (int i = 0; i < r; i++) {
                no = no.next;
            }
        } else {
            no = tail.prev;
            for (int i = 0; i < n - r - 1; i++) {
            no = no.prev;
            }
        }
        return no;
    }

    public int rankOf(No no) {
        if (no == head || no == tail) {
            throw new RuntimeException("Sentinelas não tem rank.");
        }

        No atual = head.next;
        int r = 0;
        while (atual != tail) {
            if (atual == no){
                return r;
            }
            atual = atual.next;
            r++;
        }
        throw new RuntimeException("Nó não tem na sequência.");
    }
}