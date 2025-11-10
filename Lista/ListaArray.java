public class ListaArray {
    private Object[] array;
    private int n;

    public ListaArray(int capacidade) {
        array = new Object[capacidade];
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

    public boolean isFirst(int i) {
        if (i == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLast(int i) {
        if (i == n-1) {
            return true;
        } else {
            return false;
        }
    }

    public Object first() {
        if (isEmpty()) {
            throw new RuntimeException("Lista Vaiza");
        }
        return array[0];
    }

    public Object last() {
        if (isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }
        return array[n-1];
    }

    public Object before(int p) {
        if (p <= 0 || p >= n) {
            throw new RuntimeException("Posição errada");
        }
        return array[p - 1];
    }

    public Object after(int p) {
        if (p < 0 || p >= n - 1) {
            throw new RuntimeException("Posição errada");
        }
        return array[p + 1];
    }    

    public Object replaceElement(int p, Object o) {
        if (p < 0 || p >= n) {
            throw new RuntimeException("Posição errada");
        }
        Object antigo = array[p];
        array[p] =  o;
        return antigo;
    }

    public void swapElements(int p, int q) {
        if (p < 0 || q < 0 || p >= n || q >= n) {
            throw new RuntimeException("Posição errada");
        }
        Object troca = array[p];
        array[p] = array[q];
        array[q] = troca;
    }

    public void insertBefore(int p, Object o) {
        if (p < 0 || p > n) {
            throw new RuntimeException("Posição errada");
        }
        if (n == array.length) {
            expandir();
        }
        for ( int i = n - 1; i >= p; i--) {
            array[i + 1] = array[i];
        }
        array[p] = o;
        n++;
    }

    public void insertAfter(int p, Object o) {
        if (p < 0 || p >= n) {
            throw new RuntimeException("Posição errada");
        }
        if (n == array.length) {
            expandir();
        }
        for ( int i = n - 1; i > p; i--) {
            array[i + 1] = array[i];
        }
        array[p + 1] = o;
        n++;
    }

    public void insertFirst(Object o) {
        if (n == array.length) {
            expandir();
        }

        for (int i = n - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }

        array[0] = o;
        n++;
    }

    public void insertLast(Object o) {
        if (n == array.length) {
            expandir();
        }
        array[n] = o;
        n++;
    }

    public Object remove(int p) {
        if (p < 0 || p >= n) {
            throw new RuntimeException("Posição errada");
        }
        Object removido = array[p];
        for (int i = p; i < n-1; i++) {
            array[i] = array[i + 1];
        }
        array[n-1] = null;
        n--;
        return removido;
    }

    private void expandir() {
        Object[] novo = new Object[array.length * 2];
        for (int i = 0; i < n; i++) {
            novo[i] = array[i];
        }
        array = novo;
    }

}