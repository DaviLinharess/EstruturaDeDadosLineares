public class No {
    private int elemento;
    private No pai;
    private No esquerdo;
    private No direito;

    public No (int elemento, No pai) {
        this.elemento = elemento;
        this.pai = pai;
        this.esquerdo = null;
        this.direito = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public No setDireito(No direito) {
        this.direito = direito;
    }

    public boolean temEsquerdo() {
        return esquerdo != null;
    }

    public boolean temDireito() {
        return direito != null;
    }

    public boolean ehExterno() {
        return esquerdo == null && direito == null;
    }

    public boolean ehInterno() {
        return ! ehExterno();
    }
}