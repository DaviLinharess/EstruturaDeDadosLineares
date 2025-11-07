public class VetorArray{
    private Object[] array;         // Array dos objetos
    private int n;                  // total de elementos (size)

    public VetorArray(int capacidade) {
        array = new Object[capacidade];
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if (n ==0){
            return true;
        }
        return false;
    }

    public Object elemAtRank(int r) {
        if (r < 0 || r >= n) {
            throw new RuntimeException("Rank fora do Array");
        }
        return array[r];
    }

    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > n) {
            throw new RuntimeException("Rank fora do Array");
        }

        if (n == array.length) {
            Object novoArray[] = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++){
                novoArray[i] = array[i];  
            }
            array = novoArray;
        }

        for (int i = n-1; i >= r; i--) {
            array[i + 1] = array[i];
        }

        array[r] = o;
        n++;
    }


    public Object replaceAtRank(int r, Object o) {
        if (r < 0 || r >= n) {
            throw new RuntimeException("Rank fora do Array");
        }
        Object antigo = array[r];
        array[r] = o;
        return antigo;
    }

    public Object removeAtRank(int r) {
        if (r < 0 || r >= n) {
            throw new RuntimeException("Rank fora do Array");
        }

        Object removido = array[r];
        for (int i = r; i < n - 1; i++) {
            array[i] = array[i+1];
        }

        array[n - 1] = null;
        n--;
        return removido;
    }
}